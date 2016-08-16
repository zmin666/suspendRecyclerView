package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.adapter.SuspendAdapter;

/**
 * 最简单的
 */
public class SimpleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvStickyExample;
    private TextView tvStickyHeaderView;
    private FloatingActionButton fab;
    private String TAG = "SimpleActivity";
    private int suspendViewHight;
    private int suspendWidth;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        setupView();
        initData();
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        rvStickyExample.setLayoutManager(linearLayoutManager);
        SuspendAdapter suspendAdapter = new SuspendAdapter(this, DataUtil.getData());
        rvStickyExample.setAdapter(suspendAdapter);
        //init first supspend item

        //init supspend effect
        rvStickyExample.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (suspendViewHight == 0) {
                    suspendViewHight = tvStickyHeaderView.getMeasuredHeight();
                }

                View viewUnder = recyclerView.findChildViewUnder(0, suspendViewHight + 1);
                if (viewUnder != null && viewUnder.getTag() != null && (int) viewUnder.getTag() == 1) {
                    int dealtY = viewUnder.getTop() - suspendViewHight;
                    if (Math.abs(dealtY) >= suspendViewHight) {
                        tvStickyHeaderView.setTranslationY(0);
                    } else {
                        tvStickyHeaderView.setTranslationY(dealtY);
                    }
                } else {
                    tvStickyHeaderView.setTranslationY(0);
                }

                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                tvStickyHeaderView.setText(DataUtil.getData().get(firstVisibleItemPosition).sticky);
            }
        });

    }

    private void setupView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvStickyExample = (RecyclerView) findViewById(R.id.rv_sticky_example);
        tvStickyHeaderView = (TextView) findViewById(R.id.tv_sticky_header_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(TAG);
        suspendViewHight = tvStickyHeaderView.getMeasuredHeight();
        Log.i(TAG, "suspendViewHight..." + suspendViewHight);

    }
}
