package com.nshane.picpicker.bean;

import com.yzs.imageshowpickerview.ImageShowPickerBean;

/**
 * Created by lbl on 2017/4/26.
 */

public class ImageBean extends ImageShowPickerBean { // bean should extends super class fm author

    private String url;
    private int resId;

    public ImageBean(String url) {
        this.url = url;
    }


    public ImageBean(int resId) {
        this.resId = resId;
    }


    @Override
    public String setImageShowPickerUrl() {
        return this.url;
    }

    @Override
    public int setImageShowPickerDelRes() {
        return this.resId;
    }
}
