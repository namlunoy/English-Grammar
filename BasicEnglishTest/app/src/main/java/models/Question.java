package models;

import java.util.ArrayList;

/**
 * Created by hoangvancong on 10/15/16.
 */

public class Question {
    private String id;
    private String text;
    private String explan;
    private ArrayList<Answer> answers;

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExplan() {
        return explan;
    }

    public void setExplan(String explan) {
        this.explan = explan;
    }
}
