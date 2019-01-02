package com.example.enghatoun.aqwas.Main;


public interface FragmentNavigation {
    interface View {
        void atachPresenter(Presenter presenter);
    }
    interface Presenter {
        void addFragment(BaseFragment fragment);
    }
}