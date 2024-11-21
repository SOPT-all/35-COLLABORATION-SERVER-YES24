package sopt.yes24.dto.response;

import java.util.List;

public record PerformaceDateListResponse(
        String result,
        String concert_id,
        List<String> performance_times
) {
    public static PerformaceDateListResponse of(String result, String concert_id, List<String> performance_times) {
        return new PerformaceDateListResponse(result, concert_id, performance_times);
    }
}
