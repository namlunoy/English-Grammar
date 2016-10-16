package thebrownbox.com.basicenglishtest;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import controllers.ConfigCTL;
import controllers.DBHelper;
import controllers.DatabaseCTL;
import utilities.SelectionType;

public class MainActivity extends AppCompatActivity {


    private Button btLyThuyet;
    private Button btKiemTra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLyThuyet = (Button) findViewById(R.id.btLyThuyet);
        btKiemTra = (Button) findViewById(R.id.btKiemTra);

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);



        btKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigCTL.selectedChoice = SelectionType.KIEM_TRA;
                Intent kiemTra = new Intent(MainActivity.this, ListLessonActivity.class);
                startActivity(kiemTra);
            }
        });

        btLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigCTL.selectedChoice = SelectionType.LY_THUYET;
                Intent lyThuyet = new Intent(MainActivity.this, ListLessonActivity.class);
                startActivity(lyThuyet);
            }
        });

        if(!DBHelper.isDbExist(getApplicationContext())){
          DBHelper.copyDatabase(getApplicationContext());
        }

        DatabaseCTL db = new DatabaseCTL(getApplicationContext());
        db.F();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
