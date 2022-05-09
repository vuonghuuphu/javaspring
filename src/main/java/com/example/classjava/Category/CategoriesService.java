package com.example.classjava.Category;

import com.example.classjava.Class.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }

    public Optional<Category> findById(int id) {
        return categoriesRepository.findById(id);
    }

    public Category save(Category category) {
        return categoriesRepository.save(category);
    }

    public void deleteById(int id) {categoriesRepository.deleteById(id); }


}

