package com.mpusling;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mpusling.adapter.EndpointschoolAdapter;
import com.mpusling.dataset.ItemEndpointList;

import java.util.ArrayList;

public class EndPointListActivity extends AppCompatActivity {
    private ArrayList<ItemEndpointList> arrayItem;
    private EndpointschoolAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_point_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CheckBox selectedAll = findViewById(R.id.select_all);

        arrayItem = new ArrayList<>();
        arrayItem.add(new ItemEndpointList("Chaerul", "SMK", "15/01/2021", false));
        arrayItem.add(new ItemEndpointList("Wahyu", "SMK", "15/01/2021", false));
        arrayItem.add(new ItemEndpointList("Iman", "SMK", "15/01/2021", false));
        arrayItem.add(new ItemEndpointList("Syah", "SMK", "15/01/2021", false));

        adapter = new EndpointschoolAdapter(this, arrayItem);
        recyclerView.setAdapter(adapter);

        // Set listener untuk checkbox select_all
        selectedAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Update semua item berdasarkan status checkbox
            adapter.selectAllItems(isChecked);
        });
    }
}
