package com.example.gridviewalpha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Integer[] images = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
    };
    Context context;
    ImageAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(200,200));
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }


}
