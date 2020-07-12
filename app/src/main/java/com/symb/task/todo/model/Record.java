package com.symb.task.todo.model;

public class Record {

        int id;
        String message;
        String date;

        public Record(int id, String message,String date) {
            this.id = id;
            this.message = message;
            this.date = date;
        }

        public Record() {
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
