package com.example.enghatoun.aqwas.Main.First;

import android.util.Log;
import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.HTTP.ApiUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstFragmentModel implements FirstFragmentMVP.Model {

    private Resturant resturant;

    public FirstFragmentModel() {}

    @Override
    public Resturant getResturantFromNetwok(String string) {//"26.2716025,50.2017993"

        ApiUtils.getAPIService().getRestaurant("26.2716025,50.2017993","value").enqueue(new Callback<Resturant>() {
            @Override
            public void onResponse(Call<Resturant> call, Response<Resturant> response) {

                if(response.isSuccessful()) {
                    resturant = new Resturant(response.body());
                    Log.d("44444", "post submitted to API." + response.body().getCat());
                }
            }

            @Override
            public void onFailure(Call<Resturant> call, Throwable t) {
                Log.e("44444", "Unable to submit post to API.");
                resturant = null;
            }
        });
      return resturant;
    }


}
