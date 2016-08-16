package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.suspendrecyclerview.adapter.SuspendAdapter;
import com.example.administrator.suspendrecyclerview.widget.SuspendRecyclerView;

/**
 * 简单包装类
 */
public class SimplePackActivity extends AppCompatActivity {
    private String TAG = "SimplePackActivity";
    private SuspendRecyclerView sus_recyclerview;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_simple_pack);
        setupView();
        initData();
    }

    private void initData() {
        SuspendAdapter suspendAdapter = new SuspendAdapter(this, DataUtil.getData());
        sus_recyclerview.setAdapter(suspendAdapter);
    }

    private void setupView() {
        sus_recyclerview = (SuspendRecyclerView) findViewById(R.id.sus_recyclerview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(TAG);
    }
}
