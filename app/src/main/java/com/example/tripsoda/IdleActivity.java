package com.example.tripsoda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IdleActivity extends AppCompatActivity {

    Button login_code_btn;
    Button login_ID_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idle);

        login_code_btn = findViewById(R.id.login_code_btn);

        login_code_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginCodeActivity.class);
                startActivity(intent);
            }
        });

        login_ID_btn = findViewById(R.id.login_Email_btn);

        login_ID_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), LoginEmailActivity.class);
                startActivity(intent);
            }
        });
    }
}
