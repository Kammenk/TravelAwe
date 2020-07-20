package com.example.travelawe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travelawe.adapter.Adapter;
import com.example.travelawe.models.Offers;
import com.example.travelawe.viewmodels.HomeFragmentViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    Adapter adapter;
    HomeFragmentViewModel mHomeFragmentViewModel;
    RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = rootView.findViewById(R.id.offersRecyclerView);

        mHomeFragmentViewModel = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);

        mHomeFragmentViewModel.getOffers().observe(this, new Observer<ArrayList<Offers>>() {
            @Override
            public void onChanged(ArrayList<Offers> offers) {
                adapter.notifyDataSetChanged();
            }
        });
        return rootView;
    }

    private void initRecyclerView(){
        adapter = new Adapter(mHomeFragmentViewModel.getOffers().getValue(),getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }
}
