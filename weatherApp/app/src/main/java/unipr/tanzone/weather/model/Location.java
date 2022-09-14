package unipr.tanzone.weather.model;


public class Location {

    private String name;

    private String region;
  
    private String country;

    private Double lat;

    private Double lon;

    private String tz_id;
 
    private Integer localtime_epoch;

    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTzId() {
        return tz_id;
    }

    public void setTzId(String tzId) {
        this.tz_id = tzId;
    }

    public Integer getLocaltimeEpoch() {
        return localtime_epoch;
    }

    public void setLocaltimeEpoch(Integer localtimeEpoch) {
        this.localtime_epoch = localtimeEpoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", tzId='" + tz_id + '\'' +
                ", localtimeEpoch=" + localtime_epoch +
                ", localtime='" + localtime + '\'' +
                '}';
    }
}
