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
import com.example.notes.classes.NoteBook;

import java.util.ArrayList;

public class NoteBooksShowAll extends AppCompatActivity {
    //book tools
    private RecyclerView bookRecyclerView;
    AllNotebooksAdapter bookAdapter;
    private RecyclerView.LayoutManager bookLayoutManager;
    ArrayList<NoteBook> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_books_show_all);
        //Books data
        books=new ArrayList<NoteBook>();
        books.add(new NoteBook(1,"ToDo List",R.drawable.book1));
        books.add(new NoteBook(1,"My Notes",R.drawable.book2));
        books.add(new NoteBook(1,"Summer Plans",R.drawable.book3));
        books.add(new NoteBook(1,"Stories",R.drawable.book4));
        books.add(new NoteBook(1,"Some Notes",R.drawable.book5));
        books.add(new NoteBook(1,"Pharmacy",R.drawable.book6));
        books.add(new NoteBook(1,"Shopping",R.drawable.book7));
        books.add(new NoteBook(1,"ToDo List",R.drawable.book8));
        books.add(new NoteBook(1,"My Notes",R.drawable.book9));
        books.add(new NoteBook(1,"Summer Plans",R.drawable.book10));
        books.add(new NoteBook(1,"Stories",R.drawable.book11));
        books.add(new NoteBook(1,"Some Notes",R.drawable.book12));
        books.add(new NoteBook(1,"Pharmacy",R.drawable.book13));
        books.add(new NoteBook(1,"Shopping",R.drawable.book14));
        books.add(new NoteBook(1,"ToDo List",R.drawable.book15));
        books.add(new NoteBook(1,"My Notes",R.drawable.book16));
        books.add(new NoteBook(1,"Summer Plans",R.drawable.book17));
        books.add(new NoteBook(1,"Stories",R.drawable.book18));
        books.add(new NoteBook(1,"Some Notes",R.drawable.book19));
        books.add(new NoteBook(1,"Pharmacy",R.drawable.book20));
        books.add(new NoteBook(1,"Shopping",R.drawable.book21));
        books.add(new NoteBook(1,"ToDo List",R.drawable.book22));
        books.add(new NoteBook(1,"My Notes",R.drawable.book23));
        books.add(new NoteBook(1,"Summer Plans",R.drawable.book24));
        books.add(new NoteBook(1,"Stories",R.drawable.book25));
        books.add(new NoteBook(1,"Some Notes",R.drawable.book24));
        books.add(new NoteBook(1,"Pharmacy",R.drawable.book27));
        books.add(new NoteBook(1,"Shopping",R.drawable.book28));
        books.add(new NoteBook(1,"ToDo List",R.drawable.book29));
        //recycler of notebooks
        bookRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_all_notebooks);
        bookLayoutManager = new GridLayoutManager(this,3,RecyclerView.VERTICAL, false);
        bookRecyclerView.setLayoutManager(bookLayoutManager);
        bookAdapter = new AllNotebooksAdapter(books);
        bookRecyclerView.setAdapter(bookAdapter);
        //onCLick
        bookAdapter.setOnItemClickListener(new AllNotebooksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String name=books.get(position).getName();
                Toast.makeText(NoteBooksShowAll.this, name, Toast.LENGTH_SHORT).show();
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

        for (NoteBook item : books) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        bookAdapter.filterList(filteredList);
    }
    public void OnClickBackFromNotebooksToHome(View view) {
        Intent intent=new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}
