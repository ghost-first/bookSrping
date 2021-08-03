package com.example.bookproject.repository;

import com.example.bookproject.entity.Book;
import com.example.bookproject.entity.BookLent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookLentRepository extends JpaRepository<Book,Integer> {

    @Query(nativeQuery = true, value = "select l.number as number,b.id as bookId,b.name as bookName,b.price as price," +
            "l.lent_time as lentTime,l.back_time as backTime from  book b left join lent l on b.id = l.book_id " +
            " order by b.id")
    List<BookLent> findAllBookLent();

    @Query(nativeQuery = true, value = "select l.number as number,b.id as bookId,b.name as bookName," +
            "b.author as author,b.price as price, b.type as type," +
            "l.lent_time as lentTime,l.back_time as backTime from book b left join lent l on b.id = l.book_id " +
            " order by b.id",countQuery = "select count(*) from book")
    Page<BookLent> findPageBookLent(Pageable pageable);

    @Query(nativeQuery = true, value = "select l.number as number,b.id as bookId,b.name as bookName,b.author as author," +
            "b.price as price, b.type as type," +
            "l.lent_time as lentTime,l.back_time as backTime from book b left join lent l on b.id = l.book_id " +
            "where l.number = :user_no order by b.id")
    List<BookLent> findAllByNumber(@Param("user_no") Integer user_no);
}
