package unipr.tanzone.weather.model;

public class Pointer {

    private double lat;
    private double lon;
    private String name;
    private String description;
    private String icon;

    public Pointer(double lat, double lon, String name, String description, String icon) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLon() {
        return lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setIcon(String icon) {this.icon = icon;}

    public String getIcon() {return icon;}

    @Override
    public String toString() {
        return "Pointer{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
