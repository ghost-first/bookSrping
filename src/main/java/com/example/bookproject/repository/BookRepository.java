package com.example.bookproject.repository;

import com.example.bookproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Procedure(procedureName = "updatePrice")
    void updatePrice(@Param("n") int n, @Param("p") double p);

    @Query(nativeQuery = true, value = "select type from book group by type")
    List<String> findByGroupType();

    @Query(nativeQuery = true, value = "select count(*) from book group by type")
    List<Integer> findByGroupSum();

    @Query(nativeQuery = true, value = "select * from book b where b.author = :authorName")
    List<Book> findByAuthor(@Param("authorName") String authorName);

    @Query(nativeQuery = true, value = "select * from book b where b.name = :bookName")
    List<Book> findByName(@Param("bookName") String bookName);

    @Query(nativeQuery = true, value = "select * from book b where b.price between :low and :high")
    List<Book> findByPrice(@Param("low") Double low,@Param("high") Double high);
}