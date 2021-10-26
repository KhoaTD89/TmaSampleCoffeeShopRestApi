package com.tma.sample.coffeeshop.unittest.jpa;

import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static boolean isInserted = false;
    private final String CREATE_CITY_SQL = "sql/create/data.sql";

    @Before
    public void testGetBeanFromConfiguration() throws SQLException {
        if(!isInserted){
            ScriptUtils.executeSqlScript(getConnection(), new ClassPathResource(CREATE_CITY_SQL));
            isInserted = true;
        }
    }

    @Test
    public void givenCustomerId_thenReturnListAddresses(){
        List<Address> byCustomerId = addressRepository.findByCustomerId(1);
        Assert.assertEquals(byCustomerId.get(0).getBuilding(),"bitecco");
    }

    @Test
    public void givenStoreId_thenReturnListAddresses(){
        List<Address> byCustomerId = addressRepository.findByCustomerId(1);
        Assert.assertEquals(byCustomerId.get(0).getBuilding(),"bitecco");
    }

    private Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }
}
