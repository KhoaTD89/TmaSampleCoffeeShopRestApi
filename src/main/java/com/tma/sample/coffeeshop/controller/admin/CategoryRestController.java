package com.tma.sample.coffeeshop.controller.admin;

import com.tma.sample.coffeeshop.model.Category;
import com.tma.sample.coffeeshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping ("/category")
    public Category add(@RequestBody String name){
        return categoryService.add(name);
    }

    @PutMapping ("/category/{id}")
    public Category add(@RequestBody String name, @PathVariable long id){
        return categoryService.edit(id,name);
    }

    @DeleteMapping("/category/{id}")
    public boolean delete(@PathVariable long id){
        return categoryService.delete(id);
    }
}
