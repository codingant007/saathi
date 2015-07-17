package com.lukedeighton.wheelsample;
import java.util.Locale;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.lukedeighton.wheelsample.R;

public class TabbedActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    String[] titles = {"one","two","three"};
   static  ArrayAdapter<String> a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("enterd","good");
        super.onCreate(savedInstanceState);
        Log.d("oncreate","good");
        setContentView(R.layout.activity_tabbed);
        Log.d("setcontentview","setcontentview");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        Log.d("page","page");
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        Log.d("1","1");
        mViewPager.setAdapter(mSectionsPagerAdapter);
        Log.d("wtf", "wtf!!");
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeButtonEnabled(false);
        //noinspection ResourceType
        // actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(mViewPager);
/*
        mListItems = new String[6];
        mListItems = getResources().getStringArray(R.array.list_items);
        for(String s: mListItems){

            Log.d("dfjalksfj", s);
        }
        mListView = (ListView)findViewById(R.id.list);
        if(mListView == null){
            Log.d("li " , "YOLO1");
        }
        ArrayAdapter<String> a =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mListItems);
        if(a == null){
            Log.d("li " , "YOLO");
        }
        mListView.setAdapter(a);*/
        //tabs.setOnPageChangeListener();

        String[] arr = {"nik","sfasdfa","sdfasf","ipsum","likes"};
       a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
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


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return FragOne.newInstance(position);
                case 1:
                    return FragTwo.newInstance(position);
                case 2:
                    return  FragThree.newInstance(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            return titles[position];
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed_activity, container, false);
            return rootView;
        }
    }


    public static class FragOne extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "0";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FragOne newInstance(int sectionNumber) {
            FragOne fragment = new FragOne();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public FragOne() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);



            ListView l = (ListView)rootView.findViewById(R.id.list_tab_one);
            l.setAdapter(a);

            return rootView;
        }
    }

    public static class FragTwo extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "1";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FragTwo newInstance(int sectionNumber) {
            FragTwo fragment = new FragTwo();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);




            return fragment;
        }

        public FragTwo() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
            return rootView;
        }
    }

    public static class FragThree extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "2";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FragThree newInstance(int sectionNumber) {
            FragThree fragment = new FragThree();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public FragThree() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);
            return rootView;
        }
    }

}
