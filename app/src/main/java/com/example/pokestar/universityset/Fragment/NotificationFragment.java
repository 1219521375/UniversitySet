package com.example.pokestar.universityset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokestar.universityset.Activity.MainActivity;
import com.example.pokestar.universityset.Adapter.UsersAdapter;
import com.example.pokestar.universityset.Data.User;
import com.example.pokestar.universityset.R;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();

    private List<User> usersList = new ArrayList<>();
    RecyclerView recyclerView;

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);


        recyclerView = (RecyclerView)view.findViewById(R.id.notification_recycler_view);
        initRecyclerView();


        return view;
    }

    private void initRecyclerView() {

        for (int i = 0; i <10; i++) {
            User user1 = new User(R.mipmap.headpic1,"小明","您关注的问题/“有哪些优质211大学推荐/”有了新回答");
            usersList.add(user1);
            User user2 = new User(R.mipmap.headpic2,"李华","您的回答有了新评论");
            usersList.add(user2);
            User user3 = new User(R.mipmap.headpic3,"韩梅梅","有人向你发起提问");
            usersList.add(user3);
        }



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        UsersAdapter adapter = new UsersAdapter(usersList);
        recyclerView.setAdapter(adapter);
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
