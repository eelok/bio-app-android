package com.eelok.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.eelok.bio.data.Bio;
import com.eelok.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Eelok Eelok");
        binding.setBio(bio);
        binding.doneButton.setOnClickListener(view -> handleDoneBtn(view));
    }


    public void handleDoneBtn(View view) {
        bio.setHobbies(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));

        binding.invalidateAll();
        binding.hobbiesOutput.setVisibility(View.VISIBLE);


        //hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}