package com.vitzay;
public class Task {
    public String task;
    protected String state = "uncompleted";

    public Task(String task) {
        this.task = task;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return task + ", " + state;
    }
}
