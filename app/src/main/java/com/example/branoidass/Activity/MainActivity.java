package com.example.branoidass.Activity;
//import androidx.appcompat.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.branoidass.Adapters.adapter;
import com.example.branoidass.models.JsonParsing;
import com.example.branoidass.R;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    ListView listOfBooks;

    private ArrayList<String> names= new ArrayList<>();
    private ArrayList<String> imageUrls= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfBooks=findViewById(R.id.listOfBooks);
        ArrayAdapter<String> annouAdapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        listOfBooks.setAdapter(annouAdapter);
        JsonParsing jsonParsing=new JsonParsing();

        jsonParsing.execute();

        LinearLayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false );
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        adapter adp=new adapter(this,names,imageUrls);
        recyclerView.setAdapter(adp);


    }


}
