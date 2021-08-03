package com.example.bookproject.repository;

import com.example.bookproject.entity.BookLent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookLentRepositoryTest {
    @Autowired
    BookLentRepository bookLentRepository;

    @Test
    void findAllBookLent(){
        List<BookLent> all = bookLentRepository.findAllBookLent();
        all.stream().forEach(dto ->{
            System.out.print("{" + dto.getNumber() + "-");
            System.out.print(dto.getBookId() + "-");
            System.out.print(dto.getBookName() + "-");
            System.out.print(dto.getLentTime() + "-");
            System.out.print(dto.getPrice() + "-");
            System.out.println(dto.getBackTime() + "}");
        });
    }

    @Test
    void findById(){
        List<BookLent> all = bookLentRepository.findAllByNumber(1200);
        for (BookLent bookLent : all) {
            System.out.print("{" + bookLent.getNumber() + "-");
            System.out.print(bookLent.getBookId() + "-");
            System.out.print(bookLent.getBookName() + "-");
            System.out.print(bookLent.getLentTime() + "-");
            System.out.println(bookLent.getBackTime() + "}");
        }
    }
}