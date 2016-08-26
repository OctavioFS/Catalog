package mx.com.richmond.catalog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    Bundle bundle = new Bundle();
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    int id;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb, int id) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.id = id;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        bundle.putInt("seriesId",id);
        switch(position){
            case 0:
                Desc desc = new Desc();
                desc.setArguments(bundle);
                return desc;
            case 1:
                Students students = new Students();
                students.setArguments(bundle);
                return students;
            case 2:
                Teachers teachers = new Teachers();
                teachers.setArguments(bundle);
                return teachers;
            case 3:
                ISBN isbn = new ISBN();
                isbn.setArguments(bundle);
                return isbn;
        }
        Desc desc = new Desc();
        return desc;
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}