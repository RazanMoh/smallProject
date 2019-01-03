package com.example.enghatoun.aqwas.Main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.HTTP.ApiService;
import com.example.enghatoun.aqwas.HTTP.ApiUtils;
import com.example.enghatoun.aqwas.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private ApiService mApiService;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mApiService = ApiUtils.getAPIService();
        return inflater.inflate(R.layout.fragment_main, container, false);
    }




    /*public void sendPost(String uid) {
        mApiService.getRestaurant("26.2716025,50.2017993" , "value")
                .enqueue(new Callback<Resturant>() {
            @Override
            public void onResponse(Call<Resturant> call, Response<Resturant> response) {

                if(response.isSuccessful()) {
                   // showResponse(response.body().toString());
                    Log.i("Hatoun", "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Resturant> call, Throwable t) {
                Log.e("hello", "Unable to submit post to API.");
            }
        });
    }
    */


}
