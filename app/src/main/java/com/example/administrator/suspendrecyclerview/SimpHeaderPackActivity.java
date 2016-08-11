package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.suspendrecyclerview.adapter.SuspendHeaderAdapter;
import com.example.administrator.suspendrecyclerview.widget.SuspendHeaderPackRecyclerView;

public class SimpHeaderPackActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private SuspendHeaderPackRecyclerView sus_recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_pack);
        setupView();
        initData();
    }

    private void setupView() {
        sus_recyclerview = (SuspendHeaderPackRecyclerView) findViewById(R.id.sus_recyclerview);
    }

    private void initData() {
        SuspendHeaderAdapter suspendAdapter = new SuspendHeaderAdapter(this, DataUtil.getData());
        sus_recyclerview.setAdapter(suspendAdapter);
    }


}
