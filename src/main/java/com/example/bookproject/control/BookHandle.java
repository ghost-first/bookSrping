package com.example.bookproject.control;

import com.example.bookproject.entity.Book;
import com.example.bookproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookHandle {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/getById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book){
        System.out.println(book);
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }

    @GetMapping("/updatePrice/{id}/{price}")
    public String updatePrice(@PathVariable("id") Integer id, @PathVariable("price") Double price){
        try {
            System.out.println(id + "--" + price);
            bookRepository.updatePrice(id,price);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

    @GetMapping("/mathTitle")
    public List<String> mathTitle(){
        List<String> s = bookRepository.findByGroupType();
        return s;
    }

    @GetMapping("/mathData")
    public List<Integer> mathData(){
        List<Integer> i = bookRepository.findByGroupSum();
        return i;
    }

    @GetMapping("/findByBookName/{bookName}")
    public List<Book> findByBookName(@PathVariable("bookName") String bookName){
        return bookRepository.findByName(bookName);
    }

    @GetMapping("/findByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable("author") String author){
        return bookRepository.findByAuthor(author);
    }

    @GetMapping("/findByPrice/{low}/{high}")
    public List<Book> findByPrice(@PathVariable("low") Double low,@PathVariable("high") Double high){
        return bookRepository.findByPrice(low,high);
    }
}
