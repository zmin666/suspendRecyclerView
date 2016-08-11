package com.example.administrator.suspendrecyclerview.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.DataUtil;
import com.example.administrator.suspendrecyclerview.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class SuspendHeaderRecyclerView extends FrameLayout {

    private RecyclerView recyclerView;
    private TextView suspendView;
    private LinearLayoutManager linearLayoutManager;
    private int suspendViewHight;

    public SuspendHeaderRecyclerView(Context context) {
        super(context);
        setupView();
    }

    public SuspendHeaderRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView();
    }

    public SuspendHeaderRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView();
    }

    private void setupView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_for_suspendrecyclerview,this,true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_sticky_example);
        suspendView = (TextView) findViewById(R.id.tv_sticky_header_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        addScrollListener();
    }

    private void addScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (suspendViewHight == 0) {
                    suspendViewHight = suspendView.getMeasuredHeight();
                }

                View viewUnder = recyclerView.findChildViewUnder(0, suspendViewHight + 1);
                if (viewUnder != null && viewUnder.getTag() != null && (int) viewUnder.getTag() == 1) {
                    int dealtY = viewUnder.getTop() - suspendViewHight;
                    if (Math.abs(dealtY) >= suspendViewHight) {
                        suspendView.setTranslationY(0);
                    } else {
                        suspendView.setTranslationY(dealtY);
                    }
                } else {
                    suspendView.setTranslationY(0);
                }

                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                suspendView.setText(DataUtil.getData().get(firstVisibleItemPosition).sticky);
            }

        });
    }

   

    public void setAdapter(RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
}
