package com.example.pokestar.universityset.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokestar.universityset.Base.MyApplication;
import com.example.pokestar.universityset.Base.NetImageView;
import com.example.pokestar.universityset.Data.Event;
import com.example.pokestar.universityset.Data.HotTopic;
import com.example.pokestar.universityset.R;

import java.util.List;

/**
 * Created by PokeStar on 2018/6/6.
 */

public class HotTopicAdapter extends RecyclerView.Adapter<HotTopicAdapter.HotTopicHolder> {


    List<HotTopic> hotTopicLists;
    public static int num ;

    public HotTopicAdapter(List<HotTopic> hotTopicLists) {
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
    public void onBindViewHolder(HotTopicAdapter.HotTopicHolder holder, int position) {

        HotTopic hotTopic = hotTopicLists.get(position);
        holder.number.setText(hotTopic.getNumber() + "");
        holder.title.setText(hotTopic.getTitle());
        holder.mNetImageView.setImageURL(hotTopic.getImageUrl());
        num++;
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
}
