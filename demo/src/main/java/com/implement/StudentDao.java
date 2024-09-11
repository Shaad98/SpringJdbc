package com.implement;

import com.entities.Student;
import java.util.*;
public interface StudentDao {
    public void insert(Student student);
    public void update(Student student);
    public void delete(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
