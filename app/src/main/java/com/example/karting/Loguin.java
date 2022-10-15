package com.example.karting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

/*
        //Toolbar
        Toolbar barra = (Toolbar)findViewById(R.id.barra);
        setSupportActionBar(barra);

        barra.setTitle("Pagina Loguin");

        //*****!!!!!!!!!!!

*/
        //asociamos acciones a cada uno de estos botones.

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //conectamos con la base de datos y hacemos unr registro.

            }
        });

        bLoguin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui debemos de conectarnos con la base de datos de
                // Firebase para intentar  loguearse
                attempLoguin();
            }
        });
    }

    private void attempLoguin() {
        //funcion que usaremos para intentar loguearnos

        if(!(tUser.getText().toString().isEmpty() && tContra.getText().toString().isEmpty())){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(tUser.getText().toString(), tContra.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Loguin.this, "Logueado!",Toast.LENGTH_LONG)
                                .show();
                        //intent a la siguiente hoja
                        //si da ok entonces ...
                        Intent i = new Intent(Loguin.this, Principal_Usuario.class);
                        i.putExtra("usuario",tUser.getText().toString());
                        startActivity(i); //funciona perfectamente.

                    }else{
                        Toast.makeText(Loguin.this,task.getException().getMessage(),Toast.LENGTH_LONG);
                    }
                }
            });

        }

    }
}