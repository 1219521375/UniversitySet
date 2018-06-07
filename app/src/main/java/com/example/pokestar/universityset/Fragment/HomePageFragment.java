package com.example.pokestar.universityset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokestar.universityset.Adapter.FragmentAdapter;
import com.example.pokestar.universityset.Fragment.HomePage.HotTopicFragment;
import com.example.pokestar.universityset.Fragment.HomePage.RecommendFragment;
import com.example.pokestar.universityset.Activity.MainActivity;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class HomePageFragment extends Fragment {


    private String TAG = MainActivity.class.getSimpleName();

    TabLayout mTabLayout;
    ViewPager mViewPager;

    HotTopicFragment mHotTopicFragment;
    RecommendFragment mRecommendFragment;


    public HomePageFragment() {
        // Required empty public constructor
    }

    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"首页onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        mTabLayout = (TabLayout)view.findViewById(R.id.homepage_tablayout);
        mViewPager = (ViewPager)view.findViewById(R .id.homepage_viewpager);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mRecommendFragment = new RecommendFragment();
        mHotTopicFragment = new HotTopicFragment();

        mTabLayout.addTab(mTabLayout.newTab().setText("推荐"));
        mTabLayout.addTab(mTabLayout.newTab().setText("热榜"));

        List<String> titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热榜");

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(mRecommendFragment);
        fragmentList.add(mHotTopicFragment);

        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(), fragmentList, titles);
        mViewPager.setAdapter(adapter);
        //关联TabLayout与ViewPager
        //覆写PagerAdapter的getPageTitle方法，否则Tab没有title
       mTabLayout.setupWithViewPager(mViewPager);
       mTabLayout.setTabsFromPagerAdapter(adapter);


        return view;
    }


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Log.d(TAG,"首页onAttact");
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
