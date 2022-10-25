package com.example.karting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventoCarrera extends AppCompatActivity {

    ArrayList<Usuario> array;
    ArrayList <String> listaPilotos = new ArrayList<>();
    FirebaseFirestore ff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_carrera);

        Intent i2 = getIntent(); // de aqui obtengo nombre y carrera
        Usuario user = (Usuario) i2.getSerializableExtra("user");


        //objetos
        TextView titulo = (TextView)findViewById(R.id.tituloEvento);
        TextView hora = (TextView)findViewById(R.id.horaEvento) ;
        //recupero datos
        String nombre = (String) i2.getStringExtra("nombre").toLowerCase();
        String dia = (String)i2.getStringExtra("dia");

        //seteo cosas en esos objetos
        titulo.setText((String) i2.getStringExtra("nombre"));
        hora.setText(dia);

        //imagen de la carrera

        ImageView image = (ImageView)findViewById(R.id.imagenEvento);
        image.setImageResource(R.drawable.karticono);



        //lista de pilotos

        ListView list = (ListView) findViewById(R.id.listaParticipantes);




        System.out.println(nombre + dia);
        //Nos conectamos a base datos
        ff = FirebaseFirestore.getInstance();

        ff.collection("Eventos").document(nombre).collection("Pilotos")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult()){
                                // vamos sacando tods los docs que necesitamos
                                listaPilotos.add((String) doc.get("Nick"));
                            }
                            list.setAdapter(new AdaptadorListaPilotos(eventoCarrera.this,0,listaPilotos));
                        }
                    }
                });



        Button botonUniser = (Button) findViewById(R.id.botonUnirse);
        botonUniser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // aqui tengo que añadir un documento en mi bbddd
                System.out.println("Antes de añadir !!!!!!!!!!!!!!!");
                Map<String,Object> map = new HashMap<>();

                map.put("Nombre",user.getNombre());
                map.put("Apellido",user.getApellido());
                map.put("Nick",user.getNick());
                map.put("Ubicacion",user.getUbicacion());

                ff.collection("Eventos").document(nombre).collection("Pilotos").document(user.getNick()).
                set(map)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Se ha añadido correctamente",Toast.LENGTH_LONG).show();
                    }
                });

                //se queja de que el objeto tiene que ser un map<String,Object>
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