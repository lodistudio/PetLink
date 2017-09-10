package com.pethome.petlink.Activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.pethome.petlink.R;

public class News_Activity extends AppCompatActivity {
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //Código do sistema de Tabs
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }



    //Métodos do sistema de Tabs
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    News_Newpets_Fragment page_newpets = new News_Newpets_Fragment();
                    return page_newpets;
                case 1:
                    News_Lostpets_Fragment page_lostpets = new News_Lostpets_Fragment();
                    return page_lostpets;
                case 2:
                    News_Petshop_Fragment page_petshop = new News_Petshop_Fragment();
                    return page_petshop;
                case 3:
                    News_Pettips_Fragment page_pettips = new News_Pettips_Fragment();
                    return page_pettips;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4; // Total de 4 páginas.
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.tab_title_newpets);
                case 1:
                    return getString(R.string.tab_title_lostpets);
                case 2:
                    return getString(R.string.tab_title_petshop);
                case 3:
                    return getString(R.string.tab_title_pettips);
            }
            return null;
        }
    }
}
