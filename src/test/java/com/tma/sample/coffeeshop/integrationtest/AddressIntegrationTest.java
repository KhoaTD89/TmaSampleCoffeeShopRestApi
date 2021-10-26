package com.tma.sample.coffeeshop.integrationtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tma.sample.coffeeshop.CoffeeShopApplication;
import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.CityRepository;
import com.tma.sample.coffeeshop.unittest.service.AddressService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
    @TestPropertySource("classpath:application-test.properties")
public class AddressIntegrationTest {
    private static final long CUSTOMER_ID = 1;
    private static final long STORE_ID = 1;
    private final String CREATE_CITY_SQL = "sql/create/data.sql";
    private final String DROP_DB = "sql/drop/dropdb.sql";
    private static boolean isInserted = false;

    @Autowired
    private MockMvc mvc; //create mock requests
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AddressRepository addressRepository;

    @Before
    public void testGetBeanFromConfiguration() throws SQLException {
        if(!isInserted){
            ScriptUtils.executeSqlScript(getConnection(), new ClassPathResource(CREATE_CITY_SQL));
            isInserted = true;
        }
    }

    private Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }

    @Test
    public void givenAddresses_whenGetByCustomerId_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/addresses/customer/{customerId}", CUSTOMER_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].building", is("bitecco")))
                .andExpect(jsonPath("$[0].description", is("60 floors")))
                .andExpect(jsonPath("$[0].gate", is("A")))
                .andExpect(status().isOk());
    }

    @Test
    public void givenAddresses_whenGetByStoreId_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/addresses/store/{storeId}", STORE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].building", is("bitecco")))
                .andExpect(jsonPath("$[0].description", is("60 floors")))
                .andExpect(jsonPath("$[0].gate", is("A")))
                .andExpect(status().isOk());
    }

    @Test
    public void givenAddressDTO_whenSave_thenStatus200() throws Exception {
        String requestJson = parseAddressDTOtoStringOfJsonFormat();

        mvc.perform(MockMvcRequestBuilders.post("/admin/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                )
                .andExpect(status().isOk())
                .andDo(
                        result->mvc.perform(MockMvcRequestBuilders.get("/admin/addresses/{id}",3)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.building", is("landmark")))
                )
                .andExpect(status().isOk());
    }

    private String parseAddressDTOtoStringOfJsonFormat() throws JsonProcessingException {
        AddressDTO addressDTO = AddressDTO.builder()
                .building("landmark")
                .gate("B")
                .description("new building")
                .wardId(1)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(addressDTO);
        return requestJson;
    }

}
