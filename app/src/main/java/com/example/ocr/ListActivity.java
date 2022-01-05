package com.example.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ImageButton addBtn, deleteBtn, resetBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addBtn = findViewById(R.id.add);
        deleteBtn = findViewById(R.id.delete);
        resetBtn = findViewById(R.id.reset);

        final ArrayList<String> items = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);
        final ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        items.add("re");

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String getText  = intent.getExtras().getString("Text");
                String getName = intent.getExtras().getString("Name");
                if(getText != null) {
                    items.add(getName + "-" + getText);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

}
