package com.mpusling.dataset;

import android.graphics.Color;

public class ItemMenu {
    public int color;
    public String itemName;
    public int itemImage;
    public ItemMenu(int color, String itemName, int itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.color = color;
    }
}
