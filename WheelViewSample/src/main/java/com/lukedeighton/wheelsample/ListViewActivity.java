package com.lukedeighton.wheelsample;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import java.util.Arrays;


public class ListViewActivity extends ActionBarActivity {

    ListView mListView;
    String [] mListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListItems = new String[6];
        mListItems =  getResources().getStringArray(R.array.list_items);
       // Arrays.fill(mListItems,"dummy");
        for(String s: mListItems){

            Log.d("dfjalksfj", s);
        }
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mListItems);
        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(listViewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view, menu);
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
