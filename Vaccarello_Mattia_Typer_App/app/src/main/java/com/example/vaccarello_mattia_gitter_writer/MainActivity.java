package com.example.vaccarello_mattia_gitter_writer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Lingua> sceltaLingua = new ArrayList<>();
    private ListView listViewLingua;
    public int posizione = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLingua = findViewById(R.id.listViewLingua);
        inizializzazioneLingua();
        //LinguaAdapter
        LinguaAdapter linguaAdapter = new LinguaAdapter(this, R.layout.list_row, sceltaLingua);
        listViewLingua.setAdapter(linguaAdapter);
        //listener of ListView
        listViewLingua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posizione = position;
                openActivity2();
            }
        });

    }
    //filling arrayList
    public void inizializzazioneLingua(){
        Lingua Inglese = new Lingua("Inglese", R.drawable.band_ing);
        Lingua Italiano = new Lingua("Italiano", R.drawable.band_ita);
        Lingua Spagnolo = new Lingua("Spagnolo", R.drawable.band_spagna);
        sceltaLingua.add(Italiano);
        sceltaLingua.add(Inglese);
        sceltaLingua.add(Spagnolo);
    }
    //opens the second activity
    public void openActivity2(){
        Intent intent = new Intent(this, Text_activity.class);
        String lingua_scelta = sceltaLingua.get(posizione).getLingua();
        intent.putExtra("lingua_scelta", lingua_scelta);
        intent.putExtra("IndiceListView", posizione);
        startActivity(intent);
    }
}