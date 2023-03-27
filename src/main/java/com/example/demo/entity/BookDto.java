package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
public class BookDto {


    private String bookName;

    private String numberOfPage;

    private String author;

    private RandomEnum randomEnum;

    private String random;


}