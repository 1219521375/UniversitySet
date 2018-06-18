package com.example.pokestar.universityset.Fragment.HomePage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pokestar.universityset.Activity.EventActivity;
import com.example.pokestar.universityset.Base.NetImageView;
import com.example.pokestar.universityset.Data.Event;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class HotTopicFragment extends Fragment {

    RecyclerView mRecyclerView;

    List<Event> mEvents;

    HotTopicAdapter mAdapter;

    public static int num ;

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
        mEvents = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < 10; i++) {
            Event event1 = new Event("中北大学兴晋挑战杯开幕","dfsfdd","https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=f86cc076d539b6004dce08b1d16b5217/962bd40735fae6cd962b68f40fb30f2443a70f8c.jpg");
            mEvents.add(event1);
            Event event2 = new Event("中北大学校运会顺利闭幕","fdsfasdf","https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=f86cc076d539b6004dce08b1d16b5217/962bd40735fae6cd962b68f40fb30f2443a70f8c.jpg");
            mEvents.add(event2);
            Event event3 = new Event("2018年高考闭幕","dfgdgfd","https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=f86cc076d539b6004dce08b1d16b5217/962bd40735fae6cd962b68f40fb30f2443a70f8c.jpg");
            mEvents.add(event3);

        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于listview
        mAdapter = new HotTopicAdapter(mEvents);
        mAdapter.setOnItemClickListener(new HotTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //出错 Intent intent = EventActivity.newIntent(view.getContext(),mEventList.get(position).getId());
                Intent intent = EventActivity.newIntentOne(view.getContext(), mEvents.get(position).getTitle(),
                        mEvents.get(position).getDepict(),mEvents.get(position).getImageUrl());
                view.getContext().startActivity(intent);
            }
        });

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


    public static class HotTopicAdapter extends RecyclerView.Adapter<HotTopicAdapter.HotTopicHolder> {


        List<Event> hotTopicLists;

        private OnItemClickListener mOnItemClickListener;
        private OnItemLongClickListener mOnItemLongClickListener;

        public HotTopicAdapter(List<Event> hotTopicLists) {
            this.hotTopicLists = hotTopicLists;
        }

        @Override
        public HotTopicAdapter.HotTopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_topic_item,parent,false);
            HotTopicHolder holder = new HotTopicHolder(view);
            num=1;
            return holder;
        }


        @Override
        public void onBindViewHolder(final HotTopicAdapter.HotTopicHolder holder, int position) {

            Event hotTopic = hotTopicLists.get(position);
            holder.number.setText(num + "");
            holder.title.setText(hotTopic.getTitle());
            holder.mNetImageView.setImageURL(hotTopic.getImageUrl());
            num++;

            //判断是否设置了监听器
            if(mOnItemClickListener != null){
                //为ItemView设置监听器
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition(); // 1
                        mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                    }
                });
            }
            if(mOnItemLongClickListener != null){
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                        //返回true 表示消耗了事件 事件不会继续传递
                        return true;
                    }
                });
            }
        }


        @Override
        public int getItemCount() {
            return hotTopicLists.size();
        }

        public class HotTopicHolder extends RecyclerView.ViewHolder {

            TextView number;
            TextView title;
            NetImageView mNetImageView;


            public HotTopicHolder(View itemView) {
                super(itemView);
                number = (TextView) itemView.findViewById(R.id.hot_topic_number);
                title = (TextView)itemView.findViewById(R.id.hot_topic_title);
                mNetImageView = (NetImageView)itemView.findViewById(R.id.hot_topic_image);


            }
        }

        public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
            this.mOnItemClickListener = mOnItemClickListener;
        }

        public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
            this.mOnItemLongClickListener = mOnItemLongClickListener;
        }

        public interface OnItemClickListener{
            void onItemClick(View view,int position);
        }

        public interface OnItemLongClickListener{
            void onItemLongClick(View view,int position);
        }
    }

}
