package com.cmj.recyclerpopupwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showUpBtn;
    private Button showDownBtn;
    List<Item> items;
    private RecyclerPopupWindow recyclerPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        items = new ArrayList<>();
        items.add(0, new Item("取消", false));
        for (int i = 0; i < 60; ++i) {
            items.add(i + 1, new Item(i + "min", false));
        }
        showUpBtn = (Button) findViewById(R.id.btn_show_up);
        showDownBtn = (Button) findViewById(R.id.btn_show_down);
        showUpBtn.setOnClickListener(this);
        showDownBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_up) {
            if (recyclerPopupWindow == null) {
                recyclerPopupWindow = new RecyclerPopupWindow(items);
                recyclerPopupWindow.showPopupWindow(MainActivity.this, showUpBtn, showUpBtn.getWidth(), 300, true);
                recyclerPopupWindow.setCallBack(new RecyclerPopupWindow.CallBack() {
                    @Override
                    public void callback(String value) {
                        if (!"-1".equals(value)) {
                            showUpBtn.setText(value);
                        }
                        recyclerPopupWindow = null;
                    }
                });
            }
        } else {
            if (recyclerPopupWindow == null) {
                recyclerPopupWindow = new RecyclerPopupWindow(items);
                recyclerPopupWindow.showPopupWindow(MainActivity.this, showDownBtn, showDownBtn.getWidth(), 300, false);
                recyclerPopupWindow.setCallBack(new RecyclerPopupWindow.CallBack() {
                    @Override
                    public void callback(String value) {
                        if (!"-1".equals(value)) {
                            showDownBtn.setText(value);
                        }
                        recyclerPopupWindow = null;
                    }
                });
            }
        }
    }
}
