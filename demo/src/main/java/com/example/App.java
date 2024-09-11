package com.example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * Hello world!
 *@aurthor Shaad Bangi
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("com/example/config.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        String query = "INSERT INTO student VALUES(?,?,?)";
        int r = jdbcTemplate.update(query, 12,"Shaad","Solapur");
        System.out.println("Number of record inserted : "+r);
    }
}
