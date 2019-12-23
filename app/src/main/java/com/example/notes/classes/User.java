package com.example.notes.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    public String id;
    public Map<String , NoteBook> category  = new HashMap<>();
    public Map<String , Note> notes  = new HashMap<>();


    public User() {
    }
}
