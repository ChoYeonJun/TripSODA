package com.example.tripsoda;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    EditText email_editText;
    EditText password_editText;
    EditText passwordCheck_editText;

    Button register_btn;
    FirebaseAuth firebaseAuth;
    DatabaseReference reference;
    String TAG = "Email Sent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        email_editText = findViewById(R.id.email_editText);
        password_editText = findViewById(R.id.password_editText);
        passwordCheck_editText = findViewById(R.id.passwordCheck_editText);

        register_btn = findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //파이어베이스 접근 설정
                // user = firebaseAuth.getCurrentUser();
                firebaseAuth =  FirebaseAuth.getInstance();
                //firebaseDatabase = FirebaseDatabase.getInstance().getReference();
                if(email_editText.getText() != null && password_editText.getText()!= null && passwordCheck_editText.getText() != null) {
                    String email = email_editText.getText().toString().trim();
                    String pwd = password_editText.getText().toString().trim();
                    String pwdCheck = passwordCheck_editText.getText().toString().trim();
                    if (pwd.equals(pwdCheck)) {

                        Log.d(TAG, "등록 버튼 " + email + " , " + pwd);
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pwd)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "Email sent");
                                            FirebaseUser user = firebaseAuth.getCurrentUser();

                                            HashMap<String, String> hashMap = new HashMap<>();
                                            hashMap.put("장소", "영월");
                                            hashMap.put("시간", "7월9일 오전9시 출발");
                                            hashMap.put("순서", "1");
                                            hashMap.put("소요 시간", "5");



                                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                        startActivity(intent);
                                                        finish();
                                                    }else{
                                                        Toast.makeText(getApplicationContext(), "reference error ", Toast.LENGTH_SHORT).show();
                                                        Log.d("reference exception", "onComplete: Failed=" + task.getException().getMessage());
                                                    }
                                                }
                                            });
                                            Toast.makeText(getApplicationContext(), "Registration Success",
                                                    Toast.LENGTH_SHORT).show();


                                        } else {
                                            Log.e(TAG, "Error signing in with email link", task.getException());
                                            Toast.makeText(getApplicationContext(), "Registration Failed",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            }
        });

    }


}
