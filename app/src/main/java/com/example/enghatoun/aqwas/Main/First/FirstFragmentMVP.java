package com.example.enghatoun.aqwas.Main.First;

import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;


public interface FirstFragmentMVP {

    interface View{
        void setFragment(FirstFragment fragment);
        void displayData(Resturant resturant);
        void hideProgressDialog();
        void showProgressDialog();
        void initProgressDialog();
    }

    interface Presenter{

        void getMainFragment();
        String getLastLocation();
        void loadData(String str);
        void setView(FirstFragmentMVP.View view);

    }

    interface Model{
        Resturant getResturantFromNetwok(String str);
    }
}
