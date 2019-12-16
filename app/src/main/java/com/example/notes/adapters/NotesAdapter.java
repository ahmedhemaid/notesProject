package com.example.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.classes.Note;

import java.util.ArrayList;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private ArrayList<Note> data;

    public NotesAdapter(ArrayList<Note> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.noteTitle.setText(data.get(position).getTitleOfNote());
        holder.noteContext.setText(data.get(position).getContextOfNote());
        holder.noteDate.setText(data.get(position).getDateOfNote());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView noteTitle,noteContext,noteDate;
        public ViewHolder(View itemView) {
            super(itemView);
            noteTitle=itemView.findViewById(R.id.note_title);
            noteContext=itemView.findViewById(R.id.note_context);
            noteDate=itemView.findViewById(R.id.note_date);

        }
    }
}