package com.example.karting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.Principal;

public class Loguin extends AppCompatActivity {

    private TextView mTextView;
    EditText tUser, tContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);

        //Asociamos a nuevos objetos que usaremos para loguearnos
        mTextView = (TextView) findViewById(R.id.text);
        tUser = (EditText) findViewById(R.id.tUser);
        tContra = (EditText) findViewById(R.id.tContra);
        Button bRegistrar = (Button) findViewById(R.id.botonRegistrar);
        Button bLoguin = (Button) findViewById(R.id.botonLoguin);
        ;

        //asociamos acciones a cada uno de estos botones.

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conectamos con la base de datos y hacemos unr registro.
                attempLoguin();
            }
        });

        bLoguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui debemos de conectarnos con la base de datos de
                // Firebase para intentar  loguearse
            }
        });
    }

    private void attempLoguin() {
        //funcion que usaremos para intentar loguearnos

        //si da ok entonces ...
        Intent i = new Intent(this, Principal_Usuario.class);
        startActivity(i);

    }
}