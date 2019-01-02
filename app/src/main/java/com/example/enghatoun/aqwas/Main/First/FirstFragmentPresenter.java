package com.example.enghatoun.aqwas.Main.First;


import com.example.enghatoun.aqwas.HTTP.APIModel.Resturant;

public class FirstFragmentPresenter implements FirstFragmentMVP.Presenter {
    private FirstFragmentMVP.View view;
    private FirstFragmentMVP.Model model;


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
        return null;
    }
}
