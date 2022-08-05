package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.SitesRepository;

@Controller
public class CategoryController {

    private CategoryRepository categoriesRepo;
    private SitesRepository sitesRepo;

    public CategoryController(CategoryRepository categoriesRepo, SitesRepository sitesRepo) {
        this.categoriesRepo = categoriesRepo;
        this.sitesRepo = sitesRepo;
    }

    @RequestMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("categories",categoriesRepo.findAll());
        return "categoriesTemplate";
    }

    @RequestMapping("/categories/{id}")
    public String showSingleCategory(Model model, @PathVariable long id) {
        model.addAttribute("category", categoriesRepo.findById(id).get());
        model.addAttribute("categories", categoriesRepo.findAll());
        return "categoryTemplate";
    }

    }

