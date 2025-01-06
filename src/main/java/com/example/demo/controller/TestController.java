package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String testController(){
        return "hello World";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath(){
        return "hello world testGetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required=false) int id){
        return "hello world id : "+ id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required=false)int id){
        return "hello world requestParam : "+ id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "hello world id = "+ testRequestBodyDTO.getId()+ ", Message = "+ testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("responseEntity test and you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }
}
