package com.pethome.petlink.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pethome.petlink.R;

/**
 * Created by Maykel on 06/08/2017.
 */

public class News_Lostpets_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_tab_lostpets, container, false);
        return rootView;
    }
}
