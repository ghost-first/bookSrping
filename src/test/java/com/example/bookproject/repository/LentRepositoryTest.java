package com.example.bookproject.repository;

import com.example.bookproject.entity.Lent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LentRepositoryTest {
    @Autowired
    LentRepository lentRepository;

    @Test
    void findAll(){
        List<Lent> all = lentRepository.findAll();
        for (Lent lent : all) {
            System.out.println(lent);
        }
    }

    @Test
    void save(){
        Lent lent = new Lent();
        lent.setNumber(1202);
        lent.setBookId(5);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date ud = sdf.parse("2021-06-01");
            Date date = new Date(ud.getTime());
            lent.setLentTime(date);
        } catch (ParseException e) {
            System.out.println("转换错误");
            e.printStackTrace();
        }

        Lent lent1 = lentRepository.save(lent);
        System.out.println(lent1);
    }

    @Test
    void findByBookId(){
        Lent lent = lentRepository.findByBookId(8);
        System.out.println(lent);
    }

    @Test
    void deleteById(){
        lentRepository.deleteById(5);
    }

    @Test
    void deleteRecord(){
        lentRepository.deleteRecord(1202,5);
    }
}