package models;

/**
 * Created by hoangvancong on 10/15/16.
 */

public class Answer {
    private String text;
    private boolean isCrrect;
    private String hint;
    private String questionId;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCrrect() {
        return isCrrect;
    }

    public void setCrrect(boolean crrect) {
        isCrrect = crrect;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
