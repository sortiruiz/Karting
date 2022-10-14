package com.example.karting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vamos a hacer un intent para empezar con nuestro logueo .
        Intent i  = new Intent(this, Loguin.class);
        startActivity(i);

    }
}