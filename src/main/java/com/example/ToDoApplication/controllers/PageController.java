package com.example.ToDoApplication.controllers;

import com.example.ToDoApplication.models.StatusType;
import com.example.ToDoApplication.models.Todo;
import com.example.ToDoApplication.models.TodoUser;
import com.example.ToDoApplication.services.TodoService;
import com.example.ToDoApplication.services.TodoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class PageController {

    final TodoService todoService;
    final TodoUserService todoUserService;

    @GetMapping("/user/{user}")
    public ModelAndView index(@PathVariable(required = false) String user) {
        if(user==null)user="default";
        TodoUser todoUser = todoUserService.getOrCreate(user);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", todoUser.getName());

        modelAndView.addObject("backlog", todoUser.allByStatus(StatusType.BACKLOG));
        modelAndView.addObject("doing", todoUser.allByStatus(StatusType.DOING));
        modelAndView.addObject("done", todoUser.allByStatus(StatusType.DONE));
        modelAndView.addObject("newTodo", new Todo());
        return modelAndView;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/user/default";
    }
}
