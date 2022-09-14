package unipr.tanzone.weather.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class GPS extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    private final LocationManager locationManager;
    private String lat, lon;

    public GPS(Activity activity, Context context, LocationManager locationManager)
    {
        //Add permission
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        //Initialize
        this.locationManager = locationManager;
        //Check if gps is enable or not
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
            activeGps(activity, context);
        else
            getLocation(activity, context);
    }

    private void getLocation(Activity activity, Context context) {
        if((ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) &&
        (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED))
        {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
        else
        {
            android.location.Location locGps = this.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            android.location.Location locNet = this.locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            android.location.Location locPass = this.locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if(locGps != null)
            {
                this.lat = String.valueOf(locGps.getLatitude());
                this.lon = String.valueOf(locGps.getLongitude());
            }
            else if(locNet != null)
            {
                this.lat = String.valueOf(locNet.getLatitude());
                this.lon = String.valueOf(locNet.getLongitude());
            }
            else if(locPass != null)
            {
                this.lat = String.valueOf(locPass.getLatitude());
                this.lon = String.valueOf(locPass.getLongitude());
            }
            else
                Toast.makeText(context, "Can't get Your Location", Toast.LENGTH_SHORT).show();
        }
    }

    private void activeGps(Activity activity, Context context)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES",
                (dialogInterface, i) -> startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))).setNegativeButton("NO",
                (dialogInterface, i) -> dialogInterface.cancel());
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
