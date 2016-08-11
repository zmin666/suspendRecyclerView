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
public class SuspendHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<StickyExampleModel> stickyExampleModels;

    public static final int HAS_STICKY_VIEW = 1;
    public static final int TYPE_HEADER = 1;

    public SuspendHeaderAdapter(Context context, List<StickyExampleModel> stickyExampleModels) {
        this.context = context;
        this.stickyExampleModels = stickyExampleModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item_header, parent, false);
            return new SuppendHeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
            return new SuppendViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            // TODO INIT HEADERVIEW
            ((SuppendHeaderViewHolder) holder).tv_sticky_header.setBackgroundColor(
                    ContextCompat.getColor(context, R.color.bg_color_3));
        } else {
            StickyExampleModel stickyExampleModel = stickyExampleModels.get(position - 1);
            //init view
            ((SuppendViewHolder) holder).tvName.setText(stickyExampleModel.name);
            ((SuppendViewHolder) holder).tvGender.setText(stickyExampleModel.gender);
            ((SuppendViewHolder) holder).tvProfession.setText(stickyExampleModel.profession);
            //init visbility
            if (position == 1) {
                ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                ((SuppendViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
            } else {
                StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 2);
                if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                    ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.GONE);
                } else {
                    ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                    ((SuppendViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    holder.itemView.setTag(HAS_STICKY_VIEW);
                }
            }
            //init item color
            if (position % 2 == 0) {
                ((SuppendViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_1));
            } else {
                ((SuppendViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_2));
            }

        }
    }

    @Override
    public int getItemCount() {
        return stickyExampleModels.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return super.getItemViewType(position);
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

    public class SuppendHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_sticky_header;

        public SuppendHeaderViewHolder(View itemView) {
            super(itemView);
            tv_sticky_header = (TextView) itemView.findViewById(R.id.tv_sticky_header);
        }
    }
}
