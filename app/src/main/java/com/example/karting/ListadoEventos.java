package com.example.karting;

import android.app.Notification;
import android.os.Bundle;
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
                                arrayCarreras.add(doc.toObject(Carrera.class));
                                //esto despues se pasara a nuestro adapter de la listView
                                list.setAdapter(new AdaptadorLista(ListadoEventos.this,0,arrayCarreras));

                            }
                        }
                    }
                });

    }
}