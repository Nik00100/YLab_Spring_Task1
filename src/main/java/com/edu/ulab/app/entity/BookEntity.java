package com.edu.ulab.app.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class BookEntity {
    private Long id;
    private Long userId;
    private String title;
    private String author;
    private long pageCount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return pageCount == that.pageCount
                && Objects.equals(userId, that.userId) && Objects.equals(title, that.title)
                && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, author, pageCount);
    }
}
