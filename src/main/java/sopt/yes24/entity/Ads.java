package sopt.yes24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ads")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ads_id")
    private Long adsId;

    @Column(name = "ads_img")
    private String adsImg;

    public Ads() {

    }

    public Ads(final Long adsId, final String adsImg) {
        this.adsId = adsId;
        this.adsImg = adsImg;
    }

    public Ads(final String adsImg) {
        this.adsImg = adsImg;
    }

    public Long getAdsId() {
        return adsId;
    }

    public String getAdsImg() {
        return adsImg;
    }
    public void setAdsImg(String adsImg) {
        this.adsImg = adsImg;
    }
}
