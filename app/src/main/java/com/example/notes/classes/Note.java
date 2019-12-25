package com.example.notes.classes;

import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
    public String categoryId="public";
    public String idOfNote;
    public String titleOfNote;
    public String contextOfNote;
    public long dateOfNote;
public Note(){}
    public Note(String categoryId,String idOfNote, String titleOfNote, String contextOfNote, long dateOfNote) {
        this.idOfNote = idOfNote;
        this.categoryId=categoryId;
        this.titleOfNote = titleOfNote;
        this.contextOfNote = contextOfNote;
        this.dateOfNote = dateOfNote;
    }

    public static String generateNoteID(){
        return FirebaseDatabase.getInstance().getReference().child("user").child("note").push().getKey();

    }
    public static String longToDate(long val){
        Date date=new Date(val);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);
        return dateText;
}
    // id getter and setter
}