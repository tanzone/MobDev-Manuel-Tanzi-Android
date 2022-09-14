package unipr.tanzone.weather.model;

public class Day {

    private Double maxtemp_c;

    private Double maxtemp_f;

    private Double mintemp_c;

    private Double mintemp_f;

    private Double avgtemp_c;

    private Double avgtemp_f;

    private Double maxwind_mph;

    private Double maxwind_kph;

    private Double totalprecip_mm;

    private Double totalprecip_in;

    private Double avgvis_km;

    private Double avgvis_miles;

    private Double avghumidity;

    private Double daily_will_it_rain;

    private Double daily_chance_of_rain;

    private Double daily_will_it_snow;

    private Double daily_chance_of_snow;

    private Condition condition;

    private Double uv;

    public Double getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(Double maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public Double getMaxtemp_f() {
        return maxtemp_f;
    }

    public void setMaxtemp_f(Double maxtemp_f) {
        this.maxtemp_f = maxtemp_f;
    }

    public Double getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(Double mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public Double getMintemp_f() {
        return mintemp_f;
    }

    public void setMintemp_f(Double mintemp_f) {
        this.mintemp_f = mintemp_f;
    }

    public Double getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(Double avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public Double getAvgtemp_f() {
        return avgtemp_f;
    }

    public void setAvgtemp_f(Double avgtemp_f) {
        this.avgtemp_f = avgtemp_f;
    }

    public Double getMaxwind_mph() {
        return maxwind_mph;
    }

    public void setMaxwind_mph(Double maxwind_mph) {
        this.maxwind_mph = maxwind_mph;
    }

    public Double getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(Double maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public Double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(Double totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public Double getTotalprecip_in() {
        return totalprecip_in;
    }

    public void setTotalprecip_in(Double totalprecip_in) {
        this.totalprecip_in = totalprecip_in;
    }

    public Double getAvgvis_km() {
        return avgvis_km;
    }

    public void setAvgvis_km(Double avgvis_km) {
        this.avgvis_km = avgvis_km;
    }

    public Double getAvgvis_miles() {
        return avgvis_miles;
    }

    public void setAvgvis_miles(Double avgvis_miles) {
        this.avgvis_miles = avgvis_miles;
    }

    public Double getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(Double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Double getDaily_will_it_rain() {
        return daily_will_it_rain;
    }

    public void setDaily_will_it_rain(Double daily_will_it_rain) {
        this.daily_will_it_rain = daily_will_it_rain;
    }

    public Double getDaily_chance_of_rain() {
        return daily_chance_of_rain;
    }

    public void setDaily_chance_of_rain(Double daily_chance_of_rain) {
        this.daily_chance_of_rain = daily_chance_of_rain;
    }

    public Double getDaily_will_it_snow() {
        return daily_will_it_snow;
    }

    public void setDaily_will_it_snow(Double daily_will_it_snow) {
        this.daily_will_it_snow = daily_will_it_snow;
    }

    public Double getDaily_chance_of_snow() {
        return daily_chance_of_snow;
    }

    public void setDaily_chance_of_snow(Double daily_chance_of_snow) {
        this.daily_chance_of_snow = daily_chance_of_snow;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "Day{" +
                "maxtempC=" + maxtemp_c +
                ", maxtempF=" + maxtemp_f +
                ", mintempC=" + mintemp_c +
                ", mintempF=" + mintemp_f +
                ", avgtempC=" + avgtemp_c +
                ", avgtempF=" + avgtemp_f +
                ", maxwindMph=" + maxwind_mph +
                ", maxwindKph=" + maxwind_kph +
                ", totalprecipMm=" + totalprecip_mm +
                ", totalprecipIn=" + totalprecip_in +
                ", avgvisKm=" + avgvis_km +
                ", avgvisMiles=" + avgvis_miles +
                ", avghumidity=" + avghumidity +
                ", dailyWillItRain=" + daily_will_it_rain +
                ", dailyChanceOfRain=" + daily_chance_of_rain +
                ", dailyWillItSnow=" + daily_will_it_snow +
                ", dailyChanceOfSnow=" + daily_chance_of_snow +
                ", condition=" + condition +
                ", uv=" + uv +
                '}';
    }
}
