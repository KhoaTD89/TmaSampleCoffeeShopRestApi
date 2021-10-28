package com.tma.sample.coffeeshop;

import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class AddressRepositoryTest {
//
//    @Autowired
//    AddressRepository addressRepository;
//
//    //    @Autowired
////    JdbcTemplate jdbcTemplate;
////    private static boolean isInserted = false;
////    private final String CREATE_CITY_SQL = "sql/create/data.sql";
////    @Before
////    public void testGetBeanFromConfiguration() throws SQLException {
////        if(!isInserted){
////            ScriptUtils.executeSqlScript(getConnection(), new ClassPathResource(CREATE_CITY_SQL));
////            isInserted = true;
////        }
////    }
////    private Connection getConnection() throws SQLException {
////        return jdbcTemplate.getDataSource().getConnection();
////    }
//
//    @Test
//    public void givenCustomerId_thenReturnListAddresses() {
//        List<Address> byCustomerId = addressRepository.findByCustomerId(1);
//        Assert.assertEquals(byCustomerId.get(0).getBuilding(), "bitecco");
//    }
//
//    @Test
//    public void givenStoreId_thenReturnListAddresses() {
//        List<Address> byCustomerId = addressRepository.findByCustomerId(1);
//        Assert.assertEquals(byCustomerId.get(0).getBuilding(), "bitecco");
//    }
//

}
