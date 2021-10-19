package com.tma.sample.coffeeshop.mapper;

import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import com.tma.sample.coffeeshop.repository.AddressRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

// @Mapper(componentModel = "spring", imports = Store.class)
@org.mapstruct.Mapper(componentModel = "spring", imports = Store.class)
public abstract class StoreMapper {

    @Autowired
    private AddressRepository addressRepository;

    public static StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    public final String HH_MM = "HH:mm";

    @Mapping(target = "name", source = "storeDTO.name")
    @Mapping(target = "description", source = "storeDTO.description")
    @Mapping(target = "openTime", source = "storeDTO.openTime", dateFormat = HH_MM)
    @Mapping(target = "closeTime", source = "storeDTO.closeTime", dateFormat = HH_MM)
    @Mapping(target = "phone", source = "storeDTO.phone")
    @Mapping(target = "imagePath", source = "storeDTO.imagePath")
    public abstract Store map(StoreDTO storeDTO);

    @Mapping(target = "id", source = "store.id")
    @Mapping(target = "name", source = "store.name")
    @Mapping(target = "description", source = "store.description")
    @Mapping(target = "closeTime", source = "store.closeTime", dateFormat = HH_MM)
    @Mapping(target = "openTime", source = "store.openTime", dateFormat = HH_MM)
    @Mapping(target = "phone", source = "store.phone")
    @Mapping(target = "imagePath", source = "store.imagePath")
    public abstract StoreDTO map(Store store);
    @AfterMapping
    void after(@MappingTarget StoreDTO target, Store src) {
        try {
            Address address = src.getAddress();
            AddressViewDTO addressViewDTO = AddressViewDTO.builder()
                    .description(address.getDescription())
                    .building(address.getBuilding())
                    .gate(address.getGate())
                    .ward(address.getWard().getName())
                    .district(address.getWard().getDistrict().getName())
                    .city(address.getWard().getDistrict().getCity().getName())
                    .build();

            target.setAddressViewDTO(addressViewDTO);
        }catch(NullPointerException e){
            throw new NullPointerException("Address not found");
        }
    }

}
