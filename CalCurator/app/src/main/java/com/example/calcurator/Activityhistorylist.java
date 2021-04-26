package com.example.calcurator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activityhistorylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Bundle b = getIntent().getExtras();
        int ind = b.getInt("RuuanIndeksi");

        TextView tv = findViewById(R.id.tvDetails);

        BookOfCals food = BookOfCals.getInstance();

        History h = food.getHistory(ind);

        tv.setText(h.getRuuannimi()+", "+ h.getCalmaara());
    }
}