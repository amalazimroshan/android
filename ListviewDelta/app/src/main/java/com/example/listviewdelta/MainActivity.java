package com.example.listviewdelta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todolist = new ArrayList<>(Arrays.asList("make bed","do laundry","feed cat"));
    ArrayList<String> checkItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.listview);
        Button button = findViewById(R.id.button);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.custome_listitem,
                R.id.item_textview,
                todolist
        );
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkItems.clear();
                for(int i=0;i<listview.getCount();i++){
                    View listItem = listview.getChildAt(i);
                    CheckBox checkBox = listItem.findViewById(R.id.item_checkbox);
                    if(checkBox.isChecked()){
                        String item = todolist.get(i);
                        checkItems.add(item);
                    }
                }

                String items = checkItems.toString();
                Toast.makeText(MainActivity.this, items, Toast.LENGTH_SHORT).show();
            }
        });
    }
}