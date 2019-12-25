package com.example.notes.classes;

import android.graphics.drawable.Icon;

import com.example.notes.Activities.HomeActivity;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;

@IgnoreExtraProperties
public class NoteBook {
    public String id;
    public String name;
    public int imageIcon;
    public ArrayList<Note> mNotes=new ArrayList<>();
    public NoteBook() {
    }

    public NoteBook(String id, String name, int imageIcon) {
        this.id = id;
        this.name = name;
        this.imageIcon = imageIcon;
     }

    public static String generateCategoryID(){
       return FirebaseDatabase.getInstance().getReference().child("user").child("category").push().getKey();

    }
//// id getter and setter
//    public void setId(int id) {
//        this.id = id;
//    }
//    public int getId() {
//        return id;
//    }
////  name getter and setter
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
////   image getter and setter
//    public int getImageIcon() {
//        return imageIcon;
//    }
//    public void setImageIcon(int imageIcon) {
//        this.imageIcon = imageIcon;
//    }

}
