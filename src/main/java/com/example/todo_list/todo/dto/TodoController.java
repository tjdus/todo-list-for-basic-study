package com.example.todo_list.todo.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("")
    public ResponseEntity<List<TodoDto>> getAll() {
        List<TodoDto> todos = todoService.getAll();

        return ResponseEntity.ok(todos);
    }

    @PostMapping("")
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto dto) {
        TodoDto createdTodo = todoService.create(dto);
        return ResponseEntity.ok(createdTodo);
    }

    //id로 조회하기
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getById(@PathVariable Long id) {
        TodoDto todo = todoService.getById(id);
        return ResponseEntity.ok(todo);
    }


    //id로 삭제하기
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //id로 수정하기
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateById(@PathVariable Long id, @RequestBody TodoDto dto) {
        TodoDto updatedTodo = todoService.updateById(id, dto);
        return ResponseEntity.ok(updatedTodo);
    }

}
