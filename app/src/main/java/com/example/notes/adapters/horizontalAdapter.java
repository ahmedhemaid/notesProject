package com.example.notes.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.example.notes.R;
import com.example.notes.classes.NoteBook;
import java.util.ArrayList;


public class horizontalAdapter extends RecyclerView.Adapter<horizontalAdapter.ViewHolder> {

    private ArrayList<NoteBook> data;
    private AllNotebooksAdapter.OnItemClickListener mListener;
    public horizontalAdapter(ArrayList<NoteBook> data){
        this.data = data;
    }

    //onItemClick
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(AllNotebooksAdapter.OnItemClickListener listener){
        mListener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_of_book, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bookName.setText(data.get(position).name);
        holder.bookImage.setImageResource(data.get(position).imageIcon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView bookImage;
        public TextView bookName;

        public ViewHolder(View itemView) {
            super(itemView);
            bookImage=itemView.findViewById(R.id.book_image);
            bookName=itemView.findViewById(R.id.book_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
        }
}