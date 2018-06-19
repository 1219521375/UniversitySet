package com.example.pokestar.universityset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pokestar.universityset.Activity.MainActivity;
import com.example.pokestar.universityset.Activity.SetActivity;
import com.example.pokestar.universityset.Adapter.SchoolAdapter;
import com.example.pokestar.universityset.Data.School;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class SchoolFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();

    ListView mListView;
    RecyclerView mRecyclerView;
    SchoolAdapter mAdapter;
    List<School> mSchoolList;



    public static SchoolFragment newInstance() {
        SchoolFragment fragment = new SchoolFragment();
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
        View view = inflater.inflate(R.layout.fragment_school, container, false);

        mListView = view.findViewById(R.id.school_select_list);
        mRecyclerView = view.findViewById(R.id.school_recycler_view);

        initView();

        return view;
    }

    private void initView() {

        String[] data = {"985","211","一本","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        ArrayAdapter<String> adapter_d = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(adapter_d);


        mSchoolList = new ArrayList<>();
        School school1 = new School("清华大学","https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2569105474,2378042018&fm=58&bpow=220&bpoh=220");
        mSchoolList.add(school1);
        School school2 = new School("北京大学","https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=813486924,4155436848&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school2);
        School school3 = new School("浙江大学","https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2646922489,2681531337&fm=58&bpow=908&bpoh=908");
        mSchoolList.add(school3);
        School school4 = new School("复旦大学","https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400");
        mSchoolList.add(school4);
        School school5 = new School("上海交通大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school5);
        School school6 = new School("中国科学技术大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school6);
        School school7 = new School("人民大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school7);
        School school8 = new School("南京大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school8);
        School school9 = new School("同济大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school9);
        School school10 = new School("南开大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school10);
        School school11 = new School("北京师范大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school11);
        School school12 = new School("武汉大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school12);
        School school13 = new School("北京航空航天大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school13);
        School school14 = new School("西安交通大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school14);
        School school15 = new School("华中科技大学","https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024");
        mSchoolList.add(school15);






        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);//定义瀑布流管理器，第一个参数是列数，第二个是方向。
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        mRecyclerView.setLayoutManager(layoutManager);//设置瀑布流管理器
        mAdapter = new SchoolAdapter(mSchoolList);
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
