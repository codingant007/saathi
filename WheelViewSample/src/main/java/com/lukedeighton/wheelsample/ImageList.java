package com.lukedeighton.wheelsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import com.lukedeighton.wheelsample.Place;

import java.util.ArrayList;
import java.util.Arrays;

public class ImageList extends ActionBarActivity {

    ListView imgList;
    PlaceListAdapter adpt;
    ArrayList<Place> places;
    String[] placeNamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        placeNamesList = new String[20];
        Arrays.fill(placeNamesList,"dummy");
        places = new ArrayList<Place>(20);

        for( String s : placeNamesList){
            Place tempPlaceObj = new Place(s,R.drawable.images);
            if(tempPlaceObj == null){
                Log.d("holly molly!",s + " " + R.drawable.images );
            }
            else{
                Log.d("man i'm so fucked!","blah");
            }
            places.add(tempPlaceObj);
        }

        adpt = new PlaceListAdapter(this,places);

        imgList = (ListView)findViewById(R.id.image_list);
        imgList.setAdapter(adpt);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
