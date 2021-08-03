package com.example.bookproject.control;

import com.example.bookproject.entity.BookLent;
import com.example.bookproject.repository.BookLentRepository;
import com.example.bookproject.repository.LentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookLent")
public class BookLentHandle {
    @Autowired
    private BookLentRepository bookLentRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<BookLent> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return bookLentRepository.findPageBookLent(pageable);
    }

    @GetMapping("/haveLent/{id}")
    public List<BookLent> findByNumber(@PathVariable("id") Integer id){
        return bookLentRepository.findAllByNumber(id);
    }
}
