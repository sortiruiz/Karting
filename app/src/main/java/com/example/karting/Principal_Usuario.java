package com.example.karting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Principal_Usuario extends AppCompatActivity {

    private static final String TAG = "Karting";
    FirebaseFirestore ff =  FirebaseFirestore.getInstance();
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__usuario);


        Intent i = new Intent();
        String usuario = (String) i.getStringExtra("usuario");
        //aqui debemos de añadir nuestra toolbar

        Toolbar bar = (Toolbar) findViewById(R.id.barra);
        setSupportActionBar(bar);
        //los botones y demas se añaden en un xml de menu. que luego se añadira a esta toolbar



        // lo principal será conectarse a Firebase y descargar todos los datos
        //rellenar la tabla.

        //asociamos a objetos todos los elementos
        TableLayout tablaTiempos = (TableLayout)findViewById(R.id.tabla_mejoresResultados);

        rellenarCamposUsuario(usuario);
        rellenarDatosTablaMejoresTiempos(tablaTiempos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public void rellenarDatosTablaMejoresTiempos(TableLayout tablaTiempos){
        //conectamos a Firebase
        //Recuperamos datos
        //inflamos en la tabla


    }
    public void rellenarCamposUsuario(String usuario){

        ImageView imagenUsuario = (ImageView)findViewById(R.id.imagenUsuario);
        EditText nombreUsuario = (EditText)findViewById(R.id.nombre_usuario);
        EditText apellidosUsuario = (EditText)findViewById(R.id.apellidos_usuario);
        EditText ubicacionUsuario = (EditText)findViewById(R.id.ubicacion_usuario);

        DocumentReference docRef = ff.collection("Usuario").document("Ficha").collection("Datos").document(usuario);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        //hacer un loggin para ver que ocurre
                        Log.d(TAG,"DocumentSnapshot data: " + document.getData());
                    } else {
                        //Si no existe en el log
                        Log.d(TAG, "No such document");
                    }
                } else {
                    // porque no ha resultado exitosa task.getException()
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        //Recuperamos datos del usuario
        // Conectamos con la bbdd
        //Usamos el usuario para recuperar el nick
        // con el nick buscamos en lso documentos y extraemos.


    }
}
