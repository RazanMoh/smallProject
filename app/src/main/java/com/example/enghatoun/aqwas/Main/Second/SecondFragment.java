package com.example.enghatoun.aqwas.Main.Second;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.enghatoun.aqwas.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SecondFragment extends Fragment {


    private boolean mLocationPremissonGranted = false;
    private FusedLocationProviderClient mfusedLocationClient;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private static final String TAG = "Something";
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    double latitud;
    double longitude;

    protected Location mLastLocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mfusedLocationClient = LocationServices.getFusedLocationProviderClient(this.getActivity());

// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        getLastLocation();

    }


    private String getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        mfusedLocationClient.getLastLocation().addOnCompleteListener(this.getActivity(), new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    mLastLocation = task.getResult();
                    latitud = mLastLocation.getLatitude();
                    longitude = mLastLocation.getLongitude();
                    Log.v(TAG, "late " + latitud + "long"+longitude, task.getException());


                } else {
                    Log.v(TAG, "GetLastLocation:Exception", task.getException());
                }
            }
        });
       // Log.v(TAG, "late33333 " + latitud + "long"+longitude);
        return latitud+","+longitude;
    }


}


