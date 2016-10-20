package controllers;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.ArrayList;
import java.util.List;

import models.Lesson;
import utilities.SelectionType;

/**
 * Created by hoangvancong on 10/15/16.
 */

public class ConfigCTL {
    public static SelectionType selectedChoice;
    public static final String FILE_NAME = "data.db";
    public static ArrayList<Lesson> listLesson  = null;
    public static Lesson selectedLesson;

    public static boolean IsHasInternet(Context context)
    {
        ConnectivityManager mng = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        return mng.getActiveNetworkInfo() != null && mng.getActiveNetworkInfo().isConnected();
    }
}
