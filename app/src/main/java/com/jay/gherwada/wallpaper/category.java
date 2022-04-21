package com.jay.gherwada.wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class category extends BaseAdapter {

    MainActivity mainActivity;
    int[] image;
    String[] name;

    public category(MainActivity mainActivity, int[] image, String[] name) {

        this.name= name;
        this.image=image;
        this.mainActivity=mainActivity;
    }

    @Override
    public int getCount() {
        return image.length;
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

        view= LayoutInflater.from(mainActivity).inflate(R.layout.category_main,viewGroup,false);
        ImageView i1=view.findViewById(R.id.i1);
        i1.setImageResource(image[i]);

        TextView t1=view.findViewById(R.id.t1);
        t1.setText(name[i]);

        return view;
    }
}
