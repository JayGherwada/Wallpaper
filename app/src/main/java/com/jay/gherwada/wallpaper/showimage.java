package com.jay.gherwada.wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class showimage extends BaseAdapter {

    MainActivity3 mainActivity3;
    int[] image1;

    public showimage(MainActivity3 mainActivity3, int[] image1) {

        this.image1=image1;
        this.mainActivity3=mainActivity3;
    }

    @Override
    public int getCount() {
        return image1.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(mainActivity3).inflate(R.layout.image_main,viewGroup,false);
        ImageView i2=view.findViewById(R.id.i2);
        i2.setImageResource(image1[i]);
        return view;
    }
}
