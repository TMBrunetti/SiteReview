package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancoeit.reviews.repos.ReviewRepository;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewRepository reviewRepo;

    public ReviewController(ReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @RequestMapping("/")
    public String showAllReviews(Model model) {
        model.addAttribute("reviews", reviewRepo.findAll());
        return "allReviews";
    }
}
