package com.example.pokestar.universityset.Base.DataBase;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.pokestar.universityset.Data.Event;

import java.util.UUID;
import static com.example.pokestar.universityset.Base.DataBase.EventDbSchema.EventTable.*;


/**
 * Created by PokeStar on 2018/6/14.
 */

public class EventCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public EventCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Event getEvent(){
        String uuidString = getString(getColumnIndex(Eols.UUID));
        String title = getString(getColumnIndex(Eols.TITLE));
        String depict = getString(getColumnIndex(Eols.DEPICT));
        String imageUrl= getString(getColumnIndex(Eols.IMAGEURL));

        Event event = new Event(UUID.fromString(uuidString));
        event.setTitle(title);
        event.setDepict(depict);
        event.setImageUrl(imageUrl);


        return event;
    }

}
