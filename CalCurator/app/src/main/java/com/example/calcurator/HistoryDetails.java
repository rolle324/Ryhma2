package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HistoryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        //Luetaan klikatun pressan indeksi intentin datasta
        Bundle b = getIntent().getExtras();
        int ind =   b.getInt("HistoryIndex");

        //Textview
        TextView tv= findViewById(R.id.tvDetails);

        //Kirjoitetaan textviewiin kaikki pressan tiedot
        BookOfDays days = BookOfDays.getInstance();
        //b. varastosta haluttu presidentti-olio
        Day d = days.getDay(ind);
        //c. Pressan kaikki tiedot näkyviin
        tv.setText(d.getDate()+", " + d.getmeal() +", "+ d.getcalories());

    }
}