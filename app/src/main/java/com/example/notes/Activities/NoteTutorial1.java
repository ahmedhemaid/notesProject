package com.example.notes.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notes.R;
import com.google.firebase.database.FirebaseDatabase;

public class NoteTutorial1 extends AppCompatActivity {
Button btn_next;
     SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        setContentView(R.layout.activity_note_tutorial1);
        preferences = getSharedPreferences("Prefs", MODE_PRIVATE);
        if (!preferences.getBoolean("is_first_time", true)) {

            // Go to splash activity (user logged in)
            Intent intent = new Intent(this, SplashActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        btn_next = findViewById(R.id.btn_next);

    }

    public void OnClickNextInFirstPage(View view) {
        editor = preferences.edit();
        editor.putBoolean("is_first_time", false);
        editor.apply();
        Intent intent=new Intent(this,NoteTutorial2.class);
        startActivity(intent);
    }

    public void onClickSkip1(View view) {
        editor = preferences.edit();
        editor.putBoolean("is_first_time", false);
        Toast.makeText(this, preferences.getBoolean("is_first_time",true)+"", Toast.LENGTH_SHORT).show();
        editor.apply();
        Intent intent=new Intent(this,SplashActivity.class);
        startActivity(intent);
    }
}
