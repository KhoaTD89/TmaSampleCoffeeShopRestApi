package com.tma.sample.coffeeshop.mapper;

import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Store;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

// @Mapper(componentModel = "spring", imports = Store.class)
@org.mapstruct.Mapper(componentModel = "spring", imports = Store.class)
public abstract class StoreMapper {
    public static StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
    public final String HH_MM = "hh:mm";

    @Mapping(target = "name", source = "storeDTO.name")
    @Mapping(target = "description", source = "storeDTO.description")
    @Mapping(target = "closeTime", source = "storeDTO.closeTime", dateFormat = HH_MM)
    @Mapping(target = "openTime", source = "storeDTO.openTime", dateFormat = HH_MM)
    @Mapping(target = "phone", source = "storeDTO.phone")
    @Mapping(target = "imagePath", source = "storeDTO.imagePath")
    public abstract Store map(StoreDTO storeDTO);

    @Mapping(target = "name", source = "store.name")
    @Mapping(target = "description", source = "store.description")
    @Mapping(target = "closeTime", source = "store.closeTime", dateFormat = HH_MM)
    @Mapping(target = "openTime", source = "store.openTime", dateFormat = HH_MM)
    @Mapping(target = "phone", source = "store.phone")
    @Mapping(target = "imagePath", source = "store.imagePath")
    public abstract StoreDTO map(Store store);
    @AfterMapping
    void after(@MappingTarget StoreDTO target, Store src) {
        AddressViewDTO addressViewDTO = AddressViewDTO.builder()
                .description(src.getAddress().getDescription())
                .building(src.getAddress().getBuilding())
                .gate(src.getAddress().getGate())
                .ward(src.getAddress().getWard().getName())
                .district(src.getAddress().getWard().getDistrict().getName())
                .city(src.getAddress().getWard().getDistrict().getCity().getName())
                .build();
        target.setAddressViewDTO(addressViewDTO);
    }

}
