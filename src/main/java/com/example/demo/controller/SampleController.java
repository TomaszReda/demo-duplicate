package com.example.demo.controller;


import com.example.demo.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class SampleController {


    private final BookService bookService;

    @GetMapping
    public void saveBook() {

        bookService.cos();
    }
}
