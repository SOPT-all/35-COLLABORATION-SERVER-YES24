package sopt.yes24.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sopt.yes24.dto.Mapper;
import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.entity.Ads;
import sopt.yes24.repository.AdsRepository;

import java.io.IOException;
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
                .map(Mapper::toAdsResponse)
                .collect(Collectors.toList());
    }

    public String saveAdImg(MultipartFile file, String serverUrl) throws IOException {
        String fileUrl = fileStorageService.storeFile(file);

        Ads ad = new Ads();
        ad.setAdsImg(serverUrl + fileUrl);
        adsRepository.save(ad);

        return serverUrl + fileUrl;
    }
}
