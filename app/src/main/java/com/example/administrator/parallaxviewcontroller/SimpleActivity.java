package com.example.administrator.parallaxviewcontroller;

/**
 * @author wangchengm
 * @date 2014 11 15
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.parallaxviewcontroller.adapter.MainAdapter;
import com.example.administrator.parallaxviewcontroller.model.CategoriesModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SimpleActivity extends AppCompatActivity {

    @Bind(R.id.rv_cate_recommend)
    RecyclerView mRvCateRecommend;

    private MainAdapter           mMainAdapter;
    private List<CategoriesModel> mCategoriesModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initVariables();
        initViews();
    }

    private void initVariables() {
        ButterKnife.bind(this);
        if (null == mCategoriesModelList) {
            mCategoriesModelList = new ArrayList<>();
        }
        //模拟数据
        for (int i = 0; i < 10; i++) {
            CategoriesModel model = new CategoriesModel();
            model.setTitle("美食家居");
            //图片需要1:1的图片
            model.setCoverUrl(R.mipmap.parallax_2);
            mCategoriesModelList.add(model);
        }
        mMainAdapter = new MainAdapter(this, mCategoriesModelList);
    }

    private void initViews() {
        mRvCateRecommend.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvCateRecommend.setAdapter(mMainAdapter);
    }
}
