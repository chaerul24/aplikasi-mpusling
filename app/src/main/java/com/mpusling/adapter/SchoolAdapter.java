package com.mpusling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mpusling.R;
import com.mpusling.dataset.ItemSchool;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolAdapterViewHolder> {

    private final Context context;
    private final List<ItemSchool> item;
    private OnItemClickListener onItemClickListener;

    // Interface callback untuk menangani klik item
    public interface OnItemClickListener {
        void onItemClick(ItemSchool item, int position);
    }

    public SchoolAdapter(Context context, List<ItemSchool> item) {
        this.context = context;
        this.item = item;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public SchoolAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SchoolAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_logo_school, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolAdapterViewHolder holder, int position) {
        ItemSchool itemSchool = item.get(position);
        holder.title.setText(itemSchool.school);
        Glide.with(context)
                .load(itemSchool.imgUrl)
                .error(R.drawable.image_placeholder)
                .into(holder.img);

        // Tambahkan klik listener ke itemView
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(itemSchool, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    class SchoolAdapterViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final ImageView img;

        public SchoolAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_school);
            img = itemView.findViewById(R.id.logo_school);
        }
    }
}
