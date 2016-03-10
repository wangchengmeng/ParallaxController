package com.example.administrator.parallaxviewcontroller.adapter;

/**
 * @author wangchengm
 * @date 2015 11 15
 */

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.parallaxviewcontroller.R;
import com.example.administrator.parallaxviewcontroller.model.CategoriesModel;
import com.example.administrator.parallaxviewcontroller.utils.DensityUtils;
import com.example.administrator.parallaxviewcontroller.utils.UIUtil;
import com.example.administrator.parallaxviewcontroller.widget.ParallaxViewController;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private static final int SPACE_VALUE = 10;
    private static final int NUM_COLUMNS = 4;
    private Activity mActivity;
    private ParallaxViewController mController = new ParallaxViewController();
    private List<CategoriesModel> mCategoriesModel;

    public MainAdapter(Activity activity, List<CategoriesModel> model) {
        this.mCategoriesModel = model;
        mActivity = activity;
    }

    @Override
    public int getItemCount() {
        if (null == mCategoriesModel) {
            return 0;
        }
        return mCategoriesModel.size();
    }

    public CategoriesModel getItem(int position) {
        if (null == mCategoriesModel) {
            return null;
        }
        return mCategoriesModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_simple, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CategoriesModel model = mCategoriesModel.get(position);
        holder.mTvTitle.setText(model.getTitle());
        holder.mIvCover.setImageResource(model.getCoverUrl());
        holder.mViewRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mActivity, "点击跳转", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mController.registerImageParallax(recyclerView);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        int mItemSize = (DensityUtils.getScreenW() - DensityUtils.dip2px(SPACE_VALUE)) / NUM_COLUMNS + DensityUtils.dip2px(25);

        @Bind(R.id.root_view)
        View      mViewRoot;
        @Bind(R.id.rl_cover)
        View      mRlCover;
        @Bind(R.id.iv_decoration_left)
        ImageView mIvDecorationLeft;
        @Bind(R.id.tv_title)
        TextView  mTvTitle;
        @Bind(R.id.iv_decoration_right)
        ImageView mIvDecorationRight;
        @Bind(R.id.iv_cover)
        ImageView mIvCover;
        @Bind(R.id.rl_space)
        View      mRlSpace;
        @Bind(R.id.iv_bottom)
        ImageView mIvBottom;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            UIUtil.setViewHeight(mIvCover, DensityUtils.getScreenW() * 840 / 1080);
            UIUtil.setViewHeight(mRlCover, DensityUtils.getScreenW() * 980 / 1080);
            UIUtil.setViewHeight(mIvBottom, mItemSize);
            DensityUtils.measure(mIvDecorationLeft, 20, 20);
            DensityUtils.measure(mIvDecorationRight, 20, 20);
            DensityUtils.measure(mRlSpace, 0, 60);
            mController.imageParallax(mIvCover);
        }
    }
}

