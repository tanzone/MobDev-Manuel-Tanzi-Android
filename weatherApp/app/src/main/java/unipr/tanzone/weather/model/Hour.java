package unipr.tanzone.weather.model;


public class Hour {

    private Double time_epoch;

    private String time;

    private Double temp_c;

    private Double temp_f;

    private Double is_day;

    private Condition condition;

    private Double windMph;

    private Double wind_kph;

    private Double wind_degree;

    private String wind_dir;

    private Double pressure_mb;

    private Double pressure_in;
 
    private Double precip_mm;

    private Double precip_in;

    private Double humidity;

    private Double cloud;

    private Double feelslikeC;

    private Double feelslikeF;

    private Double windchillC;

    private Double windchillF;

    private Double heatindexC;

    private Double heatindexF;

    private Double dewpointC;

    private Double dewpointF;

    private Double willItRain;

    private Double chanceOfRain;

    private Double willItSnow;

    private Double chanceOfSnow;

    private Double visKm;

    private Double visMiles;

    private Double gustMph;

    private Double gustKph;

    private Double uv;

    public Double getTime_epoch() {
        return time_epoch;
    }

    public void setTime_epoch(Double time_epoch) {
        this.time_epoch = time_epoch;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Double temp_f) {
        this.temp_f = temp_f;
    }

    public Double getIs_day() {
        return is_day;
    }

    public void setIs_day(Double is_day) {
        this.is_day = is_day;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getWindMph() {
        return windMph;
    }

    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Double getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(Double wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Double getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Double pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Double getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(Double precip_in) {
        this.precip_in = precip_in;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getCloud() {
        return cloud;
    }

    public void setCloud(Double cloud) {
        this.cloud = cloud;
    }

    public Double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public Double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public Double getWindchillC() {
        return windchillC;
    }

    public void setWindchillC(Double windchillC) {
        this.windchillC = windchillC;
    }

    public Double getWindchillF() {
        return windchillF;
    }

    public void setWindchillF(Double windchillF) {
        this.windchillF = windchillF;
    }

    public Double getHeatindexC() {
        return heatindexC;
    }

    public void setHeatindexC(Double heatindexC) {
        this.heatindexC = heatindexC;
    }

    public Double getHeatindexF() {
        return heatindexF;
    }

    public void setHeatindexF(Double heatindexF) {
        this.heatindexF = heatindexF;
    }

    public Double getDewpointC() {
        return dewpointC;
    }

    public void setDewpointC(Double dewpointC) {
        this.dewpointC = dewpointC;
    }

    public Double getDewpointF() {
        return dewpointF;
    }

    public void setDewpointF(Double dewpointF) {
        this.dewpointF = dewpointF;
    }

    public Double getWillItRain() {
        return willItRain;
    }

    public void setWillItRain(Double willItRain) {
        this.willItRain = willItRain;
    }

    public Double getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(Double chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public Double getWillItSnow() {
        return willItSnow;
    }

    public void setWillItSnow(Double willItSnow) {
        this.willItSnow = willItSnow;
    }

    public Double getChanceOfSnow() {
        return chanceOfSnow;
    }

    public void setChanceOfSnow(Double chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
    }

    public Double getVisKm() {
        return visKm;
    }

    public void setVisKm(Double visKm) {
        this.visKm = visKm;
    }

    public Double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(Double visMiles) {
        this.visMiles = visMiles;
    }

    public Double getGustMph() {
        return gustMph;
    }

    public void setGustMph(Double gustMph) {
        this.gustMph = gustMph;
    }

    public Double getGustKph() {
        return gustKph;
    }

    public void setGustKph(Double gustKph) {
        this.gustKph = gustKph;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "HourInfo{" +
                "timeEpoch=" + time_epoch +
                ", time='" + time + '\'' +
                ", tempC=" + temp_c +
                ", tempF=" + temp_f +
                ", isDay=" + is_day +
                ", condition=" + condition +
                ", windMph=" + windMph +
                ", windKph=" + wind_kph +
                ", windDegree=" + wind_degree +
                ", windDir='" + wind_dir + '\'' +
                ", pressureMb=" + pressure_mb +
                ", pressureIn=" + pressure_in +
                ", precipMm=" + precip_mm +
                ", precipIn=" + precip_in +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", feelslikeC=" + feelslikeC +
                ", feelslikeF=" + feelslikeF +
                ", windchillC=" + windchillC +
                ", windchillF=" + windchillF +
                ", heatindexC=" + heatindexC +
                ", heatindexF=" + heatindexF +
                ", dewpointC=" + dewpointC +
                ", dewpointF=" + dewpointF +
                ", willItRain=" + willItRain +
                ", chanceOfRain=" + chanceOfRain +
                ", willItSnow=" + willItSnow +
                ", chanceOfSnow=" + chanceOfSnow +
                ", visKm=" + visKm +
                ", visMiles=" + visMiles +
                ", gustMph=" + gustMph +
                ", gustKph=" + gustKph +
                ", uv=" + uv +
                '}';
    }
}
