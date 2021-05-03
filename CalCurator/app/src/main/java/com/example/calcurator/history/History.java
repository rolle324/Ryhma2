package com.example.calcurator.history;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.calcurator.MainActivity;
import com.example.calcurator.R;
import com.example.calcurator.userdata.Settings;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //Initializing ListView
        ListView lv = findViewById(R.id.lvHistory);
        BookOfDays days = BookOfDays.getInstance();  //Viittaus singletoniin
        lv.setAdapter(new ArrayAdapter<Day>(this,   //List adapter, joka kerää objekteja listView.
                android.R.layout.simple_expandable_list_item_1,
                days.getAllDays()));

        //Event handler for ListView onClickListener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent nextActivity = new Intent(History.this, HistoryDetails.class); //Tekee uuden intent
                nextActivity.putExtra("HistoryIndex", i); //Add information to Intent
                startActivity(nextActivity);
            }
        });
    }

    /**
     * Moves to Main Activity
     * @param view
     */
    public void goToCalcurator(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Moves to History
     * @param view
     */
    public void goToHistory(View view) {
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }

    /**
     * Moves to settings
     * @param view
     */
    public void goToSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}