package com.example.notes.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.notes.R;
import com.example.notes.adapters.AllCategoryAdapter;
import com.example.notes.adapters.AllNotebooksAdapter;
import com.example.notes.adapters.NotesAdapter;
import com.example.notes.adapters.horizontalAdapter;
import com.example.notes.classes.Note;
import com.example.notes.classes.NoteBook;
import com.example.notes.classes.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    public static String currentNotebookId="non";
    private static DatabaseReference mDatabase;
    public static Integer currentCateId=0;
    public static ValueEventListener valueEventListener;
    //book tools
    private RecyclerView bookRecyclerView;
    static horizontalAdapter bookAdapter;
    private RecyclerView.LayoutManager bookLayoutManager;
    static ArrayList<NoteBook> books=new ArrayList<>();
    //note tools
    private RecyclerView noteRecyclerView;
    static NotesAdapter noteAdapter;
    private RecyclerView.LayoutManager noteLayoutManager;
    static ArrayList<Note> notes=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Initialize Realtime Reference.
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //sharedPreferences
        SharedPreferences preferences=getSharedPreferences("Prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("is_logged_in",true);
        editor.apply();
        //recycler of notebooks
        bookRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_notebooks);
        bookRecyclerView.setHasFixedSize(true);
        bookLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        bookRecyclerView.setLayoutManager(bookLayoutManager);
        bookAdapter = new horizontalAdapter(books);
        bookRecyclerView.setAdapter(bookAdapter);
        //notebooks data
        initNotebookData();
        //recycler of notes
        noteRecyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);
        noteRecyclerView.setHasFixedSize(true);
        noteLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        noteRecyclerView.setLayoutManager(noteLayoutManager);
        noteAdapter = new NotesAdapter(notes);
        noteRecyclerView.setAdapter(noteAdapter);
        //notes data
        initNoteData();
        //onBookCLick
        bookAdapter.setOnItemClickListener(new AllNotebooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String name=books.get(position).name;
                String id=books.get(position).id;
                currentNotebookId=id;
                initNoteData();
                getIntent().putExtra("category id",id);
            }
        });
    }
    //get notebooks from the fireBase database
    public static void initNotebookData() {
        FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getUid()).child("NoteBook")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        books.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                            NoteBook notebook = snapshot.getValue(NoteBook.class);
                            books.add(notebook);
                        }
                        bookAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
    }

    //get notes from the fireBase database
    public static void initNoteData() {
        FirebaseDatabase.getInstance().getReference().child("User").child(FirebaseAuth.getInstance().getUid()).child("Note")
                .addValueEventListener(valueEventListener=new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        notes.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                            Note note = snapshot.getValue(Note.class);
                            if (note.categoryId.equals(currentNotebookId)) {
                                notes.add(note);
                            }
                            else if (currentNotebookId.equals("non")) {
                                notes.add(note);
                            }
                        }
                        noteAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
    }
    //add notebook in firebase database
    public static void writeNotebook(NoteBook noteBook) {
        Log.d("FIREBASE", "Writing notebook");
        String userId =FirebaseAuth.getInstance().getUid();
        mDatabase.child("User").child(userId).child("NoteBook").child(noteBook.id).setValue(noteBook);
    }
    //add note in firebase database
    public static void writeNote(Note note) {
        Log.d("FIREBASE", "Writing notebook");
        String userId =FirebaseAuth.getInstance().getUid();
        mDatabase.child("User").child(userId).child("Note").child(note.idOfNote).setValue(note);
    }
    //go to all notebooks activity
    public void OnClickShowAllNotebooks(View view) {
        Intent intent=new Intent(this,NoteBooksShowAll.class);
        startActivity(intent);
    }
    //go to all notes activity
    public void OnClickShowAllNotes(View view) {
        Intent intent=new Intent(this,NotesShowAll.class);
        startActivity(intent);
    }
    //logout
    public void onClickLogOut(View view) {
        SharedPreferences preferences=getSharedPreferences("Prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("is_logged_in",false);
        editor.apply();
        FirebaseAuth.getInstance().signOut();
        Intent intent=new Intent(this,SplashActivity.class);
        startActivity(intent);
        finish();
    }
    //create notebook
    public void OnClickCreateNewNoteBook(View view) {
        Intent intent=new Intent(this, AddNewCategoryActivity.class);
        startActivity(intent);
    }

}
