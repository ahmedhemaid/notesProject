package com.example.notes.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.notes.R;
import com.example.notes.classes.Note;
import com.example.notes.classes.NoteBook;
import com.example.notes.classes.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import static com.example.notes.Activities.HomeActivity.books;

public class AddNewCategoryActivity extends Activity {
    String categoryName;
    SharedPreferences preferences;
    int categoryImage;
    EditText name;
    static NoteBook mNoteBook=new NoteBook();
    ImageView imageCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        name=findViewById(R.id.edit_text_category_name);
        imageCategory=(ImageView) findViewById(R.id.book_category_image);
        imageCategory.setImageResource(getIntent().getIntExtra("categoryStyleId",R.drawable.book29));
    }
    public void onClickSave(View view) {
        categoryName=name.getText().toString();
        mNoteBook=new NoteBook(NoteBook.generateCategoryID(),categoryName,getIntent().getIntExtra("categoryStyleId",R.drawable.book29));
        HomeActivity.writeNotebook(mNoteBook);
        books.add(mNoteBook);
        Toast.makeText(this, "Notebook is added successfully", Toast.LENGTH_SHORT).show();
        getIntent().putExtra("CategoryName",categoryName);
        finish();
    }

    public void OnClickShowStyles(View view) {
        Intent intent=new Intent(this,ChooseCategoryStyleActivity.class);
        startActivity(intent);
        finish();
    }

    public void OnClickCancle(View view) {
        finish();
    }
}
