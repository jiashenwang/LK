package linke.com.linke;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapterContacts extends FragmentStatePagerAdapter{

	public TabPagerAdapterContacts(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) {
	    switch (index) {
        case 0:
            //Fragement for contacts
            return new FragmentTabContacts();
        case 1:
           //Fragment for timeline
            return new FragmentTabTime();
        case 2:
            //Fragment for location
            return new FragmentTabLocation();
        }
	    return null;
	}

	@Override
	public int getCount() {
		return 3; // num of tabs in contacts page
	}

}
