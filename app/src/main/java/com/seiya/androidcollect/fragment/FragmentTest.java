package com.seiya.androidcollect.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.seiya.androidcollect.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/24 0024.
 */

public class FragmentTest extends FragmentActivity implements LeftFragment.OnLeftListener, RightFragment.OnRightListener{

    private LeftFragment mLeftFragment;
    private RightFragment mRightFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragement_layout);
        FragmentManager fm = getSupportFragmentManager();
        mLeftFragment = (LeftFragment) fm.findFragmentById(R.id.left_fragment);
        mRightFragment = (RightFragment) fm.findFragmentById(R.id.right_fragment);

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("goo");
        list.add("hah");
        list.add("ddd");

        Logger.d(list);
    }

    @Override
    public void leftClick(int postion) {
        mRightFragment.changeData(postion);
        Toast.makeText(this, "position is " + postion, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightClick() {
        
    }

    public void click1(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        if(null != fm.findFragmentByTag(mLeftFragment.getClass().getName())) {
//            ft.replace(R.id.fragment_container, mLeftFragment);
//        }else {
//            ft.add(R.id.fragment_container, mLeftFragment, mLeftFragment.getClass().getName());
//        }
//        ft.replace(R.id.fragment_container, mLeftFragment);
        ft.commit();
    }

    public void click2(View view){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        if(null != fm.findFragmentByTag(mRightFragment.getClass().getName())){
//            ft.replace(R.id.fragment_container, mRightFragment);
//        }else {
//            ft.add(R.id.fragment_container, mRightFragment, mRightFragment.getClass().getName());
//        }
//        ft.replace(R.id.fragment_container, mRightFragment);
        ft.commit();
    }
}
