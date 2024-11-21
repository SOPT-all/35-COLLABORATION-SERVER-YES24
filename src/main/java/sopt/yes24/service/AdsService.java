package sopt.yes24.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.entity.Ads;
import sopt.yes24.entity.Ticket;
import sopt.yes24.repository.AdsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsService {
    private final AdsRepository adsRepository;
    private final FileStorageService fileStorageService;

    public AdsService(AdsRepository adsRepository, FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
        this.adsRepository = adsRepository;
    }

    public List<AdsResponse> getAdsImgList() {
        return adsRepository.findAll()
                .stream()
                .map(AdsResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public String saveAdImg(MultipartFile file, String serverUrl) throws IOException {
        // 파일 저장 및 URL 생성
        String fileUrl = fileStorageService.storeFile(file);

        // Ads 엔티티 생성 및 저장
        Ads ad = new Ads();
        ad.setAdsImg(serverUrl + fileUrl);
        adsRepository.save(ad);

        return serverUrl + fileUrl;
    }
}
