package com.lukedeighton.wheelsample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.lukedeighton.wheelview.adapter.WheelArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class MainActivity extends Activity {

    TextView title;
    TextView description;
    ImageView titleBack;
    ImageView wheelBack;
    String[] titleList;
    String[] descriptionList;
    Animation fadeIn;
    Animation FadeOut;

    private static final int ITEM_COUNT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WheelView wheelView = (WheelView) findViewById(R.id.wheelview);
        title = (TextView)findViewById(R.id.title);
        description = (TextView)findViewById(R.id.description);
        //titleBack = (ImageView)findViewById(R.id.titleback);
        wheelBack = (ImageView)findViewById(R.id.wheelback);
        titleList = getResources().getStringArray(R.array.title_list);
        descriptionList = getResources().getStringArray(R.array.description_list);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_out);



        //create data for the adapter
        /*List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(ITEM_COUNT);
        for(int i = 0; i < ITEM_COUNT; i++) {
            Map.Entry<String, Integer> entry = MaterialColor.random(this, "\\D*_500$");
            entries.add(entry);
        }*/


        List<Drawable> entries = new ArrayList<Drawable>(ITEM_COUNT);
        for(int i=0; i<ITEM_COUNT ; i++){
            int drawableId;
            switch (i){
                case 0:
                    drawableId = R.drawable.n0; break;
                case 1:
                    drawableId = R.drawable.n1; break;
                case 2:
                    drawableId = R.drawable.n2; break;
                case 3:
                    drawableId = R.drawable.n3; break;
                case 4:
                    drawableId = R.drawable.n4; break;
                case 5:
                    drawableId = R.drawable.n5; break;
                case 6:
                    drawableId = R.drawable.n6; break;
                case 7:
                    drawableId = R.drawable.n7; break;
                case 8:
                    drawableId = R.drawable.n8; break;
                case 9:
                    drawableId = R.drawable.n9; break;
                case 10:
                    drawableId = R.drawable.n10; break;
                case 11:
                    drawableId = R.drawable.n11; break;
                default:
                    drawableId = R.drawable.images;
            }
            Drawable d = getResources().getDrawable(drawableId);
            entries.add(d);
        }

        //populate the adapter, that knows how to draw each item (as you would do with a ListAdapter)
        //wheelView.setAdapter(new MaterialColorAdapter(entries));
        wheelView.setAdapter(new MyCustomAdapter(entries));
        /*wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                return getResources().getDrawable(R.drawable.images);
            }

            @Override
            public int getCount() {
                return 10;
            }
        });*/

        //a listener for receiving a callback for when the item closest to the selection angle changes
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, int position) {
                //get the item at this position
                Drawable selectedEntry = ((WheelArrayAdapter<Drawable>)parent.getAdapter()).getItem(position);

                title.setText(titleList[position]);
                description.setText(descriptionList[position]);



            }
        });

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                String msg = String.valueOf(position) + " " + isSelected;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                switch (position) {
                    case 0:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, PlainActivity.class));
                        break;
                    case 1:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, TabbedActivity.class));
                        break;
                    case 2:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                        break;
                    case 3:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, ImageList.class));
                        break;
                    default:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, PlainActivity.class));
                        break;
                }


            }
        });

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        //wheelView.setWheelDrawable(R.drawable.back1);
        //initialise the selection drawable with the first contrast color
        //wheelView.setSelectionColor(getContrastColor(entries.get(0)));
    }

    //get the materials darker contrast
    private int getContrastColor(Map.Entry<String, Integer> entry) {
        String colorName = MaterialColor.getColorName(entry);
        return MaterialColor.getContrastColor(colorName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    static class MyCustomAdapter extends WheelArrayAdapter<Drawable>{
        MyCustomAdapter(List<Drawable> entries){
            super(entries);
        }


        @Override
        public Drawable getDrawable(int position) {
            return getItem(position);
        }

    }

    static class MaterialColorAdapter extends WheelArrayAdapter<Map.Entry<String, Integer>> {
        MaterialColorAdapter(List<Map.Entry<String, Integer>> entries) {
            super(entries);
        }

        @Override
        public Drawable getDrawable(int position) {
            Drawable[] drawable = new Drawable[] {
                    createOvalDrawable(getItem(position).getValue()),
                    new TextDrawable(String.valueOf(position))
            };
            return new LayerDrawable(drawable);
        }

        private Drawable createOvalDrawable(int color) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(color);
            return shapeDrawable;
        }
    }
}