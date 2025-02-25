package com.example.rest.controller;

import com.example.rest.domain.Todo;
import com.example.rest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(201).body(todoService.CreateTodoListService(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> showTodoList() {
        List<Todo> todoList = todoService.getTodoListsService();
        //body안에 넣어도 되고 그냥 여기에 넣어도 되고
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> showTodoById(@PathVariable("id") Long id) {
       return ResponseEntity.ok().body(todoService.getTodoByIdService(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id")Long id) {
        return ResponseEntity.ok(todoService.updateTodoService(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id")Long id) {
        todoService.deleteTodoService(id);
        //void라서 저리함 뒤의 둘은 인자 안들어감
        return ResponseEntity.noContent().build();
    }
}
