package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.suspendrecyclerview.adapter.SuspendAdapter;
import com.example.administrator.suspendrecyclerview.widget.SuspendRecyclerView;

public class SimplePackActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private SuspendRecyclerView sus_recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_pack);
        setupView();
        initData();
    }

    private void initData() {
        SuspendAdapter suspendAdapter = new SuspendAdapter(this, DataUtil.getData());
        sus_recyclerview.setAdapter(suspendAdapter);
    }

    private void setupView() {
        sus_recyclerview = (SuspendRecyclerView) findViewById(R.id.sus_recyclerview);
    }
}
