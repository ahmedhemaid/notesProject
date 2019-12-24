package com.example.notes.Activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.notes.R;
import com.example.notes.adapters.AllCategoryAdapter;
import com.example.notes.classes.CategoryStyle;
import java.util.ArrayList;

public class ChooseCategoryStyleActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;
    AllCategoryAdapter categoryAdapter;
    private RecyclerView.LayoutManager categoryLayoutManager;
    ArrayList<CategoryStyle> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category_style);
        //Books data
        categories=new ArrayList<CategoryStyle>();
        categories.add(new CategoryStyle(1,R.drawable.book1));
        categories.add(new CategoryStyle(2,R.drawable.book2));
        categories.add(new CategoryStyle(3,R.drawable.book3));
        categories.add(new CategoryStyle(4,R.drawable.book4));
        categories.add(new CategoryStyle(5,R.drawable.book5));
        categories.add(new CategoryStyle(6,R.drawable.book6));
        categories.add(new CategoryStyle(7,R.drawable.book7));
        categories.add(new CategoryStyle(8,R.drawable.book8));
        categories.add(new CategoryStyle(9,R.drawable.book9));
        categories.add(new CategoryStyle(10,R.drawable.book10));
        categories.add(new CategoryStyle(11,R.drawable.book11));
        categories.add(new CategoryStyle(12,R.drawable.book12));
        categories.add(new CategoryStyle(13,R.drawable.book13));
        categories.add(new CategoryStyle(14,R.drawable.book14));
        categories.add(new CategoryStyle(15,R.drawable.book15));
        categories.add(new CategoryStyle(16,R.drawable.book16));
        categories.add(new CategoryStyle(17,R.drawable.book17));
        categories.add(new CategoryStyle(18,R.drawable.book18));
        categories.add(new CategoryStyle(19,R.drawable.book19));
        categories.add(new CategoryStyle(20,R.drawable.book20));
        categories.add(new CategoryStyle(21,R.drawable.book21));
        categories.add(new CategoryStyle(22,R.drawable.book22));
        categories.add(new CategoryStyle(23,R.drawable.book23));
        categories.add(new CategoryStyle(24,R.drawable.book24));
        categories.add(new CategoryStyle(25,R.drawable.book25));
        categories.add(new CategoryStyle(26,R.drawable.book26));
        categories.add(new CategoryStyle(27,R.drawable.book27));
        categories.add(new CategoryStyle(28,R.drawable.book28));
        categories.add(new CategoryStyle(29,R.drawable.book29));
        //recycler of categories
        categoryRecyclerView =  findViewById(R.id.recycler_view_all_categories);
        categoryLayoutManager = new GridLayoutManager(this,3,RecyclerView.VERTICAL, false);
        categoryRecyclerView.setLayoutManager(categoryLayoutManager);
        categoryAdapter = new AllCategoryAdapter(categories);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickListener(new AllCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(ChooseCategoryStyleActivity.this,AddNewCategoryActivity.class);
                intent.putExtra("categoryStyleId" ,categories.get(position).getImageIcon());
                startActivity(intent);
                finish();
            }
        });
    }

    public void OnClickBackFromAllStylesToAddNewNotebook(View view) {
       finish();
    }
}
