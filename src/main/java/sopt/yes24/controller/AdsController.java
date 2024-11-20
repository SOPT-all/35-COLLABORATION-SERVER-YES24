package sopt.yes24.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.yes24.dto.response.AdsListResponse;
import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.service.AdsService;

import java.util.List;

@RestController
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/ads")
    public ResponseEntity<AdsListResponse> getAds() {
        List<AdsResponse> ads = adsService.getAdsImgList();
        return ResponseEntity.ok(AdsListResponse.of("Success", ads));
    }
}
