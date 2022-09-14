package unipr.tanzone.weather.thread;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import unipr.tanzone.weather.activity.R;

public class FetchMap implements Runnable {

    private String urlIcon;
    private Resources resource;

    private Bitmap icon;

    public FetchMap(String urlIcon, Resources resource)
    {
        this.urlIcon = urlIcon;
        this.resource = resource;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(urlIcon);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            icon = BitmapFactory.decodeStream(input);
        }
        catch (Exception e) {
            Log.d("ciao", "ciao1");
            e.printStackTrace();
            icon = BitmapFactory.decodeResource(resource, R.drawable.no_found);
        }
    }


    public Bitmap getIcon() {
        return icon;
    }
}
