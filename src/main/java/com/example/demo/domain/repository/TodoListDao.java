package com.example.demo.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.domain.model.TodoList;

public interface TodoListDao {

    public int insertOne(TodoList todoList) throws DataAccessException;

    public List<TodoList> selectMany() throws DataAccessException;

    public int updateOne(TodoList todoList) throws DataAccessException;

    public int deleteOne(TodoList todo_list) throws DataAccessException;

}
