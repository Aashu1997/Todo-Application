package com.symb.task.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TodoActivity extends AppCompatActivity {

    Button create_todo,todo_list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        create_todo = findViewById(R.id.create_todo);
        todo_list = findViewById(R.id.todo_list);

        create_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCreate_todo();
            }
        });

        todo_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_todo_list();
            }
        });
    }

    public void setCreate_todo()
    {
        Intent intent = new Intent(TodoActivity.this,TodoSave.class);
        startActivity(intent);
    }

    public void show_todo_list()
    {
        Intent intent = new Intent(TodoActivity.this,ShowTodo.class);
        startActivity(intent);
    }

}
