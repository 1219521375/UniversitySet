package com.example.pokestar.universityset.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pokestar.universityset.R;

public class SetActivity extends AppCompatActivity {

    private String[] set_data = {"清理缓存","用户反馈","用户须知","版本更新","关于"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ArrayAdapter<String> adapter_d = new ArrayAdapter<String>(SetActivity.this,
                android.R.layout.simple_list_item_1,set_data);
        ListView listView_d = findViewById(R.id.set_list);
        listView_d.setAdapter(adapter_d);
    }
}
