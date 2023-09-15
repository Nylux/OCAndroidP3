package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position)
    {
        if (position == 0)
            return NeighbourFragment.newInstance();
        else
            return FavoriteListFragment.newInstance();
    }

    /**
     * get the number of pages
     * @return
     */
    @Override // Retourne le nombre de fragments
    public int getCount() {
        return 2;
    }
}