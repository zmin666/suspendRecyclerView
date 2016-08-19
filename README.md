# suspendRecyclerView
#悬浮列表
最近研究了悬浮列表的实现方式.最后的效果图如下:

![image](https://github.com/zmin666/suspendRecyclerView/blob/master/picture_title.gif )

###基本实现原理
recyclerView和一个view组合而成的.
'<merge>

    <android.support.v7.widget.RecyclerView
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/rv_sticky_example"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical"/>

    <include layout="@layout/layout_sticky_header_view"/>
</merge>'

recyclerView的item和标题是一体.在recyclerView适配器中onBind控制每个item的标题是否显示.
<p></p>
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

	

监听recyclerView的滚动事件,
判断view是否应该显示,和怎么移动.
<p></p>
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

                int firstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                suspendView.setText(DataUtil.getData().get(firstVisibleItemPosition).sticky);
            }

        });
    }

##### 两种不同的title替换 
不同的title替换,主要逻辑就是有两个悬浮标题.需要判断什么时候显示那一个.可以参考第三个界面的实现.
####  加上头布局
由于recylceView本身是不支持头布局的,所以头布局本身也是一个类型的item.可以参考第四个界面的实现.
####  加上头布局和分组item.
最后一个界面的加上了头布局,每组下面的item都可以指定不同类型item布局. 因为recyclerVeiw的适配器是
viewholder来完成数据填充.所以需要建不同的hodler.可以参考最后一个界面的实现.
