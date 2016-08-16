package com.example.administrator.suspendrecyclerview.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.DataUtil;
import com.example.administrator.suspendrecyclerview.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class SuspendHeaderPackRecyclerView extends FrameLayout {

    private RecyclerView recyclerView;
    private TextView suspendView;
    private LinearLayoutManager linearLayoutManager;
    private int suspendViewHight;
    private boolean isMaybeMove;


    public SuspendHeaderPackRecyclerView(Context context) {
        super(context);
        setupView();
    }

    public SuspendHeaderPackRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView();
    }

    public SuspendHeaderPackRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView();
    }

    private void setupView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_for_suspendrecyclerview, this, true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_sticky_example);
        suspendView = (TextView) findViewById(R.id.tv_sticky_header_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        addScrollListener();
    }

    private void addScrollListener() {
        //init supspend effect
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // if it's first view  hide and init suspend TextView
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition == 0) {
                    suspendView.setVisibility(View.INVISIBLE);
                } else {
                    suspendView.setVisibility(View.VISIBLE);
                    suspendView.setText(DataUtil.getData().get(firstVisibleItemPosition - 1).sticky);
                }

                if (suspendViewHight == 0) {
                    suspendViewHight = suspendView.getMeasuredHeight();
                }

                int firstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                RecyclerView.ViewHolder viewHolder0 = recyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
                RecyclerView.ViewHolder viewHolder1 = recyclerView.findViewHolderForAdapterPosition(firstCompletelyVisibleItemPosition);
                if(viewHolder0.getItemViewType() == viewHolder1.getItemViewType()){
                    Log.i("zmin.............", "..类型一致无需考虑悬浮标题滚动问题..");
                    isMaybeMove = false;
                }else{
                    Log.i("zmin.............", "..类型不一致再判断悬浮标题的滚动..");
                    isMaybeMove = true;
                }

                View viewUnder = recyclerView.findChildViewUnder(0, suspendViewHight + 1);
                if (viewUnder != null && viewUnder.getTag() != null && (int) viewUnder.getTag() == 1) {
                    Log.i("zmin.............", "firstVisibleItemPosition...." + firstVisibleItemPosition);
                    int dealtY = viewUnder.getTop() - suspendViewHight;
                    if (Math.abs(dealtY) >= suspendViewHight) {
                        suspendView.setTranslationY(0);
                    } else if(isMaybeMove) {
                        suspendView.setTranslationY(dealtY);
                    }
                } else {
                    suspendView.setTranslationY(0);
                }

            }
        });
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
