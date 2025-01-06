package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    @GetMapping("/testTodo")
    public ResponseEntity<?> testTodo(){
        List<String> list = new ArrayList<>();
        list.add("testTodo ResponseEntity bad status");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }
}
