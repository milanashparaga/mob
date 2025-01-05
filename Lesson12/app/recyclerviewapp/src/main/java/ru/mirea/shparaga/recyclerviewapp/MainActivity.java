package ru.mirea.shparaga.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Event> events = getEventList();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new EventRecyclerViewAdapter(events));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    private List<Event> getEventList() {
        List<Event> list = new ArrayList<>();
        Event event1 = new Event("Мой первый новый год", "31 января 2005г.", R.drawable.first);
        Event event2 = new Event("Мой последний новый год в детском саду", "25 декабря 2010г.", R.drawable.second);
        Event event3 = new Event("Новый 2025", "31 декабря 2024г.", R.drawable.third);
        list.add(event1);
        list.add(event2);
        list.add(event3);
        return list;
    }
}