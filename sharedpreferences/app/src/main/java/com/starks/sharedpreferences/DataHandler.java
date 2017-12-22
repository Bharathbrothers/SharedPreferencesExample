package com.starks.sharedpreferences;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.starks.sharedpreferences.data.dataContract;


public class DataHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "CollegesPredictor";

    private static final String TABLE_COLLEGE = "Colleges";
    private static final String KEY_CCODE = "ccode";
    private static final String KEY_CNAME = "cname";
    private static final String KEY_RANK = "rank";

    public DataHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_COLLEGE_TABLE = "CREATE TABLE " + TABLE_COLLEGE + "("
                + KEY_CCODE + " INTEGER PRIMARY KEY," + KEY_CNAME + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_COLLEGE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COLLEGE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    dataContract getdata(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_COLLEGE, new String[] { KEY_CCODE,
                        KEY_CNAME,  }, KEY_RANK + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        dataContract data = new dataContract(Integer.parseInt(cursor.getString(0)));

        return data;
    }
}
