package unipr.tanzone.weather.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unipr.tanzone.weather.activity.databinding.ActivityMapsBinding;
import unipr.tanzone.weather.api.ApiManagment;
import unipr.tanzone.weather.api.WeatherApi;
import unipr.tanzone.weather.model.Pointer;
import unipr.tanzone.weather.model.Schema;
import unipr.tanzone.weather.settings.UserSettings;
import unipr.tanzone.weather.thread.FetchMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Map<Marker, Pointer> poiMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        initMap();
        getSharedList();
    }

    private void initMap() {

        mMap.setOnMarkerClickListener(marker -> {

            if (poiMap.containsKey(marker)) {
                Pointer myPoiDescriptor = poiMap.get(marker);
                Log.d("weatherApp", "MainActivity ---> onMarkerClick of PoiDescriptor: " + myPoiDescriptor.getName());
            }
            //True if we want that the event has been consumed or false to propagate it
            return false;
        });

        mMap.setOnInfoWindowClickListener(marker -> {

            if (poiMap.containsKey(marker)) {
                Pointer myPoiDescriptor = poiMap.get(marker);
                Log.d("weatherApp", "MainActivity ---> onInfoWindowClickListener of PoiDescriptor: " + myPoiDescriptor.getName());
            }

        });
    }

    private void getSharedList() {
        List<String> listCity = UserSettings.readListPref(this);
        if(listCity == null) listCity = new ArrayList<>();
        if(!listCity.isEmpty())
        {
            this.poiMap = new HashMap<>();
            for (String city: listCity)
                requestWeather(city, "1");
        }
    }

    private void requestWeather(String cityName, String numDays)
    {
        WeatherApi myApi = ApiManagment.getApiWeather();
        Call<Schema> currWeather = myApi.getWeather(cityName, numDays);
        currWeather.enqueue(new Callback<Schema>() {
            @Override
            public void onResponse(Call<Schema> call, Response<Schema> response) {
                if(response.code()==404)
                    Toast.makeText(MapsActivity.this, "Error to take city name", Toast.LENGTH_LONG).show();

                else if(!(response.isSuccessful()))
                    Toast.makeText(MapsActivity.this, "Bad request Weather", Toast.LENGTH_LONG).show();
                else
                    setMapPointer(response.body());
            }
            @Override
            public void onFailure(Call<Schema> call, Throwable t) {
                Toast.makeText(MapsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setMapPointer(Schema body)
    {
        double lat = body.getLocation().getLat();
        double lon = body.getLocation().getLon();
        String name = body.getLocation().getName();
        String description = body.getCurrent().getCondition().getText();
        String icon = body.getCurrent().getCondition().getIcon();
        Pointer pointer = new Pointer(lat, lon, name, description, icon);
        setMapMarker(pointer);
    }

    private void setMapMarker(Pointer pointer) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(pointer.getName());
        markerOptions.snippet(pointer.getDescription());
        markerOptions.position(new LatLng(pointer.getLat(), pointer.getLon()));

        try {
            FetchMap fetchMap = new FetchMap("https:"+pointer.getIcon(), this.getResources());
            Thread thread = new Thread(fetchMap);
            thread.start();
            thread.join();

            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(fetchMap.getIcon(), 150, 150, false)));
        }
        catch (InterruptedException e)
        {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.no_found));
        }



        Marker marker = this.mMap.addMarker(markerOptions);
        this.poiMap.put(marker, pointer);
    }
}