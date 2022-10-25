package com.example.karting;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListadoEventos extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_eventos);
        //Aqui tenemos todo el listado de eventos que debemos de recuperar de otra bbdd
        ArrayList<Carrera> arrayCarreras = new ArrayList<Carrera>();


        ListView list = (ListView)findViewById(R.id.listadoEventos);

        FirebaseFirestore ff = FirebaseFirestore.getInstance();
        ff.collection("Eventos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        //en principio tenemos toda la coleccion
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult()){
                                //Aqui tenemos que cada doc es una carrera-evento
                                //con dos atri. nombre y fecha.
                                System.out.println(doc.toObject(Carrera.class).getNombre() + doc.toObject(Carrera.class).getDia());
                                arrayCarreras.add(doc.toObject(Carrera.class));
                            }
                            //despues de tener toda la lista lo rellenamos en nuestra listview
                            list.setAdapter(new AdaptadorLista(ListadoEventos.this,0,arrayCarreras));
                        }
                    }
                });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i es la posicion del array que yo les he enviado -- por tanto de aqui pdemos recuperar datos necesarios
                String dia  = arrayCarreras.get(i).getDia();
                String nombre = arrayCarreras.get(i).getNombre();

                Intent i3 = getIntent();
                Usuario user = (Usuario) i3.getSerializableExtra("user");
                //aqui recupero el usuario descargado desde mi bbdd


                Intent i2 = new Intent(ListadoEventos.this,eventoCarrera.class);

                i2.putExtra("user",user);

                i2.putExtra("nombre",nombre);
                i2.putExtra("dia",dia);
                startActivity(i2);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.listadoEventos:
              //  listado(); // llamo a una funcion
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}