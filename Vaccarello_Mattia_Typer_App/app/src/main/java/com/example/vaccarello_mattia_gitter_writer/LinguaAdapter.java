package com.example.vaccarello_mattia_gitter_writer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LinguaAdapter extends ArrayAdapter<Lingua> {
    private Context mContext;
    private int mResource;
    public LinguaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lingua> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageBand);
        TextView textView = convertView.findViewById(R.id.textViewCountry);

        imageView.setImageResource(getItem(position).getImage());
        textView.setText(getItem(position).getLingua());
        return convertView;
    }
}
