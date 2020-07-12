package com.symb.task.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.symb.task.todo.data.MyDbHandler;
import com.symb.task.todo.model.Record;

public class TodoSave extends AppCompatActivity {

    EditText message;
    Button save_btn;

    MyDbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_save);

        message=findViewById(R.id.message_box);
        save_btn=findViewById(R.id.save_btn);

        db = new MyDbHandler(TodoSave.this);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datasave();
            }
        });
    }

    public void datasave()
    {
        String msg = message.getText().toString();

        Record record = new Record(0,msg,"");

        db.insertRecord(record);

        message.setText(" ");

        Toast.makeText(this, "DATA SAVED!!!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(TodoSave.this,TodoActivity.class);
        startActivity(intent);
    }
}
