package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.TodoList;
import com.example.demo.domain.repository.TodoListDao;

@Service
public class TodoListService {

    @Autowired
    TodoListDao dao;

    public boolean insert(TodoList todoList) {
        int rowNumber = dao.insertOne(todoList);

        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }

        return result;

    }

    public List<TodoList> selectMany() {
        return dao.selectMany();
    }

    public boolean updateOne(TodoList todoList) {

        int rowNumber = dao.updateOne(todoList);

        boolean result = false;

        if (rowNumber > 0) {
            result = true;
        }

        return result;
    }

    public boolean deleteOne(TodoList todoList) {

        int rowNumber = dao.deleteOne(todoList);

        boolean result = false;

        if (rowNumber > 0) {
            result = true;

        }
        return result;
    }
}
