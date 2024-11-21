package sopt.yes24.dto.response;

import sopt.yes24.entity.Ads;

public record AdsResponse (Long ads_id, String ads_img){
    public static AdsResponse fromEntity(Ads ads) {
        return new AdsResponse(ads.getAdsId(), ads.getAdsImg());
    }
}
