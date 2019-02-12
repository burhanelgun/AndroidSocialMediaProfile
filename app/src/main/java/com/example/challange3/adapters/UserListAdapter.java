package com.example.challange3.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.challange3.MyAdapterListener;
import com.example.challange3.R;
import com.example.challange3.models.FeedItemModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    ArrayList<FeedItemModel> mValues;

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public MyAdapterListener onClickListener;


    public UserListAdapter(Context context, ArrayList<FeedItemModel> data, MyAdapterListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mValues = data;
        onClickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_user_item, parent, false);
        return new ViewHolder(view);
    }
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.get().load(mValues.get(position).getDrawable()).into(holder.userImageView);
        holder.followDateTextView.setText(mValues.get(position).getFollowDate()+" ago");
        holder.followersCountTextView.setText(mValues.get(position).getNumOfFollowers()+" followers");
        holder.userNameFTextView.setText(mValues.get(position).getUserNameF());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView userImageView;
        TextView userNameFTextView;
        TextView followersCountTextView;
        TextView followDateTextView;

        ViewHolder(View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.userImageF);
            userNameFTextView=itemView.findViewById(R.id.userNameF);
            followersCountTextView=itemView.findViewById(R.id.followersCount);
            followDateTextView=itemView.findViewById(R.id.followDate);


        }

        @Override
        public void onClick(View view) {

        }
    }


    public FeedItemModel getItem(int id) {
        return mValues.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}