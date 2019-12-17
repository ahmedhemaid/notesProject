package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.notes.R;

public class NoteTutorial2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_tutorial2);

    }

    public void OnClickNextInSecendPage(View view) {
        Intent intent=new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
}
