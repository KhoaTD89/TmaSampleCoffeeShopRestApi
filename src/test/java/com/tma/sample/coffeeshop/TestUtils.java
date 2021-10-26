package com.tma.sample.coffeeshop;


import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class TestUtils {
    private static boolean isInserted = false;
    private final String CREATE_CITY_SQL = "sql/create/data.sql";
    @Autowired
    JdbcTemplate jdbcTemplate;

    private Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }

    public void insertData() throws SQLException {
        if(!isInserted){
            ScriptUtils.executeSqlScript(getConnection(), new ClassPathResource(CREATE_CITY_SQL));
            isInserted = true;
        }
    }
}
