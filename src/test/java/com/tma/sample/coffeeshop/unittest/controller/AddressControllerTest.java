package com.tma.sample.coffeeshop.unittest.controller;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.security.repo.UserRepository;
import com.tma.sample.coffeeshop.unittest.controller.admin.AddressRestController;
import com.tma.sample.coffeeshop.unittest.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest (AddressRestController.class)// create a mock web server for controller testing. same above but with smaller scope
public class AddressControllerTest {

    //spring provide MockMvc, to create mock request to controller
    @Autowired
    private MockMvc mockMvc;
    @MockBean //a mock object
    AddressService addressService;
    @MockBean //a mock object
    UserRepository userRepository;


    public final int ADDRESS_QTY = 10;
    public final int CUSTOMER_ID = 99;
    public final int STORE_ID = 99;
    private final long ADDRESS_ID = 99;
    public final String DESC = "HCM";
    List<AddressViewDTO> addressViewDTOS;
    AddressViewDTO addressViewDTO;
    AddressDTO addressDTO;
    Address address;
    boolean editStatus;

    @Before
    public void setup(){
        addressViewDTOS = LongStream.range(0, 10)
                .mapToObj(i -> AddressViewDTO.builder().id(i).build()).collect(Collectors.toList());
    }

    @Test
    public void getAllAddressByCustomerId() throws Exception {
        //define scenario when a mock object is called
        //given: some action of mock object
        //willreturn: any mock data
        given(addressService.getAllAddressesOfCustomer(CUSTOMER_ID)).willReturn(addressViewDTOS);

        //test the controller
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/addresses/customer/"+CUSTOMER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
        ;
    }

    @Test
    public void getAllAddressByStoreId() throws Exception {
        //mock data
        given(addressService.getAllAddressesOfStore(STORE_ID)).willReturn(addressViewDTOS);

        mockMvc.perform(MockMvcRequestBuilders.get("/admin/addresses/store/"+STORE_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)))
        ;
    }

}
