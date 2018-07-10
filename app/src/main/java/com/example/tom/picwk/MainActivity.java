package com.example.tom.picwk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sends(View w) throws IOException {
        EditText  txtEdit = (EditText) findViewById(R.id.editText);

        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        intent.putExtra("url", txtEdit.getText().toString());
        startActivity(intent);

    }

}

