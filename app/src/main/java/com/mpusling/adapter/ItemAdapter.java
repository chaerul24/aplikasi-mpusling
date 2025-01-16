package com.mpusling.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mpusling.R;
import com.mpusling.dataset.ItemMenu;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdaptemViewHolder> {

    private Context context;
    private ArrayList<ItemMenu> itemMenus;
    private OnItemClickListener onItemClickListener;

    // Interface callback
    public interface OnItemClickListener {
        void onItemClick(ItemMenu itemMenu, int position);
    }

    public ItemAdapter(Context context, ArrayList<ItemMenu> itemMenus) {
        this.context = context;
        this.itemMenus = itemMenus;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ItemAdaptemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemAdaptemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_menu, viewGroup, false));
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull ItemAdaptemViewHolder holder, int position) {
        ItemMenu item = itemMenus.get(position);
        if (item != null) {
            holder.itemName.setText(item.itemName);
            holder.itemImage.setImageResource(item.itemImage);
            holder.linearCardItem.setBackgroundColor(context.getResources().getColor(item.color, null));

            // Set listener untuk memanggil callback
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(item, position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemMenus.size();
    }

    class ItemAdaptemViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage;
        LinearLayout linearCardItem;

        public ItemAdaptemViewHolder(@NonNull View itemView) {
            super(itemView);
            linearCardItem = itemView.findViewById(R.id.linear_card_item);
            itemName = itemView.findViewById(R.id.text_item);
            itemImage = itemView.findViewById(R.id.image_item);
        }
    }
}
