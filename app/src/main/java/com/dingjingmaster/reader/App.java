package com.dingjingmaster.reader;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dingjingmaster.reader.fragment.FragmentCategory;
import com.dingjingmaster.reader.fragment.FragmentLike;
import com.dingjingmaster.reader.fragment.FragmentMy;
import com.dingjingmaster.reader.fragment.FragmentShelf;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class App extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @ViewInject(R.id.main_bottom_group)
    private RadioGroup group;

    @ViewInject(R.id.main_shelf)
    private RadioButton main_shelf;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ViewUtils.inject(this);

        // 初始化
        fragmentManager = getSupportFragmentManager();

        // 设置默认选中
        main_shelf.setChecked(true);
        group.setOnCheckedChangeListener(this);

        // 切换不同fragment
        changedFragment(new FragmentShelf(), false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.main_shelf:   // 书架
                changedFragment(new FragmentShelf(), true);
                break;
            case R.id.main_my:      // 我的
                changedFragment(new FragmentMy(), true);
                break;
            case R.id.main_category:    // 分类
                changedFragment(new FragmentCategory(), true);
                break;
            case R.id.main_like:
                changedFragment(new FragmentLike(), true);
                break;
            default:
                break;
        }
    }

    public void changedFragment (Fragment fragment, boolean isFirst) {
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.main_content, fragment);
        trans.commit();
    }

}
