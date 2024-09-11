package com.implement;

import org.springframework.jdbc.core.JdbcTemplate;

import com.entities.Student;

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



}
