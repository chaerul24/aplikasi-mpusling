package com.mpusling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mpusling.R;
import com.mpusling.adapter.SchoolAdapter;
import com.mpusling.dataset.ItemSchool;

import java.util.ArrayList;

public class FragmentListBook extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<ItemSchool> item;
    private SchoolAdapter adapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_list_book, container, false);
        recyclerView = view.findViewById(R.id.recycler_school);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        item = new ArrayList<>();
        item.add(new ItemSchool(
                "https://th.bing.com/th/id/OIP.tFrQQVAWSTySkOpjrvK7iQHaK-?rs=1&pid=ImgDetMain",
                "Perahu kertas"));
        item.add(new ItemSchool(
                "https://dsxuu8etcj8kw.cloudfront.net/d/1/d186/d186-square-400.jpg",
                "My Dark Knigh"));
        item.add(new ItemSchool(
                "https://cf.shopee.co.id/file/919f936ec6ade48b761192dff29b474a",
                "Bela Negara"));
        adapter = new SchoolAdapter(getContext(), item);
        adapter.setOnItemClickListener(new SchoolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemSchool item, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }
}
