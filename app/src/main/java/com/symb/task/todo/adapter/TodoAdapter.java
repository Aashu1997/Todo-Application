package com.symb.task.todo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.symb.task.todo.R;
import com.symb.task.todo.model.Record;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    Context context;
    ArrayList<Record> recordArrayList;

    public TodoAdapter(Context context, ArrayList<Record> record) {
        this.context = context;
        this.recordArrayList = record;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_list_todo,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Record record = recordArrayList.get(i);

        viewHolder.message_box.setText(record.getMessage());
        viewHolder.date_box.setText(record.getDate());
    }

    @Override
    public int getItemCount() {
        return recordArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView message_box,date_box;

        public ViewHolder(View itemView) {
            super(itemView);

            message_box = itemView.findViewById(R.id.message);
            date_box = itemView.findViewById(R.id.date);

        }
    }

}
