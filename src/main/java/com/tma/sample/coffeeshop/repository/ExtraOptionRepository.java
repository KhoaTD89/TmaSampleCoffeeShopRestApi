package com.tma.sample.coffeeshop.repository;


import com.tma.sample.coffeeshop.model.Address;
import com.tma.sample.coffeeshop.model.ExtraOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtraOptionRepository extends JpaRepository<ExtraOption,Long> {


}
