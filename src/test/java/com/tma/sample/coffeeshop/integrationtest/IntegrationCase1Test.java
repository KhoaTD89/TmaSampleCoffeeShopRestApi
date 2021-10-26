package com.tma.sample.coffeeshop.integrationtest;

import com.tma.sample.coffeeshop.CoffeeShopApplication;
import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.CityRepository;
import com.tma.sample.coffeeshop.unittest.service.AddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.sql.SQLException;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class IntegrationCase1Test {
    private static final long CUSTOMER_ID = 1;
    private final String CREATE_CITY_SQL = "sql/create/data.sql";

    @Autowired
    private MockMvc mvc;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AddressRepository addressRepository;

    @Before
    public void testGetBeanFromConfiguration() throws SQLException {
        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new ClassPathResource(CREATE_CITY_SQL));
    }

    @Test
    @RollBack(false)
    public void givenAddresses_whenGetByCustomerId_thenStatus200() throws Exception {
//        Assert.assertEquals(addressRepository.findByCustomerId(1).get(0).getBuilding(),"Hwllo");
                mvc.perform(MockMvcRequestBuilders.get("/admin/addresses/customer/{customerId}", CUSTOMER_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());
    }


}
