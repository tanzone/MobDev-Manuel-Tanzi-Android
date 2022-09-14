package unipr.tanzone.weather.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManagment {

    public static String key = "168f8813553d35145e3972af84262fb4";

    public static WeatherApi getApiWeather(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://weatherapi-com.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WeatherApi.class);
    }

    public static WeatherApi getApiAddress(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/geo/1.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WeatherApi.class);
    }
}
