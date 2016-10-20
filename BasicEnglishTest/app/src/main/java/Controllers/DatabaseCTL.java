package controllers;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import models.Answer;
import models.Lesson;
import models.Question;

/**
 * Created by hoangvancong on 10/15/16.
 */

public class DatabaseCTL extends SQLiteOpenHelper {
    public final String TABLE_LESSON = "Lesson";
    public final String TABLE_QUESTION = "Question";
    public final String TABLE_ANSWER = "Answer";

    private static DatabaseCTL _instance = null;

    public static void create(Context context)
    {
        if(_instance == null)
            _instance = new DatabaseCTL(context);
    }

    public static DatabaseCTL Instance(){
        return _instance;
    }

    public DatabaseCTL(Context context)
    {
        super(context, ConfigCTL.FILE_NAME , null, 1);
    }

    public ArrayList<Lesson> getAllLessons(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Lesson> lessons = new ArrayList<>();
        String[] columns = new String[]{"id","text","total","number"};
        Cursor c = db.query(TABLE_LESSON,columns,null,null,null,null,null);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Lesson lesson = new Lesson();
            lesson.setId(c.getInt(c.getColumnIndex("id")));
            lesson.setTitle(c.getString(c.getColumnIndex("text")));
            lesson.setTotal(c.getInt(c.getColumnIndex("total")));
            lesson.setScore(c.getInt(c.getColumnIndex("number")));
            //lesson.setContentHtml(c.getString(c.getColumnIndex("content")));
            lessons.add(lesson);
        }

        return lessons;
    }

    public String getContentLesson(int id){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{"content"};
        Cursor c = db.query(TABLE_LESSON,columns,null,null,null,null,null);
        c.moveToFirst();
        if(!c.isAfterLast())
        {
            byte[] data = c.getBlob(c.getColumnIndex("content"));
            return new String(data);
        }
        return null;
    }

    public ArrayList<Question> getAllQuestions(int idLesson)
    {
        ArrayList<Question> questions = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{"id","text","explan","lesson_id"};
        Cursor c = db.query(TABLE_QUESTION,columns,"lesson_id = "+idLesson,null,null,null,null);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            Question q = new Question();
            q.setId(c.getString(c.getColumnIndex("id")));
            q.setExplan(c.getString(c.getColumnIndex("explan")));
            q.setText(c.getString(c.getColumnIndex("text")));
            questions.add(q);
        }

        for (Question q: questions) {
            q.setAnswers(getAllAnswers(q.getId()));
        }

        return questions;
    }

    public ArrayList<Answer> getAllAnswers(String idQuestion)
    {
        ArrayList<Answer> answers = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{"text","hint","is_correct","question_id"};
       Cursor c = db.query(TABLE_ANSWER,columns,"question_id = '"+idQuestion+"'",null,null,null,null);
        //Cursor c = db.rawQuery("select * from Answer where question_id like "+idQuestion,null);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            Answer a = new Answer();
            a.setText(c.getString(c.getColumnIndex("text")));
            a.setHint(c.getString(c.getColumnIndex("hint")).trim());
            a.setQuestionId(c.getString(c.getColumnIndex("question_id")));
            a.setCrrect(c.getInt(c.getColumnIndex("is_correct")) > 0 ? true : false);
            answers.add(a);
        }

        return answers;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
