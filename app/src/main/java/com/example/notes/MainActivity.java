package com.example.notes;

import android.os.Bundle;

import com.example.notes.adapters.NotesAdapter;
import com.example.notes.adapters.horizontalAdapter;
import com.example.notes.classes.Note;
import com.example.notes.classes.NoteBook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //book tools
    private RecyclerView bookRecyclerView;
    horizontalAdapter bookAdapter;
    private RecyclerView.LayoutManager bookLayoutManager;
    ArrayList<NoteBook> books;
    //note tools
    private RecyclerView noteRecyclerView;
    NotesAdapter noteAdapter;
    private RecyclerView.LayoutManager noteLayoutManager;
    ArrayList<Note> notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Books data
        books=new ArrayList<NoteBook>();
        books.add(new NoteBook(1,"ToDo List",R.drawable.book1));
        books.add(new NoteBook(1,"My Notes",R.drawable.book2));
        books.add(new NoteBook(1,"Summer Plans",R.drawable.book3));
        books.add(new NoteBook(1,"Stories",R.drawable.book4));
        books.add(new NoteBook(1,"Some Notes",R.drawable.book5));
        books.add(new NoteBook(1,"Pharmacy",R.drawable.book6));
        books.add(new NoteBook(1,"Shopping",R.drawable.book7));
        //recycler of notebooks
        bookRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_notebooks);
        bookRecyclerView.setHasFixedSize(true);
        bookLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        bookRecyclerView.setLayoutManager(bookLayoutManager);
        bookAdapter = new horizontalAdapter(books);
        bookRecyclerView.setAdapter(bookAdapter);
       //notes data
        notes=new ArrayList<Note>();
        notes.add(new Note(1,"market","don't forget to bring so potatos and we need 2 kilos of tomato with a carton of milk","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        notes.add(new Note(1,"market","don't forget to bring so potatos","12/16/19"));
        //recycler of notes
        noteRecyclerView = (RecyclerView) findViewById(R.id.note_recycler_view);
        noteRecyclerView.setHasFixedSize(true);
        noteLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        noteRecyclerView.setLayoutManager(noteLayoutManager);
        noteAdapter = new NotesAdapter(notes);
        noteRecyclerView.setAdapter(noteAdapter);

        // fab
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
