package com.example.tom.picwk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String url = getIntent().getExtras().getString("url");
        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setImageURI(null);
        Picasso.get().load(url).into(imgView);

    }

    public void back(View w) throws IOException {
        Intent intent = new Intent(AboutActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
