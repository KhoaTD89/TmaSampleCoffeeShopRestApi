package com.tma.sample.coffeeshop.service;

import com.tma.sample.coffeeshop.model.Category;
import com.tma.sample.coffeeshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category add(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category edit(long id, String name) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category==null){
            throw new NullPointerException("category is not found");
        }else{
            category.setName(name);
            return category;
        }
    }

    @Override
    public boolean delete(long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category==null){
            throw new NullPointerException("category is not found");
        }else{
            categoryRepository.delete(category);
            return true;
        }

    }
}
