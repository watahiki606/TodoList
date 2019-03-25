package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.model.RegistForm;
import com.example.demo.domain.model.TodoList;
import com.example.demo.domain.service.TodoListService;

@Controller
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/home")
    public String getHome(@ModelAttribute RegistForm form, Model model) {
        model.addAttribute("contents", "contents::contents");
        List<TodoList> todoLists = todoListService.selectMany();

        model.addAttribute("todoLists", todoLists);

        return "todoList";
    }

    @GetMapping("/regist")
    public String getRegist(@ModelAttribute RegistForm form, Model model) {
        model.addAttribute("contents", "contents::contents");

        return "todoList";
    }

    @PostMapping("/regist")
    public String postRegist(@ModelAttribute RegistForm form, BindingResult bindingResult, Model model) {
        TodoList todoList = new TodoList();

        todoList.setTodo_id(form.getTodoId());
        todoList.setTodo_title(form.getTodoTitle());
        todoList.setTodo_detail(form.getTodoDetail());

        boolean result = todoListService.insert(todoList);

        if (result == true) {
            System.out.println("insert成功");
        } else {
            System.out.println("insert失敗");
        }
        model.addAttribute("contents", "contents::contents");
        getHome(form, model);

        return "todoList";
    }

    @PostMapping(value = "/edit", params = "update")
    public String postTodoListUpdate(@ModelAttribute RegistForm form, Model model) {
        System.out.println("更新ボタン処理");

        TodoList todoList = new TodoList();

        todoList.setTodo_id(form.getTodoId());
        todoList.setTodo_title(form.getTodoTitle());
        todoList.setTodo_detail(form.getTodoDetail());

        boolean result = todoListService.updateOne(todoList);

        if (result == true) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失敗");
        }

        return getHome(form, model);

    }

    @PostMapping(value = "/edit", params = "delete")
    public String postTodoListDelete(@ModelAttribute RegistForm form, Model model) {
        System.out.println("削除ボタン処理");

        TodoList todoList = new TodoList();

        todoList.setTodo_id(form.getTodoId());
        todoList.setTodo_title(form.getTodoTitle());
        todoList.setTodo_detail(form.getTodoDetail());

        boolean result = todoListService.deleteOne(todoList);

        if (result == true) {
            System.out.println("削除成功");
        } else {
            System.out.println("削除失敗");
        }

        return getHome(form, model);

    }
}
