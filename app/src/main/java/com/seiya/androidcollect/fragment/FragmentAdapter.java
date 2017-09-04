package com.seiya.androidcollect.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seiya.androidcollect.R;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class FragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final String TAG = "FragmentAdapter";
    private String[] mStrs;
    private Context mContext;
    private LeftFragment.OnLeftListener mListener;
    public FragmentAdapter(Context context, String[] strs){
        mStrs = strs;
        mContext = context;
    }

    public FragmentAdapter(Context context, String[] strs, LeftFragment.OnLeftListener listener){
        mStrs = strs;
        mContext = context;
        mListener = listener;
    }

    public void setmStrs(String[] strs){
        mStrs = strs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ItemViewHolder){
            ((ItemViewHolder)holder).tv.setText(mStrs[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.leftClick(position);
                    }
                }
            });
            Log.d(TAG, "onBindViewHolder" + mStrs[position]);
        }
        Log.d(TAG, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount");
        return mStrs.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ItemViewHolder(View itemView){
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
