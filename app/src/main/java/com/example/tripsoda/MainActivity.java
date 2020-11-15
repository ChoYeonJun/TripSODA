package com.example.tripsoda;

import android.content.res.ColorStateList;
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
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment scheduleFragment;
    Fragment mapFragment;
    Fragment messageFragment;
    Fragment settingFragment;
    BottomNavigationView bottomNavigationView;

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

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        initMenuTitle();
//        bottomNavigationView.set
//        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(Color.parseColor("#13AA1A")));
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.home_tab:
                                setBottomMenuAllTitle();
                                setBottomMenuNontitle(R.id.home_tab);
//                                Toast.makeText(getApplicationContext(), "첫 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

                                return true;
                            case R.id.schedule_tab:
                                setBottomMenuAllTitle();
                                setBottomMenuNontitle(R.id.schedule_tab);
//                                Toast.makeText(getApplicationContext(), "두 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment).commit();

                                return true;
                            case R.id.map_tab:
                                setBottomMenuAllTitle();
                                setBottomMenuNontitle(R.id.map_tab);
//                                Toast.makeText(getApplicationContext(), "세 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();

                                return true;
                            case R.id.message_tab:
                                setBottomMenuAllTitle();
                                setBottomMenuNontitle(R.id.message_tab);
//                                Toast.makeText(getApplicationContext(), "네 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, messageFragment).commit();

                                return true;
                            case R.id.setting_tab:
                                setBottomMenuAllTitle();
                                setBottomMenuNontitle(R.id.setting_tab);
//                                Toast.makeText(getApplicationContext(), "다섯 번째 탭 선택 됨", Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container, settingFragment).commit();

                                return true;

                        }
                        return false;
                    }
                }
        );


    }

    public void setBottomMenuAllTitle(){
        bottomNavigationView.getMenu().findItem(R.id.home_tab).setTitle("home");
        bottomNavigationView.getMenu().findItem(R.id.schedule_tab).setTitle("schedule");
        bottomNavigationView.getMenu().findItem(R.id.map_tab).setTitle("map");
        bottomNavigationView.getMenu().findItem(R.id.message_tab).setTitle("message");
        bottomNavigationView.getMenu().findItem(R.id.setting_tab).setTitle("setting");
    }
    public void setBottomMenuNontitle(int res){
        bottomNavigationView.getMenu().findItem(res).setTitle("");
    }
    public void initMenuTitle(){
        bottomNavigationView.getMenu().findItem(R.id.home_tab).setTitle("");
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
