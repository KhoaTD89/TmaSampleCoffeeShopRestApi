package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.mapper.AddressMapper;
import com.tma.sample.coffeeshop.mapper.AddressMapperImpl;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import com.tma.sample.coffeeshop.repository.WardReposiroty;
import com.tma.sample.coffeeshop.service.AddressService;
import com.tma.sample.coffeeshop.service.AddressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RunWith(SpringRunner.class)
public class AddressServiceTest {

//    public final int ADDRESS_QTY = 10;
//    public final int CUSTOMER_ID = 99;
//    public final int STORE_ID = 99;
//    private final long ADDRESS_ID = 99;
//    public final String DESC = "HCM";
//    List<AddressViewDTO> addressesOfCustomer;
//    AddressViewDTO addressViewDTO;
//    AddressDTO addressDTO;
//    Address address;
//    boolean editStatus;
//
//    //config bean for these tests
//    //SpringbootTest loads all bean --> slower than @TestConfiguration
//    @TestConfiguration
//    public static class AddressServiceTestConfiguration {
//        AddressMapper addressMapper = new AddressMapperImpl();
//        @Bean
//        AddressService addressService() {
//            return new AddressServiceImpl(addressMapper);
//        }
//    }
//
//    @Autowired
//    AddressService addressService; //this bean is config from @TestConfiguration method
//
//    @MockBean
//    AddressRepository addressRepository;//mock object
//    @MockBean
//    WardReposiroty wardReposiroty;//mock object
//
//    @Before
//    public void setup() {
//        List<Address> collect = LongStream.range(0, ADDRESS_QTY).mapToObj(i -> new Address(i))
//                .collect(Collectors.toList());
//        //scenario when mock object is called
//        Mockito.when(addressRepository.findByCustomerId(CUSTOMER_ID))
//                .thenReturn(collect);
//        Mockito.when(addressRepository.findByStoreId(STORE_ID))
//                .thenReturn(collect);
//        Mockito.when(addressRepository.findById(ADDRESS_ID))
//                .thenReturn(Optional.of(Address.builder().description(DESC).build()));
//    }
//
//    @Test
//    public void findAddressByCustomerIdTest() {
//        when:
//        findAddressByCustomer(CUSTOMER_ID);
//        then:
//        verifyQtyIsPositiveNumber();
//    }
//
//    @Test
//    public void findAddressByStoreIdTest() {
//        when:
//        findAddressByStoreId(STORE_ID);
//        then:
//        verifyQtyIsPositiveNumber();
//    }
//
//    @Test
//    public void getOneAddressByIdTest() {
//        when:
//        findAddressById(ADDRESS_ID);
//        then:
//        verifyDescriptionIsMatched();
//    }
//
//    @Test
//    public void saveAddressTest() {
//        given:
//        setupAddressDTO();
//        when:
//        saveAddress();
//        then:
//        verifySavedAddressIsSameAsAddressDTO();
//    }
//
//    @Test
//    public void editAddressTest() {
//        given:
//        setupAddressDTO();
//        when:
//        editAddress();
//        then:
//        verifyEditStatusIsTrue();
//    }
//
//    //sub processes which is used in @com.tma.sample.test method
//    public void findAddressByCustomer(long customerId) {
//        addressesOfCustomer = addressService.getAllAddressesOfCustomer(customerId);
//    }
//
//    public void findAddressByStoreId(long storeId) {
//        addressesOfCustomer = addressService.getAllAddressesOfStore(storeId);
//    }
//
//    public void findAddressById(long addressId) {
//        addressViewDTO = addressService.getOne(addressId);
//    }
//
//    public void verifyQtyIsPositiveNumber() {
//        Assertions.assertEquals(addressesOfCustomer.size(), ADDRESS_QTY);
//    }
//
//    public void verifyDescriptionIsMatched() {
//        Assertions.assertEquals(addressViewDTO.getDescription(), DESC);
//    }
//
//    public void setupAddressDTO() {
//        addressDTO = AddressDTO.builder()
//                .building("ABC")
//                .gate("1")
//                .description("new building")
//                .build();
//    }
//
//    public void saveAddress() {
//        address = addressService.save(addressDTO);
//    }
//
//    public void verifySavedAddressIsSameAsAddressDTO() {
//        Assertions.assertEquals(address.getBuilding(), addressDTO.getBuilding());
//        Assertions.assertEquals(address.getGate(), addressDTO.getGate());
//        Assertions.assertEquals(address.getDescription(), addressDTO.getDescription());
//    }
//    public void editAddress() {
//        editStatus = addressService.edit(ADDRESS_ID, addressDTO);
//    }
//    public void verifyEditStatusIsTrue(){
//        Assertions.assertTrue(editStatus);
//    }

}
