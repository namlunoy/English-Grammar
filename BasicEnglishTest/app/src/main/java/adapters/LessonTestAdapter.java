package adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

import models.Question;

/**
 * Created by hoangvancong on 10/19/16.
 */

public class LessonTestAdapter extends FragmentPagerAdapter {
    private ArrayList<Question> questions;
    private ArrayList<QuestionFragment> fragments;

    public LessonTestAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setQuestions(ArrayList<Question> questions)
    {
        this.questions = questions;
        fragments = new ArrayList<>();

        for (Question q: questions) {
            QuestionFragment f = new QuestionFragment(q);
            fragments.add(f);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
