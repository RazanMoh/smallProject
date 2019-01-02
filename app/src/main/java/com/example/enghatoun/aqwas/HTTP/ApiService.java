package com.example.enghatoun.aqwas.HTTP;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("GenerateFS.php")
    Call<Resturant> getRestaurant(@Path("uid") String uid ,
                                    @Path("get_param") String value);

}
