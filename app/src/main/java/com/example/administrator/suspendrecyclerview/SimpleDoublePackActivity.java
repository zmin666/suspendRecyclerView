package com.example.administrator.suspendrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.adapter.SuspendDoubleAdapter;

import java.util.List;

/**
 * 两种悬浮头布局
 */
public class SimpleDoublePackActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView rvStickyExample;
    private TextView tvStickyHeaderView;
    private int suspendViewHight;
    private int suspendShortViewHight;
    private LinearLayoutManager linearLayoutManager;
    private TextView tvStickyShortHeaderView;
    /** changeTitle type postion (this lastst posion of first Item's type) */
    private int changTypePosition = -1;
    private boolean changType = false;
    private String TAG = "SimpleDoublePackActivity";
    private boolean isMaybeMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_double);
        setupView();
        initData();
    }

    private void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        rvStickyExample.setLayoutManager(linearLayoutManager);
        List<StickyExampleModel> data = DataUtil.getData();
        changTypePosition = 15;
        final SuspendDoubleAdapter suspendDoubleAdapter = new SuspendDoubleAdapter(this,data,changTypePosition);
        rvStickyExample.setAdapter(suspendDoubleAdapter);


        //init first supspend item

        //init supspend effect
        rvStickyExample.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //init length
                if (suspendViewHight == 0 || suspendShortViewHight == 0) {
                    suspendViewHight = tvStickyHeaderView.getMeasuredHeight();
                    suspendShortViewHight = tvStickyShortHeaderView.getMeasuredHeight();
                }

                //增强判断
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
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

                // init viewUnder .  important is Where to find viewUnder
                View viewUnder = null;
                Log.i("zminsss..", "...firstVisibleItemPosition..." + firstVisibleItemPosition);
                if (firstVisibleItemPosition < changTypePosition) {
                    viewUnder = recyclerView.findChildViewUnder(0, suspendViewHight + 1);
                    changType = true;
                    tvStickyShortHeaderView.setVisibility(View.INVISIBLE);
                    tvStickyHeaderView.setVisibility(View.VISIBLE);
                } else {
                    viewUnder = recyclerView.findChildViewUnder(0, suspendShortViewHight + 1);
                    changType = false;
                    tvStickyShortHeaderView.setVisibility(View.VISIBLE);
                    tvStickyHeaderView.setVisibility(View.INVISIBLE);
                }

                if (viewUnder != null && viewUnder.getTag() != null) {
                    if ((int) viewUnder.getTag() == 13) {
                        int dealtY = viewUnder.getTop() - suspendViewHight;
                        if (Math.abs(dealtY) >= suspendViewHight) {
                            tvStickyHeaderView.setTranslationY(0);
                        } else if(isMaybeMove) {
                            tvStickyHeaderView.setTranslationY(dealtY);
                        }
                    } else if ((int) viewUnder.getTag() == 23) {
                        if (changType) {
                            int dealtY = viewUnder.getTop() - suspendViewHight;
                            tvStickyHeaderView.setVisibility(View.VISIBLE);
                            tvStickyShortHeaderView.setVisibility(View.INVISIBLE);
                            if (Math.abs(dealtY) >= suspendViewHight) {
                                tvStickyShortHeaderView.setTranslationY(0);
                                tvStickyShortHeaderView.setVisibility(View.VISIBLE);
                            } else if(isMaybeMove){
                                tvStickyHeaderView.setTranslationY(dealtY);
                            }
                        } else {
                            int dealtY = viewUnder.getTop() - suspendShortViewHight;
                            if (Math.abs(dealtY) >= suspendShortViewHight) {
                                tvStickyShortHeaderView.setTranslationY(0);
                            } else if(isMaybeMove){
                                tvStickyShortHeaderView.setTranslationY(dealtY);
                            }
                        }
                    } else {
                        tvStickyHeaderView.setTranslationY(0);
                        tvStickyShortHeaderView.setTranslationY(0);
                    }
                } else {
                    tvStickyHeaderView.setTranslationY(0);
                    tvStickyShortHeaderView.setTranslationY(0);
                }

                tvStickyHeaderView.setText(DataUtil.getData().get(firstVisibleItemPosition).sticky);
                tvStickyShortHeaderView.setText(DataUtil.getData().get(firstVisibleItemPosition).sticky);

            }
        });

    }

    private void setupView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvStickyExample = (RecyclerView) findViewById(R.id.rv_sticky_example);
        tvStickyHeaderView = (TextView) findViewById(R.id.tv_sticky_header_view);
        tvStickyShortHeaderView = (TextView) findViewById(R.id.tv_sticky_header_short);
        tvStickyShortHeaderView.setVisibility(View.INVISIBLE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(TAG);
    }
}
