package com.thebrownbox.basicenglishtest;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import adapters.LessonTestAdapter;
import controllers.ConfigCTL;
import controllers.DatabaseCTL;
import models.Question;

public class KiemTraActivity extends ActionBarActivity {

    private ArrayList<Question> questions;
    private ViewPager viewPager;
    private LessonTestAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiem_tra);
        setTitle("Test: "+ ConfigCTL.selectedLesson.getTitle());
        showAds();
        questions = DatabaseCTL.Instance().getAllQuestions(ConfigCTL.selectedLesson.getId());

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        pagerAdapter = new LessonTestAdapter(getSupportFragmentManager());
        pagerAdapter.setQuestions(questions);
        viewPager.setAdapter(pagerAdapter);

    }

    private void showAds() {
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView_kt);

        if(MainActivity.hasNetwork){
            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();
            adView.loadAd(adRequest);
        }else{
            adView.setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kiem_tra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
