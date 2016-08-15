package com.example.administrator.suspendrecyclerview.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.suspendrecyclerview.R;
import com.example.administrator.suspendrecyclerview.StickyExampleModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/8/5.
 */
public class SuspendHeaderPackAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<StickyExampleModel> stickyExampleModels;

    public static final int HAS_STICKY_VIEW = 1;
    public static final int TYPE_HEADER = 100;

    /** 头布局资源id */
    private int headViewResource = R.layout.layout_list_item_header;
    /** 分类item资源id */
    private int[] itemViewResource = new int[]{R.layout.layout_list_item_1, R.layout.layout_list_item_2, R.layout.layout_list_item_3, R.layout.layout_list_item_4};
    private ArrayList<Integer> viewTypeLists = new ArrayList<>();
    private HashMap<Integer, Integer> itemTyepMap;
    private int start = 0;

    public SuspendHeaderPackAdapter(Context context, List<StickyExampleModel> stickyExampleModels) {
        this.context = context;
        this.stickyExampleModels = stickyExampleModels;
        classfiDataType();
    }

    private void classfiDataType() {
        itemTyepMap = new HashMap<>();
        int size = stickyExampleModels.size();
        start = TYPE_HEADER + 1;
        for (int i = 0; i < size; i++) {
            if(i == 0){
                itemTyepMap.put(i,start);
            }else{
                String sticky = stickyExampleModels.get(i).sticky;
                String lastSticky = stickyExampleModels.get(i - 1).sticky;
                if (lastSticky.equals(sticky)) {
                    itemTyepMap.put(i, start);
                } else {
                    itemTyepMap.put(i, ++start);
                }
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(headViewResource, parent, false);
            return new SuppendHeaderViewHolder(view);
        } else {
            View itemView = null;
            switch (viewType) {
                case 101:
                    if (itemView == null)
                        itemView = LayoutInflater.from(context).inflate(itemViewResource[0], parent, false);
                    return new SuppendViewHolder1(itemView);
                case 102:
                    if (itemView == null)
                        itemView = LayoutInflater.from(context).inflate(itemViewResource[1], parent, false);
                    return new SuppendViewHolder2(itemView);
                case 103:
                    if (itemView == null)
                        itemView = LayoutInflater.from(context).inflate(itemViewResource[2], parent, false);
                    return new SuppendViewHolder3(itemView);
                case 104:
                    if (itemView == null)
                        itemView = LayoutInflater.from(context).inflate(itemViewResource[3], parent, false);
                    return new SuppendViewHolder4(itemView);
                default:
                    if (itemView == null)
                        itemView = LayoutInflater.from(context).inflate(itemViewResource[0], parent, false);
                    return new SuppendViewHolder1(itemView);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.i("zmin...position.."+position,"itemViewType...." + getItemViewType(position) );
        if (position == 0) {
            ((SuppendHeaderViewHolder) holder).tv_sticky_header.setBackgroundColor(
                    ContextCompat.getColor(context, R.color.bg_color_3));
        } else {
            StickyExampleModel stickyExampleModel = stickyExampleModels.get(position - 1);
            //
            int itemViewType = getItemViewType(position);
            switch (itemViewType) {
                case 101:
                    //init view
                    ((SuppendViewHolder1) holder).tvName.setText(stickyExampleModel.name);
                    ((SuppendViewHolder1) holder).tvGender.setText(stickyExampleModel.gender);
                    ((SuppendViewHolder1) holder).tvProfession.setText(stickyExampleModel.profession);
                    //init visbility
                    if (position == 1) {
                        ((SuppendViewHolder1) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                        ((SuppendViewHolder1) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    } else {
                        StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 2);
                        if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                            ((SuppendViewHolder1) holder).tvStickyHeader.setVisibility(View.GONE);
                        } else {
                            ((SuppendViewHolder1) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                            ((SuppendViewHolder1) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                            holder.itemView.setTag(HAS_STICKY_VIEW);
                        }
                    }
                    break;
                case 102:
                    //init view
                    ((SuppendViewHolder2) holder).tvName.setText(stickyExampleModel.name);
                    ((SuppendViewHolder2) holder).tvGender.setText(stickyExampleModel.gender);
                    ((SuppendViewHolder2) holder).tvProfession.setText(stickyExampleModel.profession);
                    //init visbility
                    if (position == 1) {
                        ((SuppendViewHolder2) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                        ((SuppendViewHolder2) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    } else {
                        StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 2);
                        if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                            ((SuppendViewHolder2) holder).tvStickyHeader.setVisibility(View.GONE);
                        } else {
                            ((SuppendViewHolder2) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                            ((SuppendViewHolder2) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                            holder.itemView.setTag(HAS_STICKY_VIEW);
                        }
                    }
                    break;
                case 103:
                    //init view
                    ((SuppendViewHolder3) holder).tvName.setText(stickyExampleModel.name);
                    ((SuppendViewHolder3) holder).tvGender.setText(stickyExampleModel.gender);
                    ((SuppendViewHolder3) holder).tvProfession.setText(stickyExampleModel.profession);
                    //init visbility
                    if (position == 1) {
                        ((SuppendViewHolder3) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                        ((SuppendViewHolder3) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    } else {
                        StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 2);
                        if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                            ((SuppendViewHolder3) holder).tvStickyHeader.setVisibility(View.GONE);
                        } else {
                            ((SuppendViewHolder3) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                            ((SuppendViewHolder3) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                            holder.itemView.setTag(HAS_STICKY_VIEW);
                        }
                    }
                    break;
                case 104:
                    //init view
                    ((SuppendViewHolder4) holder).tvName.setText(stickyExampleModel.name);
                    ((SuppendViewHolder4) holder).tvGender.setText(stickyExampleModel.gender);
                    ((SuppendViewHolder4) holder).tvProfession.setText(stickyExampleModel.profession);
                    //init visbility
                    if (position == 1) {
                        ((SuppendViewHolder4) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                        ((SuppendViewHolder4) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                    } else {
                        StickyExampleModel lastStickyExampleModel = stickyExampleModels.get(position - 2);
                        if (stickyExampleModel.sticky.equals(lastStickyExampleModel.sticky)) {
                            ((SuppendViewHolder4) holder).tvStickyHeader.setVisibility(View.GONE);
                        } else {
                            ((SuppendViewHolder4) holder).tvStickyHeader.setVisibility(View.VISIBLE);
                            ((SuppendViewHolder4) holder).tvStickyHeader.setText(stickyExampleModel.sticky);
                            holder.itemView.setTag(HAS_STICKY_VIEW);
                        }
                    }
                    break;
                default:
                    break;
            }


//            //init item color
//            if (position % 2 == 0) {
//                ((SuppendViewHolder1) holder).rlContentWrapper.setBackgroundColor(
//                        ContextCompat.getColor(context, R.color.bg_color_1));
//            } else {
//                ((SuppendViewHolder1) holder).rlContentWrapper.setBackgroundColor(
//                        ContextCompat.getColor(context, R.color.bg_color_2));
//            }

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
        } else {
            return itemTyepMap.get(position-1);
        }
    }


    /**
     * 头布局的viewholer
     */
    public class SuppendHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_sticky_header;

        public SuppendHeaderViewHolder(View itemView) {
            super(itemView);
            tv_sticky_header = (TextView) itemView.findViewById(R.id.tv_sticky_header);
        }
    }

    /**
     * viewHolder 1
     */
    public class SuppendViewHolder1 extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendViewHolder1(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }

    /**
     * viewHolder 1
     */
    public class SuppendViewHolder2 extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendViewHolder2(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }

    /**
     * viewHolder 1
     */
    public class SuppendViewHolder3 extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendViewHolder3(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }

    /**
     * viewHolder 1
     */
    public class SuppendViewHolder4 extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;
        public TextView tvName;
        public TextView tvGender;
        public TextView tvProfession;

        public SuppendViewHolder4(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);
            tvProfession = (TextView) itemView.findViewById(R.id.tv_profession);
        }
    }


}
