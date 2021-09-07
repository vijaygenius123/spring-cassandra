package com.example.springcassandra.controller;

import com.example.springcassandra.model.Todo;
import com.example.springcassandra.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }


    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer id){
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Todo Not Found"));
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id){
        try {
            todoRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
