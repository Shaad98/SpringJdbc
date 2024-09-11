package com.implement;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entities.Student;
import com.select.RowMapperImp;

public class StudentDaoImp implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    

    
    
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    public StudentDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    
    public StudentDaoImp() {
    }

    @Override
    public void insert(Student student) {
       String query = "INSERT INTO student (id,name,city) VALUES (?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
        System.out.println(r+" row inserted!");
    }


    @Override
    public void update(Student student) {
        String query = "UPDATE student SET name = ? , city = ? WHERE id = ? ";
        int r = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        System.out.println(r+" row updated!");
    }


    @Override
    public void delete(int id) {
        String query = "DELETE FROM student WHERE id = ? ";
        int r = this.jdbcTemplate.update(query,id);
        System.out.println(r+" row deleted!");
    }


    @Override
    public Student getStudent(int id) {
        // selecting single student data
        String query = "SELECT * FROM student WHERE id = ?";
        // RowMapper<Student> rowMapper= new RowMapperImp();
        Student student = this.jdbcTemplate.queryForObject(query,new RowMapperImp(),id);
        return student;
    }


    @Override
    public List<Student> getAllStudents() {
        // selecting multiple student
        String query = "SELECT * FROM student";
        List<Student> students = this.jdbcTemplate.query(query,new RowMapperImp());
        return students;
    }
    


}
