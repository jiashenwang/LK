package linke.com.linke;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toolbar;


public class MainActivity extends ActionBarActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
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

    private void InitView(){

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.linke_blue)));

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(Data.TAB_NAV_CONTACTS),
                R.xml.tab_indicator_gen,"Audio",R.drawable.genres_icon),Contacts.class,null);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(Data.TAB_NAV_SELF),
                R.xml.tab_indicator_gen,"Video",R.drawable.genres_icon),Me.class,null);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(Data.TAB_NAV_SETTING),
                R.xml.tab_indicator_gen,"blank",R.drawable.genres_icon),null,null);
        mTabHost.addTab(setIndicator(MainActivity.this,mTabHost.newTabSpec(Data.TAB_NAV_NOTI),
                R.xml.tab_indicator_gen,"Latest",R.drawable.genres_icon),Notifaction.class,null);
        mTabHost.addTab(setIndicator(MainActivity.this, mTabHost.newTabSpec(Data.TAB_NAV_SETTING),
                R.xml.tab_indicator_gen, "Latest", R.drawable.genres_icon), Setting.class,null);
    }
    private TabHost.TabSpec setIndicator(Context ctx, TabHost.TabSpec spec,int resid, String string, int genresIcon) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.tab_item, null);
        v.setBackgroundResource(resid);
        //TextView tv = (TextView)v.findViewById(R.id.txt_tabtxt);
        ImageView img = (ImageView)v.findViewById(R.id.img_tabtxt);

        //tv.setText(string);
        img.setBackgroundResource(genresIcon);
        return spec.setIndicator(v);
    }
}
