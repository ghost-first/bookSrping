package com.example.bookproject.control;

import com.example.bookproject.entity.Book;
import com.example.bookproject.entity.Lent;
import com.example.bookproject.repository.LentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/lent")
public class LentHandle {
    @Autowired
    LentRepository lentRepository;

    @GetMapping("/save/{u_id}/{bookId}/{date}")
    public String save(@PathVariable("u_id") Integer u_id,@PathVariable("bookId") Integer bookId,@PathVariable("date") String date){
        Lent lent = new Lent();
        lent.setNumber(u_id);
        lent.setBookId(bookId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ud = null;
        try {
            ud = sdf.parse("2021-06-01");
            Date lentDate = new Date(ud.getTime());
            lent.setLentTime(lentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Lent result = lentRepository.save(lent);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/delete/{u_id}/{bookId}")
    public void save(@PathVariable("u_id") Integer u_id,@PathVariable("bookId") Integer bookId){
       lentRepository.deleteRecord(u_id,bookId);
    }
}
