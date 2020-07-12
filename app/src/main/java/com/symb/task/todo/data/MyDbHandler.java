package com.symb.task.todo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.symb.task.todo.model.Record;
import com.symb.task.todo.params.Params;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MyDbHandler extends SQLiteOpenHelper
{
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + Params.TABLE_NAME + "(" + Params.ID + " NUMBER PRIMARY KEY," + Params.MESSAGE +
                  " TEXT," + Params.INSERTED_DATE + " TEXT" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + Params.TABLE_NAME);

        onCreate(db);
    }

    public void insertRecord(Record record)
    {
        SQLiteDatabase db = getWritableDatabase();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String currentDate = sdf.format(new Date());
        ContentValues values = new ContentValues();

        values.put(Params.MESSAGE,record.getMessage());
        values.put(Params.INSERTED_DATE,currentDate);

        db.insert(Params.TABLE_NAME,null,values);
    }

    public ArrayList<Record> getAllRecord()
    {
        SQLiteDatabase db=getReadableDatabase();

        ArrayList<Record> list = new ArrayList<Record>();

        String query="SELECT * FROM "+Params.TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do
            {
                Record record = new Record();

                record.setId(cursor.getInt(0));
                record.setMessage(cursor.getString(1));
                record.setDate(cursor.getString(2));

                // ADD record to list

                list.add(record);
            }
            while (cursor.moveToNext());
        }

        return list;
    }

}
