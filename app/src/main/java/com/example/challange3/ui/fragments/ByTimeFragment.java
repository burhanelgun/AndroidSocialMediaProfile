package com.example.challange3.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.challange3.MyAdapterListener;
import com.example.challange3.R;
import com.example.challange3.adapters.UserListAdapter;
import com.example.challange3.models.FeedItemModel;
import com.example.challange3.ui.activities.ScrollingActivity;

import java.util.ArrayList;

public class ByTimeFragment extends android.support.v4.app.Fragment implements UserListAdapter.ItemClickListener, MyAdapterListener {

        UserListAdapter adapter;
        ArrayList<FeedItemModel> libraryListImages= new ArrayList();

        public static ByTimeFragment newInstance() {
        ByTimeFragment fragment = new ByTimeFragment();
        return fragment;
        }

@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_by_time, container, false);

        libraryListImages= ScrollingActivity.post.getFeedByTime();

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.byTimeList);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new UserListAdapter(this.getActivity(), libraryListImages, this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
        }

@Override
public void iconImageViewOnClick(View v, int position) {
        }
@Override
public void onItemClick(View view, int position) {
        }
        }