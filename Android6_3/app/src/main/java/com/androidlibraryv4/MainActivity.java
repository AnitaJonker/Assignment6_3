package com.androidlibraryv4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anita.androidlibraryv4.R;

public class MainActivity extends AppCompatActivity {
private static Button btnEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButtonListener(View v)
    {
        Intent intent = new Intent(this, ActivityChooseField.class);
        startActivity(intent);
    }
}
