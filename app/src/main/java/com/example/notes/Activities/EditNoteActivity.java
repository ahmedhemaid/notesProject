package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notes.R;
import com.example.notes.classes.Note;
import com.example.notes.classes.NoteBook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditNoteActivity extends AppCompatActivity {
    EditText nName,nContext;
    TextView nDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        String dateText= Note.longToDate(getIntent().getLongExtra("note date",0));
        nName=findViewById(R.id.nTitle_edit_note);
        nContext=findViewById(R.id.nContext_edit_note);
        nDate=findViewById(R.id.nDate_edit_note);
        nName.setText(getIntent().getStringExtra("note name"));
        nContext.setText(getIntent().getStringExtra("note context"));
        nDate.setText(dateText);
    }
    public void OnClickBackFromEditNote(View view) {
        finish();
    }

    public void OnClickSave(View view) {
        Note note=new Note(HomeActivity.currentNotebookId,HomeActivity.notes.get(getIntent().getIntExtra("note position",0)).idOfNote,nName.getText().toString(),nContext.getText().toString(),new Date().getTime());
        HomeActivity.writeNote(note);
        finish();
    }
}
