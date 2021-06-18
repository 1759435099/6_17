package com.example.a6_4.landscape;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a6_4.R;

import java.util.List;

public class landscapeAdapter extends RecyclerView.Adapter<landscapeAdapter.ViewHolder>{

    private static final String TAG = "LandscapeAdapter";

    private Context mContext;

    private List<landscape> mLandscapeList;

    ImageView ivImage;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView landscape_image;
        TextView landscape;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            landscape_image = view.findViewById(R.id.landscape_image);
            landscape = view.findViewById(R.id.landscape);
        }
    }

    public landscapeAdapter(List<landscape> landscapeList) {
        mLandscapeList = landscapeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                landscape landscape = mLandscapeList.get(position);
                Intent intent = new Intent(mContext, landscapeActivity.class);
                intent.putExtra(landscapeActivity.LANDSCAPE_NAME, landscape.getName());
                intent.putExtra(landscapeActivity.LANDSCAPE_ID, landscape.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        landscape landscape = mLandscapeList.get(position);
        holder.landscape.setText(landscape.getName());
        Glide.with(mContext).load(landscape.getImageId()).into(holder.landscape_image);
    }

    @Override
    public int getItemCount() {
        return mLandscapeList.size();
    }



}
