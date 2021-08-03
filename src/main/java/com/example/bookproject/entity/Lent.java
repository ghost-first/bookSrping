package com.example.bookproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Lent {
    private Integer number;
    @Id
    private Integer bookId;
    private Date lentTime;
    private Date backTime;

}
