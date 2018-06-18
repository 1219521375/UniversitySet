package com.example.pokestar.universityset.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.example.pokestar.universityset.Base.DataBase.EventBaseHelper;
import com.example.pokestar.universityset.Base.DataBase.EventCursorWrapper;
import com.example.pokestar.universityset.Base.DataBase.EventDbSchema.EventTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static com.example.pokestar.universityset.Base.DataBase.EventDbSchema.EventTable.*;
import static com.example.pokestar.universityset.Base.DataBase.EventDbSchema.EventTable.Eols.*;


/**
 * Created by PokeStar on 2018/6/7.
 */

public class EventLab {

    private static EventLab sEventLab;

    private Context mContext;

    private SQLiteDatabase mDatabase;

    public static EventLab get(Context context) {
        if(sEventLab == null){
            sEventLab = new EventLab(context);
        }
        return sEventLab;
    }

    public EventLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new EventBaseHelper(mContext)
                .getWritableDatabase();

    }



    public void addEvent(Event c) {
        ContentValues values = getContentValues(c);
        mDatabase.insert(EventTable.NAME, null, values);
    }

    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        EventCursorWrapper cursor = queryCrimes(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                events.add(cursor.getEvent());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return events;
    }

    public Event getEvent(UUID id) {
        EventCursorWrapper cursor = queryCrimes(
                EventTable.Eols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getEvent();
        } finally {
            cursor.close();
        }
    }

 /*   public File getPhotoFile(Event event) {
        File filesDir = mContext.getFilesDir();
        return new File(filesDir, event.getPhotoFilename());
    }*/

    public void updateEvent(Event event) {
        String uuidString = event.getId().toString();
        ContentValues values = getContentValues(event);
        mDatabase.update(EventTable.NAME, values,
                EventTable.Eols.UUID + " = ?",
                new String[]{uuidString});
    }

    private EventCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                EventTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );
        return new EventCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Event event) {
        ContentValues values = new ContentValues();
        values.put(UUID, event.getId().toString());
        values.put(TITLE, event.getTitle());
        values.put(DEPICT, event.getDepict());
        values.put(IMAGEURL, event.getImageUrl());

        return values;
    }

}
