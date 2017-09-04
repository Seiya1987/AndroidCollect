package com.seiya.androidcollect.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.seiya.androidcollect.R;


/**
 * Created by Administrator on 2017/7/24 0024.
 */

public class LeftFragment extends Fragment {

    private LinearLayout mContentView;
    private Context mContext;
    private OnLeftListener listener;
    private RecyclerView mRecyclerView;
    private FragmentAdapter mAdapter;
    private String[] mStrs = new String[]{"1","2","3"};
    private LinearLayoutManager mLayoutManager;

    public static LeftFragment getInstance(Intent intent){
        LeftFragment left = new LeftFragment();
        Bundle bundle =new Bundle();
        bundle.putParcelable("data", intent);
        left.setArguments(bundle);
        return left;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        try{
            listener = (OnLeftListener) context;
        }catch (Exception e){
            throw new ClassCastException("can not cast");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mContentView == null) {
            mContentView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.fragment_left, container, false);
        }

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView) mContentView.findViewById(R.id.left_list);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FragmentAdapter(mContext, mStrs, listener);
        mRecyclerView.setAdapter(mAdapter);

        return mContentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnLeftListener{
        void leftClick(int position);
    }

}
