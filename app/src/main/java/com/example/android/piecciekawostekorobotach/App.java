package com.example.android.piecciekawostekorobotach;

import android.app.Application;


public class App extends Application {

    private boolean knowsFact[] = new boolean[5];
    public boolean getKnowsFact(int i) {
        return knowsFact[i];
    }
    public void setKnowsFact(int i, boolean value) {
        this.knowsFact[i] = value;
    }
}
