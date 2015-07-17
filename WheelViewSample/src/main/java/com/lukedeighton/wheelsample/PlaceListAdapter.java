package com.lukedeighton.wheelsample;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nikhil Teja Alamanda on 30-06-2015.
 */

public class PlaceListAdapter extends ArrayAdapter<Place>{

    PlaceListAdapter(Context context,ArrayList<Place> places){
        super(context,0,places);
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        Place place = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.place_item,parent,false);
        }

        TextView t = (TextView)convertView.findViewById(R.id.textView);
        ImageView img = (ImageView)convertView.findViewById(R.id.imageView);

        t.setText(place.name);
        img.setImageResource(place.imageID);

        return convertView;
    }


}
