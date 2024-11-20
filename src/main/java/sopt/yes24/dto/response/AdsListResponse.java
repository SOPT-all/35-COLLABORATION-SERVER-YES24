package sopt.yes24.dto.response;

import java.util.List;

public record AdsListResponse (String result, List<AdsResponse> ads) {
    public static AdsListResponse of(String result, List<AdsResponse> ads) {
        return new AdsListResponse(result, ads);
    }
}
