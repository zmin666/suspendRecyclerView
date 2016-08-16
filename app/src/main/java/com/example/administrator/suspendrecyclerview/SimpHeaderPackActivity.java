package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.suspendrecyclerview.adapter.SuspendHeaderAdapter;
import com.example.administrator.suspendrecyclerview.adapter.SuspendHeaderPackAdapter;
import com.example.administrator.suspendrecyclerview.widget.SuspendHeaderPackRecyclerView;

/**
 * 添加头布局的封装类
 */
public class SimpHeaderPackActivity extends AppCompatActivity {
    private String TAG = "SimpHeaderPackActivity";
    private SuspendHeaderPackRecyclerView sus_recyclerview;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_pack);
        setupView();
        initData();
    }

    private void setupView() {
        sus_recyclerview = (SuspendHeaderPackRecyclerView) findViewById(R.id.sus_recyclerview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(TAG);

    }

    private void initData() {
        SuspendHeaderPackAdapter suspendAdapter = new SuspendHeaderPackAdapter(this, DataUtil.getData());
        sus_recyclerview.setAdapter(suspendAdapter);
    }


}
