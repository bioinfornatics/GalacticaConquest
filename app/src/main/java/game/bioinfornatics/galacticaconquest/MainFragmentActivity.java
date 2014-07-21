package game.bioinfornatics.galacticaconquest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Vector;

/**
 * Created by jonathan on 20/07/14.
 */
public class MainFragmentActivity extends FragmentActivity {
    private PagerAdapter mPagerAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);

        // Create fragment list which will contain PagerAdapter to swipe between page
        List<Fragment> fragments = new Vector<Fragment>();

        // add Fragments
		fragments.add(Fragment.instantiate(this,PageOneFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageTwoFragment.class.getName()));
		fragments.add(Fragment.instantiate(this,PageThreeFragment.class.getName()));

		// Create adapter dto display Fragments
		this.mPagerAdapter = new MainPagerAdapter(super.getSupportFragmentManager(), fragments);

		ViewPager pager = (ViewPager) super.findViewById(R.id.pager);
		// Assign adapter to ViewPager
		pager.setAdapter(this.mPagerAdapter);
    }


}
