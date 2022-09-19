package com.edu.ulab.app.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class UserEntity {
    private Long id;

    private String fullName;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return age == that.age && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age);
    }
}
