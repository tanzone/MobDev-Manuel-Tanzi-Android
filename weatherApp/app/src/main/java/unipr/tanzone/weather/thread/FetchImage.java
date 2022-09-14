package unipr.tanzone.weather.thread;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;

import unipr.tanzone.weather.activity.R;


public class FetchImage extends Thread{

    private String URL;
    private Bitmap bitmap;
    private Context context;
    private ImageView imageview;

    private Handler mainHandler;

    public FetchImage(String URL, Context context, ImageView imageview){
        this.URL = URL;
        this.context = context;
        this.imageview = imageview;
        this.mainHandler = new Handler();
    }

    @Override
    public void run() {
        InputStream inputStream;
        try {
            inputStream = new java.net.URL(this.URL).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        }
        catch (Exception e)
        {
            bitmap = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.no_found);
        }

        mainHandler.post(() -> imageview.setImageBitmap(bitmap));
    }
}