package com.example.Grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Grocery.Repository.GroceryRepository;
import com.example.Grocery.entity.Grocery;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    private GroceryRepository groceryRepository;

    @Override
    public List<Grocery> getAllGroceries() {
        return groceryRepository.findAll();
    }

    @Override
    public Grocery getGroceryById(Long id) {
        Optional<Grocery> optionalGrocery = groceryRepository.findById(id);
        return optionalGrocery.orElse(null);
    }

    @Override
    public Grocery createGrocery(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    @Override
    public Grocery updateGrocery(Long id, Grocery updatedGrocery) {
        if (!groceryRepository.existsById(id)) {
            return null;
        }
        updatedGrocery.setId(id);
        return groceryRepository.save(updatedGrocery);
    }

    @Override
    public void deleteGrocery(Long id) {
        groceryRepository.deleteById(id);
    }
}
