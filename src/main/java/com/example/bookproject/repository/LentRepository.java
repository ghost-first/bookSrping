package com.example.bookproject.repository;

import com.example.bookproject.entity.Lent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LentRepository extends JpaRepository<Lent,Integer> {
    //查询某图书是否被借阅
    @Query(nativeQuery = true, value = "select * from lent where book_id = :id")
    Lent findByBookId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from lent where number = :u_id and book_id = :b_id")
    void deleteRecord(@Param("u_id") Integer u_id,@Param("b_id") Integer b_id);
}
