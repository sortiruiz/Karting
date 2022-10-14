package com.example.karting;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Principal_Usuario extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__usuario);

        //aqui debemos de añadir nuestra toolbar

        Toolbar bar = (Toolbar) findViewById(R.id.barra);
        setSupportActionBar(bar);
        //los botones y demas se añaden en un xml de menu. que luego se añadira a esta toolbar



        // lo principal será conectarse a Firebase y descargar todos los datos
        //rellenar la tabla.

        //asociamos a objetos todos los elementos
        ImageView imagenUsuario = (ImageView)findViewById(R.id.imagenUsuario);
        TableLayout tablaTiempos = (TableLayout)findViewById(R.id.tabla_mejoresResultados);
        EditText nombreUsuario = (EditText)findViewById(R.id.nombre_usuario);
        EditText apellidosUsuario = (EditText)findViewById(R.id.apellidos_usuario);
        EditText ubicacionUsuario = (EditText)findViewById(R.id.ubicacion_usuario);

        //asociamos a la toolbar el menu que hemos creado, debemos de hacer un inglate


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
