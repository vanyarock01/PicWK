package com.example.tom.picwk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    public int idx_image = 0;
    public JSONArray image_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String url = getIntent().getExtras().getString("url");
       // ArrayList<String> tags = getIntent().getExtras().getStringArrayList("tags");

        try {
            JSONArray tags_list = new JSONArray(getIntent().getExtras().getString("tags"));
            String tags = "";
            for (int i = 0; i < tags_list.length(); i++) {
                tags += tags_list.getString(i) + " ";
            }
            TextView  txtView = (TextView) findViewById(R.id.textView4);
            txtView.setText(tags);
            image_list = new JSONArray(url);
            ImageView imgView = (ImageView)findViewById(R.id.imageView);
            imgView.setImageURI(null);
            Picasso.get().load(image_list.getString(idx_image)).into(imgView);

        } catch (JSONException e) {
            e.printStackTrace();
            Intent intent = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void back(View w) {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void prev(View w) {
        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        if(idx_image > 0) {
            try {
                idx_image--;
                Picasso.get().load(image_list.getString(idx_image)).into(imgView);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void next(View w) throws IOException {
        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        if(idx_image < image_list.length() - 1) {
            try {
                idx_image++;
                Picasso.get().load(image_list.getString(idx_image)).into(imgView);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
