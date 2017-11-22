package com.dingjingmaster.reader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DingJing on 2017/11/22.
 */

public class WelcomeGuidActive extends Activity {

    @ViewInject(R.id.welcomeGuideButton)
    private Button btn;

    @ViewInject(R.id.welcomeGuidePage)
    private ViewPager pager;

    private List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome_guide);
        ViewUtils.inject(this);

        initViewPager();
    }

    // 开始体验 按钮回调
    @OnClick(R.id.welcomeGuideButton)
    public void click(View view){
        startActivity(new Intent(getBaseContext(), App.class));
    }

    public void initViewPager(){
        list = new ArrayList<View>();
        ImageView iv1 = new ImageView(this);
        iv1.setImageResource(R.drawable.ic_launcher_background);
        list.add(iv1);

        ImageView iv2 = new ImageView(this);
        iv2.setImageResource(R.drawable.ic_launcher_background);
        list.add(iv2);

        ImageView iv3 = new ImageView(this);
        iv3.setImageResource(R.drawable.ic_launcher_background);
        list.add(iv3);

        pager.setAdapter(new MyPagerAdapter());

        // 监听 viewpage 滑动效果
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            // 页卡被选中
            @Override
            public void onPageSelected(int position) {
                if(2 == position){
                    btn.setVisibility(View.VISIBLE);
                }else {
                    btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // 定义view page 的适配器
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount(){

            return list.size();
        }

        @Override
        public boolean isViewFromObject (View arg0, Object arg1) {
            return arg0 == arg1;
        }

        //
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(list.get(position));

            return list.get(position);
        }

        // 重写初始化item实例 销毁
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(list.get(position));
        }
    }
}
