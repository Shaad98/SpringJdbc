package com.implement;

import com.entities.Student;

public interface StudentDao {
    public void insert(Student student);
    public void update(Student student);
    public void delete(int id);
}
