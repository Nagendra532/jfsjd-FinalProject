package com.example.Grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Grocery.entity.Grocery;
import com.example.Grocery.service.GroceryService;

import java.util.List;

@Controller
@RequestMapping("/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public String listGroceries(Model model) {
        List<Grocery> groceries = groceryService.getAllGroceries();
        model.addAttribute("groceries", groceries);
        return "list";
    }

    @GetMapping("/add")
    public String addGroceryForm(Model model) {
        model.addAttribute("grocery", new Grocery());
        return "add";
    }

    @PostMapping("/add")
    public String addGrocery(@ModelAttribute Grocery grocery) {
        groceryService.createGrocery(grocery);
        return "redirect:/groceries/";
    }

    @GetMapping("/edit/{id}")
    public String editGroceryForm(@PathVariable Long id, Model model) {
        Grocery grocery = groceryService.getGroceryById(id);
        model.addAttribute("grocery", grocery);
        return "edit";
    }

    @PostMapping("/save/{id}")
    public String editGrocery(@PathVariable Long id, @ModelAttribute Grocery updatedGrocery) {
        groceryService.updateGrocery(id, updatedGrocery);
        return "redirect:/groceries/";
    }

    @GetMapping("/delete/{id}")
    public String deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
        return "redirect:/groceries/";
    }

    @GetMapping("/search")
    public String searchGroceryForm() {
        return "search";
    }

    @GetMapping("/search-result")
    public String searchGrocery(@RequestParam Long id, Model model) {
        Grocery grocery = groceryService.getGroceryById(id);
        if (grocery != null) {
            model.addAttribute("grocery", grocery);
        } else {
            model.addAttribute("errorMessage", "Grocery not found with ID: " + id);
        }
        return "search";
    }
}
