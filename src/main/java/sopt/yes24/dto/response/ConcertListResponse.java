package sopt.yes24.dto.response;

import java.util.List;

public record ConcertListResponse (String result, List<ConcertResponse> concerts){
    public static ConcertListResponse of (String result, List<ConcertResponse> concerts) {
        return new ConcertListResponse(result, concerts);

    }
}
