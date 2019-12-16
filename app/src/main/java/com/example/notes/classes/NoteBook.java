package com.example.notes.classes;

import android.graphics.drawable.Icon;

public class NoteBook {
    private int id;
    private String name;
    private int imageIcon;
    public NoteBook(int id, String name, int imageIcon){
        this.id=id;
        this.name=name;
        this.imageIcon=imageIcon;
    }
// id getter and setter
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
//  name getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//   image getter and setter
    public int getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }

}
