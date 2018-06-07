package com.example.pokestar.universityset.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokestar.universityset.Activity.MainActivity;
import com.example.pokestar.universityset.R;


public class NotificationFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();




    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"通知onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"通知onAttact");

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
