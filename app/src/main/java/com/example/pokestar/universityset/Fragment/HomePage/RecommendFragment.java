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
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.pokestar.universityset.Adapter.RecommendAdapter;
import com.example.pokestar.universityset.Data.Event;
import com.example.pokestar.universityset.Fragment.HomePageFragment;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends Fragment {

    SliderLayout mSliderLayout;
    PagerIndicator mPagerIndicator;

    RecyclerView mRecyclerView;

    RecommendAdapter mRecommendAdapter;

    List<Event> mEventList;

    public static RecommendFragment newInstance(String param1, String param2) {
        RecommendFragment fragment = new RecommendFragment();
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
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        mSliderLayout = (SliderLayout)view.findViewById(R.id.slider);
        mPagerIndicator = (PagerIndicator)view.findViewById(R.id.custom_indicator);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recommend_recycler_view);

        initImageSlider();

        initRecyclerView();



        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private void initRecyclerView() {
        mEventList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Event event1 = new Event("太原理工大学举办运动会","2018年某月某日，太原理工大学方式大发噶发噶梵蒂冈梵蒂冈反对撒广泛的sadfadsfsdfdasffadsfgds大噶是否大噶是否大噶是否");
            Event event2 = new Event("山西大学举办运动会","2018年某月某日，山西大学方式噶是否大噶是否大噶范德萨发大水dfasdfsdf大噶是否大噶是否大噶是否大噶是否大大噶是否噶是否");
            Event event3 = new Event("北京大学举办运动会","2018年某月某日，北京大学方式4534534153454534353554大噶是否大噶是否大噶是否大噶是否大噶是否大噶是大噶是否大噶是否否");
            Event event4 = new Event("清华大学举办运动会","2018年某月某日，清华大学方式sdagfasfgadgfdgfdgdfgf大噶是否大噶是否大噶是否大噶是否大噶是否大噶是否大噶是否大噶是否");
            mEventList.add(event1);
            mEventList.add(event2);
            mEventList.add(event3);
            mEventList.add(event4);
        }





        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于listview
        mRecommendAdapter = new RecommendAdapter(mEventList);
        mRecyclerView.setAdapter(mRecommendAdapter);



    }

    private void initImageSlider() {

        List<String> imageUrls = new ArrayList<>();
        final List<String> description = new ArrayList<>();

        imageUrls.add("http://www.nuc.edu.cn/__local/5/40/67/CD94357A902B2580760328EB82F_1A8F1041_2B67A.jpg");
        imageUrls.add("http://www.nuc.edu.cn/__local/E/E4/02/69BEED7211E3CDA1793E2444904_B97864E6_1760F.jpg");
        imageUrls.add("http://www.nuc.edu.cn/__local/5/40/67/CD94357A902B2580760328EB82F_1A8F1041_2B67A.jpg");
        imageUrls.add("http://www.nuc.edu.cn/__local/E/E4/02/69BEED7211E3CDA1793E2444904_B97864E6_1760F.jpg");
        imageUrls.add("http://www.nuc.edu.cn/__local/5/40/67/CD94357A902B2580760328EB82F_1A8F1041_2B67A.jpg");
        imageUrls.add("http://www.nuc.edu.cn/__local/E/E4/02/69BEED7211E3CDA1793E2444904_B97864E6_1760F.jpg");
        description.add("中北大学校运会成功举办");
        description.add("中北大学征兵仪式顺利进行");
        description.add("中北大学校运会成功举办");
        description.add("中北大学征兵仪式顺利进行");
        description.add("中北大学校运会成功举办");
        description.add("中北大学征兵仪式顺利进行");


        for (int i = 0; i < imageUrls.size(); i++) {
            TextSliderView tsv = new TextSliderView(getActivity());
            tsv.image(imageUrls.get(i)).description(description.get(i));
            final int finalI = i;
            tsv.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getActivity(),"打开EventActivity 未实现",Toast.LENGTH_SHORT).show();
                }
            });
            mSliderLayout.addSlider(tsv);
        }

        // 设置默认过渡效果(可在xml中设置)
        //mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        // 设置默认指示器位置(默认指示器白色,位置在sliderlayout底部)
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        // 设置自定义指示器(位置自定义)
        mSliderLayout.setCustomIndicator(mPagerIndicator);
        // 设置TextView自定义动画
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());

    }



}
