package com.example.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "to_do_list")
public class TodoList {
    @Id
    @Column(name = "todo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todo_id;
    @Column(name = "todo_title")
    private String todo_title;
    @Column(name = "todo_detail")
    String todo_detail;

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Integer todo_id) {
        this.todo_id = todo_id;
    }

    public String getTodo_title() {
        return todo_title;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }

    public String getTodo_detail() {
        return todo_detail;
    }

    public void setTodo_detail(String todo_detail) {
        this.todo_detail = todo_detail;
    }

}
