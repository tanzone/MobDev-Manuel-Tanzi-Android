package unipr.tanzone.weather.model;

import java.util.List;

public class DayInfo {

    private String date;

    private Integer date_epoch;

    private Day day;

    private Astro astro;

    private List<Hour> hour = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDate_epoch() {
        return date_epoch;
    }

    public void setDate_epoch(Integer date_epoch) {
        this.date_epoch = date_epoch;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public List<Hour> getHour() {
        return hour;
    }

    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "DayInfo{" +
                "date='" + date + '\'' +
                ", dateEpoch=" + date_epoch +
                ", day=" + day +
                ", astro=" + astro +
                ", hour=" + hour +
                '}';
    }
}
