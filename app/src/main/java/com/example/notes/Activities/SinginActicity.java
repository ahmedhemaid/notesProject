package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes.R;

public class SinginActicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
    }
    public void home(View view) {
        Intent home = new Intent(this, homeee.class);
        startActivity(home);
    }
    public void singup(View view) {

        Intent singup = new Intent(this, SingupActivity.class);
        startActivity(singup);
    }
    public void forget(View view) {

        Intent forget = new Intent(this, ForgetPassActivity.class);
        startActivity(forget);
    }

}

