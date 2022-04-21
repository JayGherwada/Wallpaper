package com.jay.gherwada.wallpaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class viewpager_adapter extends PagerAdapter {

    MainActivity4 mainActivity4;
    int[] image;
    int pos;

    public viewpager_adapter(MainActivity4 mainActivity4, int[] image, int pos) {
        this.mainActivity4 = mainActivity4;
        this.image = image;
        this.pos=pos;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(mainActivity4).inflate(R.layout.item_layout,container,false);

        ImageView imageView1=view.findViewById(R.id.imageview1);
        imageView1.setImageResource(image[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
