package com.example.travelawe.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.travelawe.models.Offers;

import java.util.ArrayList;

public class HomeFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Offers>> mOffers;

    public LiveData<ArrayList<Offers>> getOffers(){
        return mOffers;
    }

}
