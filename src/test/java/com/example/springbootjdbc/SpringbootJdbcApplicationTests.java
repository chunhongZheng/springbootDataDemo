package com.example.springbootjdbc;

import com.alibaba.druid.pool.DruidDataSource;
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
            System.out.println("数据源>>>>>>" + dataSource.getClass());
            Connection connection = dataSource.getConnection();

            System.out.println("连接>>>>>>>>>" + connection);
            System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
            DruidDataSource druidDataSource = (DruidDataSource) dataSource;
            System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
            System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
