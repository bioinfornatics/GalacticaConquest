package game.bioinfornatics.galacticaconquest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * Created by jonathan on 20/07/14.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments;

    //Provide the adapter fragments list to display
    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();

    }
}