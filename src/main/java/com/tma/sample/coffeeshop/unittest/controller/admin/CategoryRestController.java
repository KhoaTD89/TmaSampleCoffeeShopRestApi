package com.tma.sample.coffeeshop.unittest.controller.admin;

import com.tma.sample.coffeeshop.model.Category;
import com.tma.sample.coffeeshop.unittest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAll();
    }

    @PostMapping
    public Category addCategory(@RequestBody String name){
        return categoryService.add(name);
    }

    @PutMapping ("/{categoryId}")
    public Category editCategory(@RequestBody String name, @PathVariable long categoryId){
        return categoryService.edit(categoryId,name);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable long categoryId){
         categoryService.delete(categoryId);
    }
}
