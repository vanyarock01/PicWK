package com.example.tom.picwk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {



    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sends(View w) throws IOException {
        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        EditText  txtEdit = (EditText) findViewById(R.id.editText);

        String text = txtEdit.getText().toString();

        //Bitmap image = getBitmapFromURL(text);
        //System.out.println(image);
       //Uri imgUri=Uri.parse("android.resource://com.example.tom.picwk/look.jpg");
        imgView.setImageURI(null);
        Picasso.get().load(text).into(imgView);
        //URL newurl = new URL(text);
        //Bitmap image= BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
        //imgView.setImageBitmap(image);
        //imgView.setImageURI(imgUri);
        //imgView.setImageURI(Uri.parse("file://mnt/sdcard/cat.jpg"));
        //imgView.setImageBitmap(image);

    }

}

