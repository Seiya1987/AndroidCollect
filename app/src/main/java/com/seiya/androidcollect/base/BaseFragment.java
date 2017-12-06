package com.seiya.androidcollect.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

public abstract class BaseFragment extends Fragment {
    private boolean isVisible = false;//当前Fragment是否可见
    private boolean isInitView = false;//是否与View建立起映射关系
    private boolean isFirstLoad = true;//是否是第一次加载数据

    private View convertView;
    private SparseArray<View> mViews;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Logger.d("1\t**************onAttach**************");
    }

    @Override
    public void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d("2\t**************onCreate**************");
    }

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, Bundle savedInstanceState) {
        Logger.d("3\t**************onCreateView**************");
        convertView = inflater.inflate(getLayoutId(),container, false);
        mViews = new SparseArray<View>();
        initView();
        isInitView = true;
        lazyLoadData();
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.d("4\t**************onActivityCreated**************");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Logger.d("5\t**************onViewStateRestored**************");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.d("6\t**************onStart**************");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d("7\t**************onResume**************");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.d("8\t**************onPause**************");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.d("9\t**************onStop**************");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.d("10\t**************onDestroyView**************");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.d("11\t**************onDestroy**************");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.d("12\t**************onDetach**************");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Logger.d("**************setUserVisibleHint: "+ isVisibleToUser +" **************");
        if(isVisibleToUser){
            isVisible = true;
            lazyLoadData();
        }else{
            isVisible = false;
        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    private void lazyLoadData(){
        if(isFirstLoad){
            Logger.d("first Load, isInitView " + isInitView + "\t isVisible" + isVisible);
        }else{
            Logger.d("first not Load, isInitView " + isInitView + "\t isVisible" + isVisible);
        }
        if(!isFirstLoad || !isVisible || !isInitView){
            Logger.d("mismatch condition");
            return;
        }

        Logger.d("First load data.................");
        initData();
        isFirstLoad = false;
    }

    /**
     * 加载布局文件id
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 布局种的view与fragment中变量建立映射
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void initData();

    protected <E extends View> E findView(int viewId){
        if(null != convertView){
            E view = (E) mViews.get(viewId);
            if(null == view){
                view = (E) convertView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return view;
        }
        return null;
    }
}

