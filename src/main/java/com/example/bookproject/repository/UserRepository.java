package com.example.bookproject.repository;

import com.example.bookproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true, value = "select max(number) as number from user")
    Integer findMax();
}
