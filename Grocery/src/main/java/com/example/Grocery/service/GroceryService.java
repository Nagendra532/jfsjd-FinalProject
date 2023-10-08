package com.example.Grocery.service;

import java.util.List;

import com.example.Grocery.entity.Grocery;

public interface GroceryService {
    List<Grocery> getAllGroceries();
    Grocery getGroceryById(Long id);
    Grocery createGrocery(Grocery grocery);
    Grocery updateGrocery(Long id, Grocery grocery);
    void deleteGrocery(Long id);
}
