package com.example.notes.classes;

public class CategoryStyle {
    private int id;
    private int imageIcon;
    public CategoryStyle(int id, int imageIcon){
        this.id=id;
        this.imageIcon=imageIcon;
    }
// id getter and setter
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
//   image getter and setter
    public int getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }

}
