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
 * Created by Administrator on 2017/7/25 0025.
 */

public class RightFragment extends Fragment {
    private LinearLayout mContentView;
    private Context mContext;
    private OnRightListener listener;
    private RecyclerView mRecyclerView;
    private FragmentAdapter mAdapter;
    private String[] mStrs0 = new String[]{"1","2","3"};
    private String[] mStrs1 = new String[]{"4","5","6"};
    private String[] mStrs2 = new String[]{"7","8","9"};
    private LinearLayoutManager mLayoutManager;

    public static RightFragment getInstance(Intent intent) {
        RightFragment right = new RightFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", intent);
        right.setArguments(bundle);

        return right;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mContentView == null) {
            mContentView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.fragment_right, container, false);
        }

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) mContentView.findViewById(R.id.right_list);
        mAdapter = new FragmentAdapter(mContext, mStrs0);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return mContentView;
    }

    public void changeData(int position){
        switch (position){
            case 0:
                mAdapter.setmStrs(mStrs0);
                break;
            case 1:
                mAdapter.setmStrs(mStrs1);
                break;
            case 2:
                mAdapter.setmStrs(mStrs2);
                break;
        }
        mAdapter.notifyDataSetChanged();
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

    public interface OnRightListener {
        void rightClick();
    }
}
