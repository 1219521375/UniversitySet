package com.example.pokestar.universityset.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pokestar.universityset.Base.NetImageView;
import com.example.pokestar.universityset.Data.Event;
import com.example.pokestar.universityset.Data.EventLab;
import com.example.pokestar.universityset.R;

import java.util.UUID;

public class EventActivity extends AppCompatActivity {

    public static final String EXTRA_EVENT_ID = "com.example.pokestar.universityset.event_id";

    Event mEvent;

    NetImageView mNetImageView;
    TextView Title;
    TextView Content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //UUID eventId = (UUID)getIntent().getSerializableExtra(EXTRA_EVENT_ID);
        //mEvent = EventLab.get(this).getEvent(eventId);

        initView();

    }

    private void initView() {
        mNetImageView = findViewById(R.id.event_activity_image);
        Title = findViewById(R.id.event_activity_title);
        Content = findViewById(R.id.event_activity_content);

        mNetImageView.setImageURL(getIntent().getStringExtra("IMAGEURL"));
        Title.setText(getIntent().getStringExtra("TITLE"));
        Content.setText(getIntent().getStringExtra("DEPICT"));



    }

    public static Intent newIntent(Context packageContext, UUID eventId){
        Intent intent = new Intent(packageContext,EventActivity.class);
        intent.putExtra(EXTRA_EVENT_ID,eventId);
        return intent;
    }

    public static Intent newIntentOne(Context packageContext, String title,String depict,String imageUrl){
        Intent intent = new Intent(packageContext,EventActivity.class);
        intent.putExtra("TITLE",title);
        intent.putExtra("DEPICT",depict);
        intent.putExtra("IMAGEURL",imageUrl);
        return intent;
    }

}
