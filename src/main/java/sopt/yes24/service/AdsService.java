package sopt.yes24.service;

import org.springframework.stereotype.Service;
import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.repository.AdsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsService {
    private final AdsRepository adsRepository;

    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public List<AdsResponse> getAdsImgList() {
        return adsRepository.findAll()
                .stream()
                .map(AdsResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
