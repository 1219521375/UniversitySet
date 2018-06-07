package com.example.pokestar.universityset.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokestar.universityset.Base.MyApplication;
import com.example.pokestar.universityset.Data.Event;
import com.example.pokestar.universityset.R;

import java.util.List;

/**
 * Created by PokeStar on 2018/6/5.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private List<Event> mEventList;


    public RecommendAdapter(List<Event> eventList) {
        mEventList = eventList;
    }


    @Override
    public RecommendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecommendAdapter.ViewHolder holder, int position) {

        Event event = mEventList.get(position);
        holder.title.setText(event.getTitle());
        holder.depict.setText(event.getDepict());

    }


    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView depict;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.event_title);
            depict = (TextView)itemView.findViewById(R.id.event_depict);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MyApplication.getContext(),"打开介绍活动的Activity",Toast.LENGTH_SHORT).show();
        }
    }
}
