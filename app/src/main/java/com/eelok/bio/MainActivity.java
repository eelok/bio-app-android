package com.eelok.bio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputHobbies;
    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputHobbies = findViewById(R.id.enter_hobbies);
        hobbies = findViewById(R.id.hobbies_output);
    }


    public void handleDoneBtn(View view) {
        hobbies.setText(String.format("Hobbies: %s", inputHobbies.getText()));
        hobbies.setVisibility(View.VISIBLE);

        //hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}