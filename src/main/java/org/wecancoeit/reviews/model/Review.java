package org.wecancoeit.reviews.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    private Sites sites;

    public Review(String name, Sites sites) {
        this.name = name;
        this.sites = sites;
    }

    public Review() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Sites getSites() {
        return sites;
    }
}
