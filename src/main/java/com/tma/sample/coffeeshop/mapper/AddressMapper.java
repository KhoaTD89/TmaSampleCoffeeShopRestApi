package com.tma.sample.coffeeshop.mapper;

import com.tma.sample.coffeeshop.dto.AddressDTO;
import com.tma.sample.coffeeshop.dto.AddressViewDTO;
import com.tma.sample.coffeeshop.dto.StoreDTO;
import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.Store;
import com.tma.sample.coffeeshop.model.Ward;
import com.tma.sample.coffeeshop.repository.WardReposiroty;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public static AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);

    @Autowired
    private WardReposiroty wardReposiroty;


    @Mapping(target = "id",source = "address.id")
    @Mapping(target = "description",source = "address.description")
    @Mapping(target = "building",source = "address.building")
    @Mapping(target = "gate",source = "address.gate")
    @Mapping(target = "ward",source = "address.ward.name")
    @Mapping(target = "district",source = "address.ward.district.name")
    @Mapping(target = "city",source = "address.ward.district.city.name")
    public abstract AddressViewDTO map(Address address);

    @Mapping(target = "description",source = "addressDTO.description")
    @Mapping(target = "building",source = "addressDTO.building")
    @Mapping(target = "gate",source = "addressDTO.gate")
    public abstract Address map(AddressDTO addressDTO);
    @AfterMapping
    void after(@MappingTarget Address target, AddressDTO src){
        Ward ward = wardReposiroty.findById(src.getWardId()).orElse(null);
        target.setWard(ward);
    }


}
