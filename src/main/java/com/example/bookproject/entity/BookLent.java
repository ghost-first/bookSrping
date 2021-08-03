package com.example.bookproject.entity;

import java.sql.Date;

public interface BookLent {
    Integer getNumber();

    Integer getBookId();

    String getBookName();

    Date getLentTime();

    Date getBackTime();

    String getAuthor();

    Double getPrice();

    String getType();
}
