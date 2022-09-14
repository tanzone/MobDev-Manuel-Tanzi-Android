# # MobDev-Manuel-Tanzi-Android

#### Sviluppare un’applicazione per la visualizzazione della condizioni meteorologiche:
- L’utente visualizza le condizioni meteorologiche attuali e previste per i prossimi N giorni nella sua posizione attuale.
- L’utente inserisce una città e visualizza le condizioni meteorologiche attuali e previste per i prossimi N giorni. 
- L’utente può decidere di salvare la città come “preferita” ed aggiungerla ad una lista di città preferite per un accesso più rapido. 
- La lista delle città preferite può essere visualizzata su una mappa mettendo come marker un’icona legata alla condizione del meteo.


# API

Le API sono la parte fondamentale di questo progetto in quanto si necessitano informazioni reperibili solamente online circa le condizioni metereologiche.
Purtroppo molti servizi richiedono un pagamento per reperire informazioni extra e utili al completamento del progetto in maniera esaustiva e approfondita
 **OpenWeatherMap** è uno dei servizi che utilizzo in quanto mi permette di trasformare un punto (latitudine, longitudine) in nome di città e viceversa, quindi, città in latitudine e longitudine.
 **RapidApi** è un sito che mette a disposizione a diversi sviluppatori api creati da differenti utenti e attraverso l'iscrizione, gratuita o a pagamento, si possono sfruttare differenti servizi. 
 > **Nota:** La grafica è stata impostata per riceve fino a 6 giorni successivi, il servizio dopo alcuni aggiornamenti, attraverso il servizio gratuito, è possibile reperire solo fino a 3 giorni successivi. Per cui, dato questo problema, i 3 giorni mancanti sono una replica dei giorni ricevuti. In ogni caso il codice è stato preimpostato in maniera tale che se si decidesse di sottoscrivere un abbonamento al servizio le caselle si riempirebbero secondo i dati corretti.

# Lettura API
Viene utilizzato ed importato **Retrofit2**.
Retrofit trasforma la tua API HTTP in un'interfaccia Java.
##### Usa le annotazioni per descrivere la richiesta HTTP:
- Sostituzione dei parametri URL e supporto dei parametri di query.
- Conversione dell'oggetto nel corpo della richiesta (ad es. JSON, buffer di protocollo).
- Corpo della richiesta in più parti e caricamento del file.

Inoltre viene anche implementata la conversione tramite **Gson** che leggendo il json di ritorno dal servizio di retrofit riesce a riempire i campi con le classi abbinate allo schema strutturale del file json ottenuto tramite api.


# Salvataggio dati
Per il salvataggio dei dati, in questo caso delle città preferite viene utilizzata **SharedPreference**.
Interfaccia per l'accesso e la modifica dei dati delle preferenze restituiti da **Context.getSharedPreferences(String, int)**. Per ogni particolare insieme di preferenze, esiste una singola istanza di questa classe condivisa da tutti i client. Le modifiche alle preferenze devono passare attraverso un oggetto Editor per garantire che i valori delle preferenze rimangano in uno stato coerente e controllino quando vengono salvati nell'archiviazione. Gli oggetti restituiti dai vari metodi get devono essere trattati come immutabili dall'applicazione.

 > **Nota:** questa classe fornisce forti garanzie di coerenza. Utilizza operazioni costose che potrebbero rallentare un'app. Le proprietà che cambiano frequentemente o le proprietà in cui la perdita può essere tollerata dovrebbero utilizzare altri meccanismi. Per maggiori dettagli leggi i commenti su Editor#commit() e Editor#apply().


# Grafica
La grafica viene ottimizzata per diversi dispositivi con l'uso dei **"constraints"** che rendono modificabile il layout in base al dispositivo in maniera tale che si possano mantenere le distanze dagli oggetti anche utilizzando diversi dispositivi con uno schermo da diversi pollici.
In ogni caso all'avvio dell'applicazione decido di ridimensionare manualmente la view principale andando a leggere la dimensione dello schermo.
>**TIPS:** Lo sfondo della schermata principale cambia in base alla fascia orario del paese in cui viene fatta la ricerca. 
>Sono presenti 4 schermate: **Giorno**,  **Pomeriggio**, **Sera**, **Pioggia**.

# Permessi
>android.permission.ACCESS_FINE_LOCATION
android.permission.ACCESS_COARSE_LOCATION  
android.permission.INTERNET  
android.permission.WRITE_EXTERNAL_STORAGE"  
android.permission.READ_EXTERNAL_STORAGE 
com.google.android.providers.gsf.permission.READ_GSERVICES

# NOTE PERSONALI
All'avvio dell'applicazione se non è attivo il gps per la ricerca della posizione dell'utente in tempo attuale, questa viene richiesta con una form con richiesta *YES* or *NO*.
Nel caso in cui non si riesca ad accedere alla posizione ho messo come posizione standard anche in caso di qualsiasi tipologia di errore *Parma*.
Inoltre per visualizzare la mappa con le figure delle condizioni metereologiche si deve necessariamente prima installare sul simulatore i servizi di *Google play services*.
Per l'inserimento delle immagine viene adibito un thread apposito che si occupa del caricamento delle immagini siccome sono prese da internet tramite il link fornito dall'api apposito coerente con la condizione metereologica in quell'istante.
