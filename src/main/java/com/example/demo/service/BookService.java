package com.example.demo.service;


import com.example.demo.entity.BookDto;
import com.example.demo.entity.RandomEnum;
import com.example.demo.entity.Student;
import com.example.demo.entity.Version;
import com.example.demo.repo.StudentRepositoryyy;
import com.example.demo.repo.VersionRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class BookService {
    private VersionRepository versionRepository;

    private StudentRepositoryyy studentRepositoryyy;


    public void cos() {
        Version version = versionRepository.findAll().get(versionRepository.findAll().size()-1);
        addStudnet(version);
        versionRepository.save(version);

    }

    private void addStudnet(Version orginal) {
        BookDto bookDto = new BookDto();
        bookDto.setBookName("bookName222222");
        bookDto.setAuthor("atuhor2222");
        bookDto.setRandomEnum(RandomEnum.COS);
        bookDto.setNumberOfPage("number22222");

        BookDto bookDto3 = new BookDto();
        bookDto3.setBookName("33333333");
        bookDto3.setAuthor("33333333");
        bookDto3.setRandomEnum(RandomEnum.COS);
        bookDto3.setNumberOfPage("3333333333333333333333");
        val bookDtos = Set.of(bookDto,bookDto3);
        Student student = new Student();
        student.setStudentName("studentName2222222222");
        student.setBookDtos(bookDtos);
        student.setVersionNUmber(2L);

        orginal.getStudentList().add(student);
        student.setVersion(orginal);

//        studentRepositoryyy.save(student);
    }


}
