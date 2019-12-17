package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes.R;

public class SingupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
    }
    public void home(View view) {
        Intent home = new Intent(this, NoteTutorial1.class);
        startActivity(home);
    }

    public void singin(View view) {

        Intent singin = new Intent(this, SinginActicity.class);
        startActivity(singin);
    }
}
