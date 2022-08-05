package org.wecancoeit.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//singlepost
@Entity
public class Sites {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imgUrl;
    private String altImgTxt;
    private String url;

    @OneToMany (mappedBy = "sites")
    private Collection<Review> reviews;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @ManyToOne
    private Category category;


    public Sites(String name, String imgUrl, String altImgTxt,
                 String url, Category category,
                 Hashtag...hashtags) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.altImgTxt = altImgTxt;
        this.url = url;
        this.category = category;
        this.reviews = new ArrayList<>();
        this.hashtags = Arrays.asList(hashtags);
    }

    public Sites() {
    }
    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    public void addReview(Review review) {reviews.add(review);
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getAltImgTxt() {
        return altImgTxt;
    }

    public String getUrl() {
        return url;
    }

    public Category getCategory() {
        return category;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }
}
