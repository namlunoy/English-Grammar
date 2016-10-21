package controllers;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by hoangvancong on 10/16/16.
 */

public class DBHelper {

    public static String getDBDir(Context context)
    {
        return context.getDatabasePath(ConfigCTL.FILE_NAME).getAbsolutePath();
    }


    public static String getDBPath(Context context)
    {
        return context.getDatabasePath(ConfigCTL.FILE_NAME).getParent();
    }

    public static boolean isDbExist(Context context){
        // +"/files/"+ConfigCTL.FILE_NAME;
        File dbFile = new File(getDBPath(context));

        if(dbFile.exists()){
            Log.d("XXX","Exist!");
            return true;
        }else{
            Log.d("XXX","Not Exist!");
            return false;
        }
    }

    public static boolean copyDatabase(Context context){

        try {
            InputStream inputStream = context.getAssets().open(ConfigCTL.FILE_NAME);
            File dbFile = context.getDatabasePath(ConfigCTL.FILE_NAME);
            dbFile.getParentFile().mkdir();
            dbFile.createNewFile();
            OutputStream fileOutput = new FileOutputStream(dbFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                fileOutput.write(buffer,0,length);
            }

            inputStream.close();
            fileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
