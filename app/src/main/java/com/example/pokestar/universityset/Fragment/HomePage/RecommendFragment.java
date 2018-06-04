package com.example.pokestar.universityset.Fragment.HomePage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.pokestar.universityset.Fragment.HomePageFragment;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends Fragment {

    SliderLayout mSliderLayout;
    PagerIndicator mPagerIndicator;

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

        initImageSlider();





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
