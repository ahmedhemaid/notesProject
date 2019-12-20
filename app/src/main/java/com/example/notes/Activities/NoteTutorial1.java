package com.example.notes.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notes.R;

public class NoteTutorial1 extends AppCompatActivity {
Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_tutorial1);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), NoteTutorial2.class);
                startActivity(intent);
            }
        });
    }

    public void OnClickNextInFirstPage(View view) {
        Intent intent=new Intent(this,NoteTutorial2.class);
        startActivity(intent);
    }

    public void onClickSkip1(View view) {
        Intent intent=new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
}
