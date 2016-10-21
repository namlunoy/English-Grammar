package com.thebrownbox.basicenglishtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import controllers.ConfigCTL;
import controllers.DatabaseCTL;

public class LyThuyetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly_thuyet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change to Testing
                Intent kiemTra = new Intent(LyThuyetActivity.this, KiemTraActivity.class);
                startActivity(kiemTra);
            }
        });

        AdView adView = (AdView) findViewById(R.id.adView_LT);
        if(MainActivity.hasNetwork) {
            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();
            adView.loadAd(adRequest);
        }else{
            adView.setVisibility(View.GONE);
        }


        View content = findViewById(R.id.content);
        WebView webView = (WebView)content.findViewById(R.id.webView);

        String htmlContent = DatabaseCTL.Instance().getContentLesson(ConfigCTL.selectedLesson.getId());
        webView.loadData(htmlContent, "text/html; charset=utf-8", "UTF-8");
        setTitle(ConfigCTL.selectedLesson.getTitle());
    }

}
