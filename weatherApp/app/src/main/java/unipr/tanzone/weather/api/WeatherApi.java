package unipr.tanzone.weather.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import unipr.tanzone.weather.model.Address;
import unipr.tanzone.weather.model.Schema;

public interface WeatherApi {
    @Headers({
            "X-RapidAPI-Key: 024f8fa41dmsh8ce94befd8c9bb9p123b26jsn009e9408682e",
            "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
    })
    @GET("forecast.json")
    Call<Schema> getWeather(@Query("q") String cityName, @Query("days") String numDays);


    @GET("reverse")
    Call<List<Address>> getCurrAddress(@Query("lat") String lat, @Query("lon") String lon, @Query("limit") String limit, @Query("appid") String apiKey);








}
