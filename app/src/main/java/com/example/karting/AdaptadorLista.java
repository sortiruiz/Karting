package com.example.karting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorLista extends ArrayAdapter<Carrera> {


    public AdaptadorLista(@NonNull Context context, int resource, ArrayList<Carrera> array) {
        super(context, resource,array);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Carrera carrera = null;
        position = 0;
        View listItemView = convertView;

        LayoutInflater inflater  = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            listItemView  = inflater.inflate(R.layout.fila_lista,parent,false);
        }

        // Casteamos cada elemento como una carera
        carrera =(Carrera) getItem(position);

        //Asociamos elementos de la lista a objetos
        TextView circuito =(TextView) listItemView.findViewById(R.id.nombreCircuito);
        TextView dia = (TextView)  listItemView.findViewById(R.id.horacarrera);

        //escribimos sobre los elementos de la fila
        circuito.setText(carrera.getNombre());
        dia.setText(carrera.getDia());

    return listItemView;
    }


}
