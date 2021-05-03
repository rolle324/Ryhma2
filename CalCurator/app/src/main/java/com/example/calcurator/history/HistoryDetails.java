package com.example.calcurator.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.calcurator.R;
import com.example.calcurator.history.BookOfDays;
import com.example.calcurator.history.Day;

public class HistoryDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        //Reading index of day.
        Bundle bundle = getIntent().getExtras(); //hakee intent ja siihen tiedot
        int index = bundle.getInt("HistoryIndex");   //Laittaa indexiin, historyIndexin

        //Writing all days into the ListView
        TextView tv= findViewById(R.id.tvDetails);
        BookOfDays days = BookOfDays.getInstance(); //Viittaus singletoniin

        Day day = days.getDay(index);  //Hakee tietyn päivän
        tv.setText(day.getAllMeals()); //Laittaa sinne kaikki tietyn päivän tiedot
    }
}