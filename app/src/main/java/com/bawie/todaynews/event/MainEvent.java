package com.bawie.todaynews.event;

/**
 * Created by DELL on 2017/5/10.
 * 王锴
 */

public class MainEvent {

    public boolean white;

    public MainEvent(boolean white){
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }


}
