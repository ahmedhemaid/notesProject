package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.notes.R;

public class AddNewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);
    }

    public void showAll(View view) {
        Intent intent=new Intent(this,NotesShowAll.class);
        startActivity(intent);
    }

    public void OnClickAdd(View view) {
        Intent intent=new Intent(this,NotesShowAll.class);
        startActivity(intent);
        Toast.makeText(this, "new note added", Toast.LENGTH_SHORT).show();
    }

    public void backFromAddNewActivity(View view) {
        Intent intent=new Intent(this, this.getParent().getClass());
        startActivity(intent);
    }
}
