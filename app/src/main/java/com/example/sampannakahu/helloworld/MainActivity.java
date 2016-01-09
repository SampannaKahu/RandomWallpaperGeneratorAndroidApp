package com.example.sampannakahu.helloworld;

import android.app.AlarmManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //Changing policies to allow download of JSON from the internet.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final Random random = new Random();

        final Button changeWallpaperButton = (Button) findViewById(R.id.change_wallpaper);
        changeWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) findViewById(R.id.status_value_text_view);
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                if (true) {
                    textView.append("Wallpaper change supported!\n");
                    try {
                        int min = 0;
                        int max = 20;
                        int randomIndex = random.nextInt(max - min) + min;
                        JSONObject jsonObject = readJsonFromUrl("http://www.bing.com/HPImageArchive.aspx?format=js&idx="+Integer.toString(randomIndex)+"&n=1&mkt=en-US");
                        textView.append("JSON obtained!\n");
                        JSONArray jsonArray = jsonObject.getJSONArray("images");
                        JSONObject image = jsonArray.getJSONObject(0);
                        String myUrl = image.get("url").toString();
                        textView.append("URL obtained: " + myUrl + "\n");
                        myUrl = "http://www.bing.com" + myUrl;
                        Bitmap bitmap = getBitmapFromURL(myUrl);
                        ImageView imageView = (ImageView) findViewById(R.id.photo_image_view);
                        imageView.setImageBitmap(bitmap);
                        wallpaperManager.setBitmap(bitmap);
                    } catch (IOException e) {
                        textView.append("IOException: Cannot get JSON from bing!\n");
                        e.printStackTrace();
                    } catch (JSONException e) {
                        textView.append("JSONException: Received malformed JSON from bing!\n");
                        e.printStackTrace();
                    }

                } else {
                    textView.setText("Wallpaper change is not supported!\n");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Logger logger = Logger.getLogger("something");
        logger.info("Here-----------------");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean setRegularTimer(int interval) {
        Context context = getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);

        return true;
    }
}
