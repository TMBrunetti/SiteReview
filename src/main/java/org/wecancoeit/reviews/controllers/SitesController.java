package org.wecancoeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.model.Sites;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;
import org.wecancoeit.reviews.repos.SitesRepository;

import java.util.Optional;

@Controller
@RequestMapping("/sites")
public class SitesController {

    private SitesRepository sitesRepo;
    private HashtagRepository hashtagRepo;
    private ReviewRepository reviewRepo;
    private CategoryRepository categoryRepo;

    public SitesController(SitesRepository sitesRepo, HashtagRepository hashtagRepo, ReviewRepository reviewRepo, CategoryRepository categoryRepo) {
        this.sitesRepo = sitesRepo;
        this.hashtagRepo = hashtagRepo;
        this.reviewRepo = reviewRepo;
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("/")
    public String showAllSites(Model model) {
        model.addAttribute("sites", sitesRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        return "allSites";
    }

    @RequestMapping("/{id}")
    public String showSite(Model model, @PathVariable Long id) {
        model.addAttribute("site", sitesRepo.findById(id).get());
        model.addAttribute("categories", categoryRepo.findAll());
        return "site";
    }

    @PostMapping("/{id}/addHashtag")
    public String addHashtagToSite(@PathVariable Long id, @RequestParam String hashtag) {
        Sites site = sitesRepo.findById(id).get();
        if (hashtag.charAt(0)!='#') {
            hashtag = "#"+hashtag;
        }
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByNameIgnoreCase(hashtag);
        if(hashtagOptional.isPresent()) {
            if(!site.getHashtags().contains(hashtagOptional.get())) {
                site.addHashtag(hashtagOptional.get());
            }
        } else {
            Hashtag hashtag15 = new Hashtag(hashtag);
            hashtagRepo.save(hashtag15);
            site.addHashtag(hashtag15);
        }
        sitesRepo.save(site);
        return "redirect:/sites/"+id;
    }

    @PostMapping("/{id}/addReview")
    public String addReviewToSite(@PathVariable Long id, @RequestParam String review) {
        Sites site = sitesRepo.findById(id).get();
        Optional<Review> reviewOptional = reviewRepo.findByNameIgnoreCase(review);
        if(reviewOptional.isPresent()) {
            if(!site.getReviews().contains(reviewOptional.get())) {
                site.addReview(reviewOptional.get());
            }
        } else {
            Review review1 = new Review(review, site);
            reviewRepo.save(review1);
            site.addReview(review1);
        }
        sitesRepo.save(site);
        return "redirect:/sites/"+id;
    }

}
