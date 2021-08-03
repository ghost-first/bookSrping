package com.example.bookproject.repository;

import com.example.bookproject.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            System.out.println(book);
        }
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("SpringBoot");
        book.setAuthor("小李");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);

    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(124);
        book.setName("加油");
        book.setAuthor("明天会更好");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookRepository.deleteById(120 );
    }

    @Test
    void updateP(){
        bookRepository.updatePrice(8,34.50);
    }


    @Test
    void Group(){
        List<String> byGroup = bookRepository.findByGroupType();
        for (String s : byGroup) {
            System.out.println(s);
        }
    }

    @Test
    void group3(){
        List<Integer> list = bookRepository.findByGroupSum();
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    void findByAuthor(){
        List<Book> books = bookRepository.findByAuthor("罗贯中");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void findByName(){
        List<Book> books = bookRepository.findByName("解忧杂货店");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void findByPrice(){
        List<Book> books = bookRepository.findByPrice(60.0, 120.0);
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
