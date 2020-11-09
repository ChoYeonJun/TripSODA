package com.example.tripsoda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class LoginCodeActivity extends AppCompatActivity {

    //region Button
    Button contact_call_btn;
    Button contact_email_btn;

    ImageButton back_btn;
    ImageButton check_btn;

    //numpad
    Button numpad_one_btn;
    Button numpad_two_btn;
    Button numpad_three_btn;
    Button numpad_four_btn;
    Button numpad_five_btn;
    Button numpad_six_btn;
    Button numpad_seven_btn;
    Button numpad_eight_btn;
    Button numpad_nine_btn;
    Button numpad_zero_btn;
    ImageButton hidden_btn;
    ImageButton numpad_backspace_btn;
    //endregion

    EditText input_editText;


    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_login_code);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //region ButtonFindView
        contact_call_btn = findViewById(R.id.contact_call_btn);
        contact_email_btn = findViewById(R.id.contact_email_btn);

        back_btn = findViewById(R.id.back_btn);
        check_btn = findViewById(R.id.login_btn);

        numpad_one_btn = findViewById(R.id.numpad_one_btn);
        numpad_two_btn = findViewById(R.id.numpad_two_btn);
        numpad_three_btn = findViewById(R.id.numpad_three_btn);
        numpad_four_btn = findViewById(R.id.numpad_four_btn);
        numpad_five_btn = findViewById(R.id.numpad_five_btn);
        numpad_six_btn = findViewById(R.id.numpad_six_btn);
        numpad_seven_btn = findViewById(R.id.numpad_seven_btn);
        numpad_eight_btn = findViewById(R.id.numpad_eight_btn);
        numpad_nine_btn = findViewById(R.id.numpad_nine_btn);
        numpad_zero_btn = findViewById(R.id.numpad_zero_btn);
        numpad_backspace_btn = findViewById(R.id.numpad_backspace_btn);

        hidden_btn = findViewById(R.id.hidden_btn);


        contact_call_btn.setOnClickListener(onClickListener);
        contact_email_btn.setOnClickListener(onClickListener);

        back_btn.setOnClickListener(onClickListener);
        check_btn.setOnClickListener(onClickListener);

        numpad_one_btn.setOnClickListener(onClickListener);
        numpad_two_btn.setOnClickListener(onClickListener);
        numpad_three_btn.setOnClickListener(onClickListener);
        numpad_four_btn.setOnClickListener(onClickListener);
        numpad_five_btn.setOnClickListener(onClickListener);
        numpad_six_btn.setOnClickListener(onClickListener);
        numpad_seven_btn.setOnClickListener(onClickListener);
        numpad_eight_btn.setOnClickListener(onClickListener);
        numpad_nine_btn.setOnClickListener(onClickListener);
        numpad_zero_btn.setOnClickListener(onClickListener);
        numpad_backspace_btn.setOnClickListener(onClickListener);

        hidden_btn.setOnClickListener(onClickListener);


        //endregion
        input_editText = findViewById(R.id.email_editText);


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
    private boolean ValidateInputEditText(){
        if(input_editText.getText().toString().equals("구매코드 입력")){
            return false;
        }else{
            return true;
        }
    }

    private boolean ValidateAdminCode(){
        if(input_editText.getText().toString().equals("1219")){
            return true;
        }else
            return false;
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {

            switch(v.getId()){
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
                    //DO something
                    break;
                //region numpad
                case R.id.numpad_one_btn:
                    //DO something
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("1");
                    break;
                case R.id.numpad_two_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("2");
                    break;
                case R.id.numpad_three_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("3");
                    break;
                case R.id.numpad_four_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("4");
                    break;
                case R.id.numpad_five_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("5");
                    break;
                case R.id.numpad_six_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("6");
                    break;
                case R.id.numpad_seven_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("7");
                    break;
                case R.id.numpad_eight_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("8");
                    break;
                case R.id.numpad_nine_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("9");
                    break;
                case R.id.numpad_zero_btn:
                    if(!ValidateInputEditText()){
                        input_editText.setText("");
                    }
                    input_editText.append("0");
                    break;
                case R.id.numpad_backspace_btn:
                    int length = input_editText.getText().length();
                    input_editText.getText().delete(length - 1, length);
                    break;

                case R.id.hidden_btn:
                    if(ValidateAdminCode()){
                        Intent adminIntent = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(adminIntent);
                        Toast.makeText(getApplicationContext(), "hidden btn",
                                Toast.LENGTH_SHORT).show();
                    }
                    break;
                //endregion
            }

        }
    };

}
