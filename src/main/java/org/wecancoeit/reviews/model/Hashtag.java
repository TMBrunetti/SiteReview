package org.wecancoeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany (mappedBy = "hashtags")
    private Collection<Sites> sites;

    public Hashtag(String name, Sites...sites) {
        this.name = name;
        this.sites = Arrays.asList(sites);
    }

    public Hashtag() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Sites> getSites() {
        return sites;
    }
}
