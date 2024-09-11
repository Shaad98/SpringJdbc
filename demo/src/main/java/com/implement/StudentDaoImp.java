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
        System.out.println(r+" row affected!");
    }

}
