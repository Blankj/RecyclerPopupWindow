package com.cmj.recyclerpopupwindow;

/**
 * Created by cmj on 2016/3/29.
 */
public class Item {
    private String title;
    private boolean active;

    public Item(String title, boolean active) {
        this.title = title;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
