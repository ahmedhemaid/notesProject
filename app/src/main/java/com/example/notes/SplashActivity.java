package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void singup(View view) {
        Intent singup = new Intent(this,SingupActivity.class);
        startActivity(singup);
    }

    public void singin(View view) {

        Intent singin = new Intent(this,SinginActicity.class);
        startActivity(singin); }
}
