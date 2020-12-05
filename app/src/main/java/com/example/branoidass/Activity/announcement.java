package com.example.branoidass.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.branoidass.R;
import com.example.branoidass.models.JsonParsing;

public class announcement extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        listView=findViewById(R.id.listView);
        JsonParsing jsonParsing=new JsonParsing();

        jsonParsing.execute();

        ArrayAdapter<String> annouAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        listView.setAdapter(annouAdapter);

    }
}
