package com.example.quotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String q1 = "“I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.”";
    private String q2 = "“Be yourself; everyone else is already taken.”";
    private String q3 = "“Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.”";
   private String q4 = "“So many books, so little time.”";
   private String q5 = "“A room without books is like a body without a soul.”";




   private RecyclerView recyclerView;

   private MyAdapter adapter;
   private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        arrayList = new ArrayList<>();
        adapter = new MyAdapter(arrayList);

        recyclerView.setAdapter(adapter);

        arrayList.add(q1);
        arrayList.add(q2);
        arrayList.add(q3);
        arrayList.add(q4);
        arrayList.add(q5);


        adapter.notifyDataSetChanged();



    }
}