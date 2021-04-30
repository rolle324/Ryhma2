package com.example.calcurator.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.calcurator.R;

/*
Luo luokka jolla mallenetaan presidenttiä
- lisää Luokka samaan pakettiin missä on MainActivity
2. Luo Singleton luokka, joka toimii varastona kaikille presidenteille
3. Luo ListView jolle kerrotaan mistä esitettävät presidentit Löytyvät
4. Luo listView:lle onClick -tapahtumankäsittelija, joka saa tiedon
   mitä riviä on klikattu (ind 0,1,.....)
5. Siirrytään Indent:in avulla toiselle aktiviteetille jossa
   näytetään klikatun pressan kaikki tiedot
 */

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        //Listview:n alustaminen
        //a. Viittaus listview:n viewiin
        ListView lv = findViewById(R.id.lvHistory);
        //b. Viittaus singletoniin
        BookOfDays days = BookOfDays.getInstance();
        //c. Anna lista presidenteistä ListView:lle
        lv.setAdapter(new ArrayAdapter<Day>(this,
                android.R.layout.simple_expandable_list_item_1,
                days.getAllDays()));
        //Tapahtumankäsittelijä listView:n onclick eventille

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                //tämä metodi suoritetaan autom. kun jotain rivi klikataan
                Intent nextActivity = new Intent(History.this, HistoryDetails.class);
                nextActivity.putExtra("HistoryIndex",i);
                startActivity(nextActivity);
            }
        });

    }
}