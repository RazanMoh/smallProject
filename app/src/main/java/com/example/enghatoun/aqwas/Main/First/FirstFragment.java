package com.example.enghatoun.aqwas.Main.First;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;
import com.example.enghatoun.aqwas.Main.FragmentNavigation;
import com.example.enghatoun.aqwas.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

public class FirstFragment extends Fragment implements OnMapReadyCallback , FirstFragmentMVP.View, FragmentNavigation.View{
    protected FragmentNavigation.Presenter navigationPresenter;
    private MapView mMapView;
    private FusedLocationProviderClient mfusedLocationClient;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private FirstFragmentMVP.Presenter presenter;

    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @NonNull

   @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        mMapView = (MapView)view.findViewById(R.id.mapView);

        initGoogleMap(savedInstanceState);

        presenter = new FirstFragmentPresenter();
        presenter.setView(this);
        presenter.loadData(presenter.getLastLocation());

        //mfusedLocationClient = LocationServices.getFusedLocationProviderClient(this.getActivity());

        return view;
    }


    private void initGoogleMap(Bundle savedInstanceState){

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void setFragment(FirstFragment fragment) {

    }

    @Override
    public void displayData(Resturant resturant) {//displayData(Resturant resturant)
        //UI
    }

    @Override
    public void hideProgressDialog() {
        try {

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog.hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setMessage("Loading...");
        } else {
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);

            try {
                progressDialog.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void initProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
    }

  @Override
  public FragmentActivity getAppActivity() {
    return this.getActivity();
  }


  @Override
    public void atachPresenter(FragmentNavigation.Presenter presenter) {
        navigationPresenter = presenter;
    }
}