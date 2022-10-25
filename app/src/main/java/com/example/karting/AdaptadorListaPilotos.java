package com.example.karting;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.protobuf.Internal;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorListaPilotos extends ArrayAdapter {
ArrayList<String> array = null;

    public AdaptadorListaPilotos(@NonNull Context context, int resource, ArrayList array) {
        super(context, resource,array);
        this.array = array;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(listItemView == null){
            listItemView = inflater.inflate(R.layout.filapiloto,parent,false);
        }

        TextView nick = (TextView) listItemView.findViewById(R.id.nick);
        if(array.get(position)!=null) {
            nick.setText((String) array.get(position).toString());
        }

        return listItemView;
    }
}
