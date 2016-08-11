package com.example.administrator.suspendrecyclerview.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.R;
import com.example.administrator.suspendrecyclerview.StickyExampleModel;

import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class SuspendAdapter extends RecyclerView.Adapter<SuspendAdapter.SuppendViewHolder> {

    private Context context;
    private List<StickyExampleModel> stickyExampleModels;

    public static final int HAS_STICKY_VIEW = 1;

    public SuspendAdapter(Context context, List<StickyExampleModel> stickyExampleModels) {
        this.context = context;
        this.stickyExampleModels = stickyExampleModels;
    }

    @Override
    public SuppendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
        return new SuppendViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return stickyExampleModels.size();
    }

    @Override
    public void onBindViewHolder(SuppendViewHolder holder, int position) {
        StickyExampleModel stickyExampleModel = stickyExampleModels.get(position);
        //init view
        holder.tvName.setText(stickyExampleModel.name);
        holder.tvGender.setText(stickyExampleModel.gender);
        holder.tvProfession.setText(stickyExampleModel.profession);
        //init visbility
        if(position == 0){
            holder.tvStickyHeader.setVisibility(View.VISIBLE);
            holder.tvStickyHeader.setText(stickyExampleModel.sticky);
        }else{
            StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position-1);
            if(stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)){
                holder.tvStickyHeader.setVisibility(View.GONE);
            }else{
                holder.tvStickyHeader.setVisibility(View.VISIBLE);
                holder.tvStickyHeader.setText(stickyExampleModel.sticky);
                holder.itemView.setTag(HAS_STICKY_VIEW);
            }
        }
        //init item color
        if (position % 2 == 0) {
            holder.rlContentWrapper.setBackgroundColor(
                    ContextCompat.getColor(context, R.color.bg_color_1));
        } else {
            holder.rlContentWrapper.setBackgroundColor(
                    ContextCompat.getColor(context, R.color.bg_color_2));
        }


    }

    public class SuppendViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendViewHolder(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }
}
