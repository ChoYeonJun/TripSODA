package com.example.tripsoda;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment scheduleFragment;
    Fragment mapFragment;
    Fragment messageFragment;
    Fragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.main_actionbar_layout);

        final Drawable upArrow = getResources().getDrawable(R.drawable.backbutton);
        Bitmap bitmap = ((BitmapDrawable) upArrow).getBitmap();
// Scale it to 50 x 50
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 30, 30, true));
        upArrow.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(d);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        homeFragment = new Fragment();
        scheduleFragment = new Fragment();
        mapFragment = new Fragment();
        messageFragment = new Fragment();
        settingFragment = new Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.home_tab:
                                Toast.makeText(getApplicationContext(), "첫 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

                                return true;
                            case R.id.schedule_tab:
                                Toast.makeText(getApplicationContext(), "두 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment).commit();

                                return true;
                            case R.id.map_tab:
                                Toast.makeText(getApplicationContext(), "세 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();

                                return true;
                            case R.id.message_tab:
                                Toast.makeText(getApplicationContext(), "네 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, messageFragment).commit();

                                return true;
                            case R.id.setting_tab:
                                Toast.makeText(getApplicationContext(), "다섯 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).commit();

                                return true;

                        }
                        return false;
                    }
                }
        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.sort_onTime:
                Toast.makeText(this, "첫번째", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sort_onDate:
                Toast.makeText(this, "두번째", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
