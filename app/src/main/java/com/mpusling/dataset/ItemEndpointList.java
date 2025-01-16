package com.mpusling.dataset;

public class ItemEndpointList {
    private String name;
    private String school;
    private String date;
    private boolean isSelected;

    public ItemEndpointList(String name, String school, String date, boolean isSelected) {
        this.name = name;
        this.school = school;
        this.date = date;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getDate() {
        return date;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
