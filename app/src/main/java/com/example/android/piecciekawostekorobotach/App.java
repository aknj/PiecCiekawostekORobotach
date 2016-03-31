package com.example.android.piecciekawostekorobotach;

import android.app.Application;

/**
 * Created by Agnieszka on 30.03.2016.
 */
public class App extends Application {

    private boolean knowsFact1;
    public boolean getKnowsFact1() {
        return knowsFact1;
    }
    public void setKnowsFact1(boolean value) {
        this.knowsFact1 = value;
    }

    private boolean knowsFact[] = new boolean[5];
    public boolean getKnowsFact(int i) {
        return knowsFact[i];
    }
    public void setKnowsFact(int i, boolean value) {
        this.knowsFact[i] = value;
    }
}
