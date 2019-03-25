package com.example.demo.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.TodoList;
import com.example.demo.domain.repository.TodoListDao;

@Repository
public class TodoListDaoJdbcImpl implements TodoListDao {
    @Autowired
    private JdbcTemplate jdbc;

    public Map<String, Object> findOne(int id) {

        String query = "select"
                + "todo_id,"
                + "todo_title,"
                + "todo_detail "
                + "from to_do_list "
                + "where todo_id=?";

        Map<String, Object> todoList = jdbc.queryForMap(query, id);

        return todoList;
    }

    @Override
    public int insertOne(TodoList todoList) throws DataAccessException {
        int rowNumber = jdbc.update("insert into to_do_list("
                + "todo_id,"
                + "todo_title,"
                + "todo_detail)"
                + "values(?,?,?)", todoList.getTodo_id(), todoList.getTodo_title(), todoList.getTodo_detail());

        return rowNumber;
    }

    @Override
    public List<TodoList> selectMany() throws DataAccessException {
        List<Map<String, Object>> getList = jdbc.queryForList("select * from to_do_list");
        List<TodoList> todoList = new ArrayList<>();
        for (Map<String, Object> map : getList) {
            TodoList todoOne = new TodoList();
            todoOne.setTodo_id((Integer) map.get("todo_id"));
            todoOne.setTodo_title((String) map.get("todo_title"));
            todoOne.setTodo_detail((String) map.get("todo_detail"));
            System.out.println(todoOne);

            todoList.add(todoOne);
        }
        return todoList;
    }

    @Override
    public int updateOne(TodoList todoList) throws DataAccessException {
        int rowNumber = jdbc.update("update to_do_list"
                + " set"
                + " todo_title = ?,"
                + " todo_detail = ?"
                + " where todo_id = ?", todoList.getTodo_title(), todoList.getTodo_detail(), todoList.getTodo_id());
        return rowNumber;
    }

    @Override
    public int deleteOne(TodoList todoList) throws DataAccessException {
        int rowNumber = jdbc.update("delete from to_do_list where todo_id = ? and todo_title = ? and todo_detail = ?",
                todoList.getTodo_id(), todoList.getTodo_title(), todoList.getTodo_detail());
        return rowNumber;
    }

}
