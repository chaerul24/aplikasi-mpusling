package com.mpusling.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mpusling.MoreSchoolActivity;
import com.mpusling.R;
import com.mpusling.adapter.SchoolAdapter;
import com.mpusling.dataset.ItemSchool;

import java.util.ArrayList;

public class FragmentListSchool extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<ItemSchool> item;
    private SchoolAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_list_school, container, false);

        recyclerView = view.findViewById(R.id.recycler_school);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        item = new ArrayList<>();
        item.add(new ItemSchool(
                "https://th.bing.com/th/id/OIP.I9Gj5-5-yKQ-7ZeIgPfjyQHaHa?rs=1&pid=ImgDetMain",
                "SD Bukit Asam"));
        item.add(new ItemSchool(
                "https://th.bing.com/th/id/OIP.I9Gj5-5-yKQ-7ZeIgPfjyQHaHa?rs=1&pid=ImgDetMain",
                "SD Bukit Asam"));
        item.add(new ItemSchool(
                "https://th.bing.com/th/id/OIP.I9Gj5-5-yKQ-7ZeIgPfjyQHaHa?rs=1&pid=ImgDetMain",
                "SD Bukit Asam"));
        adapter = new SchoolAdapter(getContext(), item);
        adapter.setOnItemClickListener(new SchoolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemSchool item, int position) {
                Intent intent = new Intent(getContext(), MoreSchoolActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }
}
