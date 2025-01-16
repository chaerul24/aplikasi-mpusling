package com.mpusling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mpusling.R;
import com.mpusling.dataset.ItemEndpointList;

import java.util.ArrayList;

public class EndpointschoolAdapter extends RecyclerView.Adapter<EndpointschoolAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ItemEndpointList> items;

    public EndpointschoolAdapter(Context context, ArrayList<ItemEndpointList> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_school, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemEndpointList item = items.get(position);
        holder.name.setText(item.getName());
        holder.school.setText(item.getSchool());
        holder.date.setText(item.getDate());
        holder.checkbox.setChecked(item.isSelected());

        // Update item ketika checkbox diubah
        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setSelected(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void selectAllItems(boolean isSelected) {
        for (ItemEndpointList item : items) {
            item.setSelected(isSelected);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, school, date;
        CheckBox checkbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name_school);
            school = itemView.findViewById(R.id.item_school);
            date = itemView.findViewById(R.id.item_date);
            checkbox = itemView.findViewById(R.id.select_item_school);
        }
    }
}
