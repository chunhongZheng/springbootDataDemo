package com.example.springbootjdbc.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class DruidTestController {
    /**
     * JdbcTemplate 是 core 包的核心类，用于简化 JDBC 操作，还能避免一些常见的错误，如忘记关闭数据库连接
     * Spring Boot 默认提供了数据源，默认提供了 org.springframework.jdbc.core.JdbcTemplate
     * JdbcTemplate 中会自己注入数据源，使用起来也不用再自己来关闭数据库连接
     */
    @Resource
    JdbcTemplate jdbcTemplate;
    /**
     * 查询 phone 表所有数据
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/orderList")
    public List<Map<String, Object>> userList() {
        /**
         * 查询 phone 表所有数据
         * List 中的1个 Map 对应数据库的 1行数据
         * Map 中的 key 对应数据库的字段名，value 对应数据库的字段值
         */
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT * FROM ebiz_agent limit 0,2");
        return mapList;
    }

}
