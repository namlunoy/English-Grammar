package controllers;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hoangvancong on 10/15/16.
 */

public class DatabaseCTL extends SQLiteOpenHelper {

    public DatabaseCTL(Context context)
    {
        super(context, ConfigCTL.FILE_NAME , null, 1);
    }

    public void F(){
        SQLiteDatabase db  = this.getReadableDatabase();
        int num = (int)DatabaseUtils.queryNumEntries(db,"Lesson");
        Log.d("XXX","num = "+num);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
