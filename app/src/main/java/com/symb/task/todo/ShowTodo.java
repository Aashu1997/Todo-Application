package com.symb.task.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.symb.task.todo.adapter.TodoAdapter;
import com.symb.task.todo.data.MyDbHandler;
import com.symb.task.todo.model.Record;

import java.util.ArrayList;

public class ShowTodo extends AppCompatActivity {

    RecyclerView recyclerView;
    MyDbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_todo);

        recyclerView=findViewById(R.id.todo_list);

        db = new MyDbHandler(ShowTodo.this);
        readdata();
    }

    public void readdata() {
        ArrayList<Record> recordArrayList = db.getAllRecord();

        TodoAdapter adapter = new TodoAdapter(this, recordArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
}
