package com.example.pokestar.universityset.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pokestar.universityset.Activity.MainActivity;
import com.example.pokestar.universityset.Activity.SecondActivity;
import com.example.pokestar.universityset.R;


public class MineFragment extends Fragment {

    private String TAG = MainActivity.class.getSimpleName();

    private EditText id_login;
    private EditText password_login;
    private ImageView logo_login;
    private Button login_button;
    private SharedPreferences sp;
    private String acount;
    private String password;
    private static final int PASSWORD_MIWEN = 0x81;


    public static MineFragment newInstance(String param1) {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        sp = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);  //目前只有着一种模式可选，其他模式已均被废弃

        id_login = (EditText)view.findViewById(R.id.login_id);
        password_login = (EditText)view.findViewById(R.id.login_password);
        login_button = (Button)view.findViewById(R.id.login_button);
        logo_login = (ImageView)view.findViewById(R.id.login_logo);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String acount = id_login.getText().toString();
                String password = password_login.getText().toString();
                if (acount.equals("123456") && password.equals("123456")){
                    Intent intent = new Intent(getActivity(),SecondActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(),"账号或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });


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


}
