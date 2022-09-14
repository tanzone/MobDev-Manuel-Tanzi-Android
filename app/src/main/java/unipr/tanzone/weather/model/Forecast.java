package unipr.tanzone.weather.model;

import java.util.List;

public class Forecast {

    private List<DayInfo> forecastday = null;

    public void setForecastday(List<DayInfo> forecastday) {
        this.forecastday = forecastday;
    }

    public List<DayInfo> getForecastday() {
        return forecastday;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "forecastday=" + forecastday +
                '}';
    }
}
