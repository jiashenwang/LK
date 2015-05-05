package linke.com.linke;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class Contacts extends Fragment{

	FragmentTabHost mTabHost;
	
 
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		//View rootView = inflater.inflate(R.layout.contacts, container, true);

		mTabHost = new FragmentTabHost(inflater.getContext());
		mTabHost.setup(getActivity(), getChildFragmentManager(),R.layout.contacts);
		
		// Create Child Tab1
		mTabHost.addTab(mTabHost.newTabSpec("child_fregment_contacts").setIndicator("A - Z"),
				FragmentTabContacts.class, null);
 
		// Create Child Tab2
		mTabHost.addTab(mTabHost.newTabSpec("child_fregment_time").setIndicator("Time"),
				FragmentTabTime.class, null);
		
		// Create Child Tab2
		mTabHost.addTab(mTabHost.newTabSpec("child_fregment_location").setIndicator("Location"),
				FragmentTabLocation.class, null);
		
		return mTabHost;
		 
        //return rootView;
    }
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mTabHost = null;
	}

}
