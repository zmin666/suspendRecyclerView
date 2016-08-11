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
public class SuspendDoubleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<StickyExampleModel> stickyExampleModels;
    private static final int type_1 = 1;
    private static final int type_2 = 2;

    public static final int HAS_STICKY_VIEW_13 = 13;
    public static final int HAS_STICKY_VIEW_23 = 23;

    public SuspendDoubleAdapter(Context context, List<StickyExampleModel> stickyExampleModels) {
        this.context = context;
        this.stickyExampleModels = stickyExampleModels;
    }

    @Override
    public int getItemViewType(int position) {
        if (position <= 30) {
            return type_1;
        } else {
            return type_2;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == type_1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
            return new SuppendViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item_short, parent, false);
            return new SuppendShortViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        StickyExampleModel stickyExampleModel = stickyExampleModels.get(position);
        // init  item content
        if (viewType == type_1) {
            ((SuppendViewHolder) holder).tvName.setText(stickyExampleModel.name);
            ((SuppendViewHolder) holder).tvGender.setText(stickyExampleModel.gender);
            ((SuppendViewHolder) holder).tvProfession.setText(stickyExampleModel.profession);
        } else {
            ((SuppendShortViewHolder) holder).tvName.setText(stickyExampleModel.name);
            ((SuppendShortViewHolder) holder).tvGender.setText(stickyExampleModel.gender);
            ((SuppendShortViewHolder) holder).tvProfession.setText(stickyExampleModel.profession);
        }

        //init item title
        if (position == 0) {
            if (viewType == type_1) {
                ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                ((SuppendViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
            } else {
                ((SuppendShortViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                ((SuppendShortViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
            }
        } else {
            StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 1);
            if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                if (viewType == type_1) {
                    ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.GONE);
                } else {
                    ((SuppendShortViewHolder) holder).tvStickyHeader.setVisibility(View.GONE);
                }
            } else {
                if (viewType == type_1) {
                    ((SuppendViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                    ((SuppendViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    ((SuppendViewHolder) holder).itemView.setTag(HAS_STICKY_VIEW_13);
                } else {
                    ((SuppendShortViewHolder) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                    ((SuppendShortViewHolder) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    ((SuppendShortViewHolder) holder).itemView.setTag(HAS_STICKY_VIEW_23);
                }

            }
        }

        //init item background color
        if (position % 2 == 0) {
            if (viewType == type_1) {
                ((SuppendViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_1));
            } else {
                ((SuppendShortViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_1));
            }
        } else {
            if (viewType == type_1) {
                ((SuppendViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_1));
            } else {
                ((SuppendShortViewHolder) holder).rlContentWrapper.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.bg_color_1));
            }
        }


    }

    @Override
    public int getItemCount() {
        return stickyExampleModels.size();
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

    public class SuppendShortViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendShortViewHolder(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_short);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }
}
