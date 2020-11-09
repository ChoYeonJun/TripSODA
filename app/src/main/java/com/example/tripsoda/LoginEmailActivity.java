package com.example.tripsoda;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginEmailActivity extends AppCompatActivity {

    //region Button
    Button contact_call_btn;
    Button contact_email_btn;

    ImageButton back_btn;
    ImageButton login_btn;

    EditText email_editText;
    EditText password_editText;

    FirebaseAuth firebaseAuth;

    String TAG = "login";
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        contact_call_btn = findViewById(R.id.contact_call_btn);
        contact_email_btn = findViewById(R.id.contact_email_btn);

        back_btn = findViewById(R.id.back_btn);
        login_btn = findViewById(R.id.login_btn);

        email_editText = findViewById(R.id.email_editText);
        password_editText = findViewById(R.id.password_editText);

        contact_call_btn.setOnClickListener(onClickListener);
        contact_email_btn.setOnClickListener(onClickListener);

        back_btn.setOnClickListener(onClickListener);
        login_btn.setOnClickListener(onClickListener);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {

            switch (v.getId()) {
                case R.id.contact_call_btn:
                    //DO something
                    break;
                case R.id.contact_email_btn:
                    //DO something
                    break;

                case R.id.back_btn:
                    Intent intent = new Intent(getApplicationContext(), IdleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.login_btn:
                    String email = email_editText.getText().toString();
                    String password = password_editText.getText().toString();
                    firebaseAuth =  FirebaseAuth.getInstance();
                    if(email == null || password == null || TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)) {
                        Intent loginIntent = new Intent(getApplicationContext(), FailedActivity.class);
                        startActivity(loginIntent);
                    }
                    else{
                        firebaseAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d(TAG, "signInWithEmail:success");

                                            Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(loginIntent);
//                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Intent loginIntent = new Intent(getApplicationContext(), FailedActivity.class);
                                            startActivity(loginIntent);
                                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        }
                                    }
                                });
                    }
                    break;

            }
        }
    };

}
