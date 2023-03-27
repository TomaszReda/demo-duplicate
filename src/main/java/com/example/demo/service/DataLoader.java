package com.example.demo.service;

import com.example.demo.entity.BookDto;
import com.example.demo.entity.RandomEnum;
import com.example.demo.entity.Student;
import com.example.demo.entity.Version;
import com.example.demo.repo.StudentRepositoryyy;
import com.example.demo.repo.VersionRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private VersionRepository versionRepository;

    private StudentRepositoryyy studentRepositoryyy;


    public void run(ApplicationArguments args) {
        Version version = new Version();
        version.setSample("cos");
        BookDto bookDto = new BookDto();
        bookDto.setBookName("bookName");
        bookDto.setAuthor("atuhor");
        bookDto.setRandomEnum(RandomEnum.KTOS);
        bookDto.setNumberOfPage("number");
        val bookDtos = Set.of(bookDto);
        Student student = new Student();
        student.setStudentName("studentName");
        student.setBookDtos(bookDtos);
        student.setVersionNUmber(1L);

        version.setStudentList(List.of(student));
        student.setVersion(version);
        versionRepository.save(version);
    }
}