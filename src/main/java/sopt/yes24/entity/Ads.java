package sopt.yes24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ads_id;

    @Column
    private String ads_img;

    public Ads() {

    }

    public Ads(final Long ads_id, final String ads_img) {
        this.ads_id = ads_id;
        this.ads_img = ads_img;
    }

    public Long getAds_id() {
        return ads_id;
    }

    public String getAds_img() {
        return ads_img;
    }
}
