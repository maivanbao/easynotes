package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.Exception.ResourceNotFoundException;
import com.example.easynotes.model.Todo;
import com.example.easynotes.repository.TodoRepository;

@RestController
@CrossOrigin("*")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;

	@GetMapping("/todos")
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}

	@PostMapping("/todos")
	public Todo createTodo(@Valid @RequestBody Todo todo) {
		todo.setCompleted(false);
		return todoRepository.save(todo);

	}

	@GetMapping("/todos/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable(value = "todoId") Long todoId) {
		return todoRepository.findById(todoId).map(todo -> {
			return ResponseEntity.ok(todo);
		}).orElseThrow(()-> new ResourceNotFoundException("Not Found"));
	}

	@PutMapping("/todos/{todoId}")
	public ResponseEntity<Todo> updateTodo(@PathVariable(value = "todoId") Long todoId, @Valid @RequestBody Todo todoRequest) {
		return todoRepository.findById(todoId).map(todo -> {
			todo.setCompleted(todoRequest.getCompleted());
			todo.setTitle(todoRequest.getTitle());
			Todo updatedTodo = todoRepository.save(todo);
			return ResponseEntity.ok().body(updatedTodo);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/todos/{todoId}")
	public ResponseEntity<?> deleteTodo(@PathVariable("todoId") Long id) {
		return todoRepository.findById(id).map(todo -> {
			todoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(()-> new ResourceNotFoundException("Not Found"));
	}

}
