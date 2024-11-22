package sopt.yes24.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sopt.yes24.dto.response.AdsListResponse;
import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.service.AdsService;
import sopt.yes24.service.FileStorageService;

import java.io.IOException;
import java.util.List;

@RestController
public class AdsController {
    private final AdsService adsService;
    private final FileStorageService fileStorageService;

    @Value("${server.url}")
    private String serverUrl;

    public AdsController(AdsService adsService, FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
        this.adsService = adsService;
    }

    @GetMapping("/ads")
    public ResponseEntity<AdsListResponse> getAds() {
        List<AdsResponse> ads = adsService.getAdsImgList();
        return ResponseEntity.ok(AdsListResponse.of("Success", ads));
    }

    @PostMapping("/ads/upload")
    public ResponseEntity<String> uploadAdImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = adsService.saveAdImg(file, serverUrl);
            return ResponseEntity.ok("광고 이미지 업로드 성공 : " + fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("광고 이미지 업로드 실패: " + e.getMessage());
        }
    }
}
