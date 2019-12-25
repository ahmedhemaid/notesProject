package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.R;
import com.example.notes.classes.Note;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class AddNewNoteActivity extends AppCompatActivity {
    EditText title,context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);
        title=(findViewById(R.id.edit_text_note_name));
        context=findViewById(R.id.edit_text_note_description);
    }

    public void showAll(View view) {
        Intent intent=new Intent(this,NotesShowAll.class);
        startActivity(intent);
    }

    public void OnClickAdd(View view) {
        Intent intent=new Intent();
        Note note=new Note(HomeActivity.currentNotebookId,Note.generateNoteID(),title.getText().toString(),context.getText().toString(),new Date().getTime());
        HomeActivity.writeNote(note);
        Toast.makeText(this,"Note is added successfully" , Toast.LENGTH_SHORT).show();
        finish();
    }

    public void backFromAddNewActivity(View view) {
        finish();
    }
}
