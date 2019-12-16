package com.example.notes.classes;

public class Note {
    private int idOfNote;
    private String titleOfNote;
    private String contextOfNote;
    private String dateOfNote;

    public Note(int idOfNote ,String titleOfNote,String contextOfNote,String dateOfNote ){
        this.idOfNote=idOfNote;
        this.titleOfNote=titleOfNote;
        this.contextOfNote=contextOfNote;
        this.dateOfNote=dateOfNote;
    }
    // id getter and setter

    public int getIdOfNote() {
        return idOfNote;
    }
    public void setIdOfNote(int idOfNote) {
        this.idOfNote = idOfNote;
    }
    //title getter and setter
    public String getTitleOfNote() {
        return titleOfNote;
    }

    public void setTitleOfNote(String titleOfNote) {
        this.titleOfNote = titleOfNote;
    }
    //context getter and setter

    public String getContextOfNote() {
        return contextOfNote;
    }

    public void setContextOfNote(String contextOfNote) {
        this.contextOfNote = contextOfNote;
    }
    //date getter and setter

    public String getDateOfNote() {
        return dateOfNote;
    }

    public void setDateOfNote(String dateOfNote) {
        this.dateOfNote = dateOfNote;
    }
}