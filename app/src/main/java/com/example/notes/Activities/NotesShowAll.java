package com.example.notes.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.adapters.AllNotebooksAdapter;
import com.example.notes.adapters.AllNotesAdapter;
import com.example.notes.classes.Note;
import java.util.ArrayList;

public class NotesShowAll extends AppCompatActivity {
    //note tools
    private RecyclerView noteRecyclerView;
    AllNotesAdapter notesAdapter;
    private RecyclerView.LayoutManager noteLayoutManager;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_show_all);
        //notes data
        notes = HomeActivity.notes;
        HomeActivity.initNoteData();
        //recycler of notes
        noteRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_all_notes);
        noteLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        noteRecyclerView.setLayoutManager(noteLayoutManager);
        notesAdapter = new AllNotesAdapter(notes);
        noteRecyclerView.setAdapter(notesAdapter);
        //onCLick
        notesAdapter.setOnItemClickListener(new AllNotebooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String name = notes.get(position).contextOfNote;
                Intent intent = new Intent(NotesShowAll.this, EditNoteActivity.class);
                intent.putExtra("note name", notes.get(position).titleOfNote);
                intent.putExtra("note context", notes.get(position).contextOfNote);
                intent.putExtra("note date", notes.get(position).dateOfNote);
                intent.putExtra("note position", position);
                startActivity(intent);
            }
        });
//search filter
        EditText searchEditText = findViewById(R.id.search_edit_text_notes);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    //search filter
    private void filter(String text) {
        ArrayList<Note> filteredList = new ArrayList<>();

        for (Note item : notes) {
            if (item.titleOfNote.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        notesAdapter.filterList(filteredList);
    }

    //back button
    public void OnClickBackFromNotebooksToHome(View view) {
        finish();

    }

    //add note
    public void onFabClicked_showAllNotes(View view) {
        if (HomeActivity.currentNotebookId != "non") {
            Intent intent = new Intent(this, AddNewNoteActivity.class);
            startActivity(intent);
        }
        else {

            new AlertDialog.Builder(this).setIcon(null).setTitle("Can't add note").setMessage("Please go back to the home window and select the category to add its note").setPositiveButton("Go to Home", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which){
                    Intent intent=new Intent(NotesShowAll.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }}).show();

        }
    }
}
