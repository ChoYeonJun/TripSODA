package com.example.tripsoda;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    EditText email_editText;
    EditText password_editText;
    EditText passwordCheck_editText;

    Button register_btn;
    FirebaseAuth firebaseAuth;

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
//                                String email = user.getEmail();
//                                String uid = user.getUid();
//
//                                HashMap<Object, String> hashMap = new HashMap<>();
//
//                                hashMap.put("uid", uid);
//                                hashMap.put("email", email);
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
