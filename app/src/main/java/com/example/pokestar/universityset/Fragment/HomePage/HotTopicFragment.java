package com.example.pokestar.universityset.Fragment.HomePage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokestar.universityset.Adapter.HotTopicAdapter;
import com.example.pokestar.universityset.Adapter.RecommendAdapter;
import com.example.pokestar.universityset.Data.HotTopic;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class HotTopicFragment extends Fragment {

    RecyclerView mRecyclerView;

    List<HotTopic> mHotTopicList;

    HotTopicAdapter mAdapter;


    public static HotTopicFragment newInstance(String param1, String param2) {
        HotTopicFragment fragment = new HotTopicFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_topic, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.hot_topic_recycler_view);

        initRecyclerView();



        return view;
    }

    private void initRecyclerView() {
        mHotTopicList = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < 10; i++) {
            HotTopic hotTopic1 = new HotTopic("中北大学兴晋挑战杯开幕","http://www.nuc.edu.cn/__local/8/7C/C2/D6DD7774BFA06F1ADB786F53E2C_8982913F_1CA73.jpg",j++);
            mHotTopicList.add(hotTopic1);
            HotTopic hotTopic2 = new HotTopic("中北大学校运会顺利闭幕","http://www.nuc.edu.cn/__local/8/7C/C2/D6DD7774BFA06F1ADB786F53E2C_8982913F_1CA73.jpg",j++);
            mHotTopicList.add(hotTopic2);
            HotTopic hotTopic3 = new HotTopic("2018年高考闭幕","http://www.nuc.edu.cn/__local/8/7C/C2/D6DD7774BFA06F1ADB786F53E2C_8982913F_1CA73.jpg",j++);
            mHotTopicList.add(hotTopic3);

        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于listview
        mAdapter = new HotTopicAdapter(mHotTopicList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
