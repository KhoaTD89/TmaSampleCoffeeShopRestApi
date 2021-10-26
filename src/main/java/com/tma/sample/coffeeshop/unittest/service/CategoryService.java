package com.tma.sample.coffeeshop.unittest.service;

import com.tma.sample.coffeeshop.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category add(String name);

    Category edit(long id, String name);

    void delete(long id);
}
