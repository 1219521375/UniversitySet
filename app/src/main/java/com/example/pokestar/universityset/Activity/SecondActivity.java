package com.example.pokestar.universityset.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pokestar.universityset.R;

public class SecondActivity extends AppCompatActivity {

    private String[] data_a = {"我的收藏","我关注的"};
    private String[] data_b = {"阅读模式","夜间模式","字体设置"};
    private String[] data_c = {"设置"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayAdapter<String> adapter_a = new ArrayAdapter<String>(SecondActivity.this,
                android.R.layout.simple_list_item_1,data_a);
        ArrayAdapter<String> adapter_b = new ArrayAdapter<String>(SecondActivity.this,
                android.R.layout.simple_list_item_1,data_b);
        ArrayAdapter<String> adapter_c = new ArrayAdapter<String>(SecondActivity.this,
                android.R.layout.simple_list_item_1,data_c);
        ListView listView_a = findViewById(R.id.list_one);
        listView_a.setAdapter(adapter_a);
        ListView listView_b = findViewById(R.id.list_two);
        listView_b.setAdapter(adapter_b);
        ListView listView_c = findViewById(R.id.list_three);
        listView_c.setAdapter(adapter_c);

        listView_c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SecondActivity.this,SetActivity.class);
                startActivity(intent);
            }
        });

    }
}
