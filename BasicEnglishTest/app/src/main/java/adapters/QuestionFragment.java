package adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thebrownbox.basicenglishtest.R;

import models.Question;

/**
 * Created by hoangvancong on 10/19/16.
 */

public class QuestionFragment extends Fragment {

    private  Question question;

    public QuestionFragment(){}

    @SuppressLint("ValidFragment")
    public QuestionFragment(Question q){
        this.question = q;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.question_pager,container,false);

        TextView txtQuest = (TextView) rootView.findViewById(R.id.item_question_content);

        txtQuest.setText(this.question.getText());

        return rootView;
    }


}
