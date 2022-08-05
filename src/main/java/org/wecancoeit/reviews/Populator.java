package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Category;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.model.Sites;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;
import org.wecancoeit.reviews.repos.SitesRepository;

@Component
public class Populator implements CommandLineRunner {

    private HashtagRepository hashtagRepo;
    private SitesRepository sitesRepo;
    private ReviewRepository reviewRepo;
    private CategoryRepository categoriesRepo;

    public Populator(HashtagRepository hashtagRepo, SitesRepository sitesRepo, ReviewRepository reviewRepo, CategoryRepository categoriesRepo) {
        this.hashtagRepo = hashtagRepo;
        this.sitesRepo = sitesRepo;
        this.reviewRepo = reviewRepo;
        this.categoriesRepo = categoriesRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Category paid = new Category("Paid");
        categoriesRepo.save(paid);
        Category unpaid = new Category("unPaid");
        categoriesRepo.save(unpaid);

        Hashtag hashtag1 = new Hashtag("#bingeable");
        hashtagRepo.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("#RIPOFF");
        hashtagRepo.save(hashtag2);
        Hashtag hashtag3 = new Hashtag("#bestMovies");
        hashtagRepo.save(hashtag3);
        Hashtag hashtag4 = new Hashtag("#bestShows");
        hashtagRepo.save(hashtag4);
        Hashtag hashtag5 = new Hashtag("#WorthIT");
        hashtagRepo.save(hashtag5);


        Sites hbo = new Sites("HBO","https://hbomax-images.warnermediacdn.com/2020-05/square%20social%20logo%20400%20x%20400_0.png",
                "hbo logo","http://www.hbo.com",paid,hashtag1,hashtag2,hashtag3);
        sitesRepo.save(hbo);

        Sites hulu = new Sites("Hulu", "https://riddleandbloom.com/wp-content/uploads/2020/05/hulu0-square.jpg",
                "hulu logo","https://www.hulu.com/welcome",paid,hashtag1,hashtag4,hashtag5);
        sitesRepo.save(hulu);

        Sites netflix = new Sites("Netflix", "https://cdn.vox-cdn.com/thumbor/Yq1Vd39jCBGpTUKHUhEx5FfxvmM=/39x0:3111x2048/1200x800/filters:focal(39x0:3111x2048)/cdn.vox-cdn.com/uploads/chorus_image/image/49901753/netflixlogo.0.0.png",
                "netflix logo","https://www.netflix.com/",paid,hashtag2);
        sitesRepo.save(netflix);

        Sites paramount = new Sites("Paramount", "https://ca-times.brightspotcdn.com/dims4/default/1629592/2147483647/strip/true/crop/3300x2550+0+0/resize/840x649!/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F0e%2Ffc%2Fcca99a12483eae714f5f2e7667ca%2Fparamount-plus-logo.jpg",
                "parramount logo","https://www.paramount.com/",paid,hashtag5);
        sitesRepo.save(paramount);

        Sites crackle = new Sites("Crackle","https://gobrolly.com/wp-content/uploads/2018/09/sony-crackle-logo-300x300.png",
                "crackle logo","http://www.crackle.com",unpaid,hashtag1,hashtag4);
        sitesRepo.save(crackle);

        Sites roku = new Sites("Roku","https://image.roku.com/bWFya2V0aW5n/logo-therokuchannel.jpg",
                "roku logo","https://www.therokuchannel.roku.com/",unpaid,hashtag1,hashtag2,hashtag5);
        sitesRepo.save(roku);

        Sites tubi = new Sites("TubiTv","https://cdn.adrise.tv/tubitv-assets/img/tubi_open-graph-512x512.png",
                "tubi logo","https://www.tubitv.com/",unpaid);
        sitesRepo.save(tubi);

        Sites youtube = new Sites("Youtube","https://static.vecteezy.com/system/resources/previews/003/399/771/original/youtube-icon-editorial-free-vector.jpg",
                "youtube logo", "https://www.youtube.com",unpaid,hashtag3);
        sitesRepo.save(youtube);

        Review review1 = new Review("review1",hbo);
        reviewRepo.save(review1);

    }

}
