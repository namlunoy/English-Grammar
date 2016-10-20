package com.thebrownbox.basicenglishtest;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import controllers.ConfigCTL;
import controllers.DatabaseCTL;
import models.Lesson;

public class ListLessonActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lesson);
        setTitle("Chủ đề");
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView_lesson);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        listView = (ListView) findViewById(R.id.listViewLesson);
        if(ConfigCTL.listLesson == null)
            ConfigCTL.listLesson = DatabaseCTL.Instance().getAllLessons();

        listView.setAdapter(new ArrayAdapter<Lesson>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1, ConfigCTL.listLesson));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                ConfigCTL.selectedLesson = ConfigCTL.listLesson.get(position);
                switch (ConfigCTL.selectedChoice){
                    case LY_THUYET:
                        intent = new Intent(ListLessonActivity.this,LyThuyetActivity.class);
                        startActivity(intent);
                        break;
                    case  KIEM_TRA:
                        intent = new Intent(ListLessonActivity.this,KiemTraActivity.class);
                        startActivity(intent);
                        break;
                };
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_lesson, menu);
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
