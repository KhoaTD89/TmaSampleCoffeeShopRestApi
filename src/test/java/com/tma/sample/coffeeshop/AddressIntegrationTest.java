package com.tma.sample.coffeeshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
    @TestPropertySource("classpath:application-test.properties")
public class AddressIntegrationTest {
    private static final long CUSTOMER_ID = 1;
    private static final long STORE_ID = 1;

    @Autowired
    private MockMvc mvc; //create mock requests
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AddressRepository addressRepository;

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
