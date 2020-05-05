package com.chaiidev.kheknoi.ui.gallery;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaiidev.kheknoi.R;
import com.squareup.picasso.Picasso;

public class GalleryAdapter extends BaseAdapter {
    private final Context mContext;
    private final Gallery[] gallerys;

    // 1
    public GalleryAdapter(Context context, Gallery[] gallerys) {
        this.mContext = context;
        this.gallerys = gallerys;
    }

    // 2
    @Override
    public int getCount() {
        return gallerys.length;
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Gallery gallery = gallerys[position];

        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);

        } else {
            imageView = (ImageView) convertView;
        }


        Picasso.get().load(gallery.getImageUrl())
                .into(imageView);


        return imageView;
    }


}
