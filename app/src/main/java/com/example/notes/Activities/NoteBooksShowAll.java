package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notes.R;
import com.example.notes.adapters.AllNotebooksAdapter;
import com.example.notes.classes.Note;
import com.example.notes.classes.NoteBook;

import java.util.ArrayList;

public class NoteBooksShowAll extends AppCompatActivity {
    //book tools
    private RecyclerView bookRecyclerView;
    AllNotebooksAdapter bookAdapter;
    private RecyclerView.LayoutManager bookLayoutManager;
    ArrayList<NoteBook> books=HomeActivity.books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_books_show_all);
        //Books data
        //recycler of notebooks
        bookRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_all_notebooks);
        bookLayoutManager = new GridLayoutManager(this,3,RecyclerView.VERTICAL, false);
        bookRecyclerView.setLayoutManager(bookLayoutManager);
        bookAdapter = new AllNotebooksAdapter(HomeActivity.books);
        bookRecyclerView.setAdapter(bookAdapter);
        //onCLick
        bookAdapter.setOnItemClickListener(new AllNotebooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(NoteBooksShowAll.this,NotesShowAll.class);
                HomeActivity.currentNotebookId=books.get(position).id;
                startActivity(intent);
            }
        });
        //search filter
        EditText searchEditText=findViewById(R.id.search_edit_text);
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

    private void filter(String text) {
        ArrayList<NoteBook> filteredList = new ArrayList<>();

        for (NoteBook item : HomeActivity.books) {
            if (item.name.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        bookAdapter.filterList(filteredList);
    }
    public void OnClickBackFromNotebooksToHome(View view) {
        finish();
    }

    public void onFabClicked_showAllNoteBooks(View view) {
        Intent intent=new Intent(this,AddNewCategoryActivity.class);
        startActivity(intent);
    }
}
