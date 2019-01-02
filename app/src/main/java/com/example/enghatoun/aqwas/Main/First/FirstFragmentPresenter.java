package com.example.enghatoun.aqwas.Main.First;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class FirstFragmentPresenter implements FirstFragmentMVP.Presenter {
    private FirstFragmentMVP.View view;
    private FirstFragmentMVP.Model model;
    private FusedLocationProviderClient mfusedLocationClient;
    private double latitud,longitude;
    private Location mLastLocation;


    public FirstFragmentPresenter() {
        this.model = new FirstFragmentModel();
    }
    @Override
    public void getMainFragment() {

    }

    @Override
    public void loadData(String str) {
        Resturant resturant = model.getResturantFromNetwok(str);
        view.displayData(resturant);
    }

    @Override
    public void setView(FirstFragmentMVP.View view) {
        this.view = view;
    }

    @Override
    public String getLastLocation() {

        mfusedLocationClient = LocationServices.getFusedLocationProviderClient(view.getAppActivity());

        if (ActivityCompat.checkSelfPermission(view.getAppActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(view.getAppActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return null;
        }
        mfusedLocationClient.getLastLocation().addOnCompleteListener(view.getAppActivity(), new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    mLastLocation = task.getResult();
                    latitud = mLastLocation.getLatitude();
                    longitude = mLastLocation.getLongitude();
                    Log.d("4444", "late " + latitud + "long"+longitude, task.getException());

                } else {
                    Log.d("44433", "GetLastLocation:Exception", task.getException());
                }
            }
        });
        return latitud+","+longitude;
    }

}
