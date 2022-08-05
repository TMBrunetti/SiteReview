package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {

    private HashtagRepository hashtagRepo;
    private CategoryRepository categoryRepo;

    public HashtagController(HashtagRepository hashtagRepo, CategoryRepository categoryRepo) {
        this.hashtagRepo = hashtagRepo;
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("/")
    public String showAllHashTags(Model model) {
        model.addAttribute("hashtags", hashtagRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "allHashtags";
    }

    @RequestMapping("/{id}")
    public String showHashtag(Model model, @PathVariable Long id) {
        model.addAttribute("hashtag", hashtagRepo.findById(id).get());
        model.addAttribute("categories", categoryRepo.findAll());
        return "hashtag";
    }


}
