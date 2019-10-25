package com.example.springbootjdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SpringbootJdbcApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        try{
           Connection connection = dataSource.getConnection();
           System.out.println("connection:"+connection);
        }catch(Exception e){

        }

    }

}
