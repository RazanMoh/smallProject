package com.example.enghatoun.aqwas.Main.First;

import android.util.Log;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.HTTP.ApiUtils;
import io.reactivex.Observable;


public class FirstFragmentModel implements FirstFragmentMVP.Model {

    private Resturant resturant;

    public FirstFragmentModel() {}

    @Override
    public Observable<Resturant> getResturantFromNetwok(String string) {
        Log.v("222223333", "late string " + string);
      // RxJava
      return ApiUtils.getAPIService().getRestaurant(string,"value");
        /*
        Log.v("222223333", "late string " + string);
        ApiUtils.getAPIService().getRestaurant(string,"value").enqueue(new Callback<Resturant>() {
            @Override
            public void onResponse(Call<Resturant> call, Response<Resturant> response) {

                if(response.isSuccessful()) {
                    resturant = new Resturant(response.body());
                    Log.d("44444", "post submitted to API." + response.body().getLat()+"|||||"+response.body().getLon());
                }
            }

            @Override
            public void onFailure(Call<Resturant> call, Throwable t) {
                Log.e("44444", "Unable to submit post to API.");
                resturant = null;
            }
        });
      return resturant;
      */
       // public Observable<Restaurant> getReposFromNetwork(String username) {

    }


}
