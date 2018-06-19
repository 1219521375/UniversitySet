package com.example.pokestar.universityset.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pokestar.universityset.Base.NetImageView;
import com.example.pokestar.universityset.Data.School;
import com.example.pokestar.universityset.R;

import java.util.List;

/**
 * Created by PokeStar on 2018/6/19.
 */

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {

    List<School> mSchoolList;

    public SchoolAdapter(List<School> schoolList) {
        mSchoolList = schoolList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        School school = mSchoolList.get(position);
        holder.mTextView.setText(school.getName());
        holder.mImageView.setImageURL(school.getImageUrl());

    }

    @Override
    public int getItemCount() {
        return mSchoolList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        NetImageView mImageView;
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (NetImageView) itemView.findViewById(R.id.school_image);
            mTextView = (TextView)itemView.findViewById(R.id.school_name);

        }
    }
}
