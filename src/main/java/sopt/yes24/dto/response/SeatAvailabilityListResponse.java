package sopt.yes24.dto.response;

import java.util.List;

public record SeatAvailabilityListResponse(
    String result,
    String concert_id,
    List<TimeSlotResponse> data
) {
    public static SeatAvailabilityListResponse of(String result, String concertId, List<TimeSlotResponse> data) {
        return new SeatAvailabilityListResponse(result, concertId, data);
    }

    public record TimeSlotResponse(
        String performance_time,
        List<RemainingSeatsResponse> remaining_seats
    ) {
        public static TimeSlotResponse of(String performanceTime, List<RemainingSeatsResponse> remainingSeats) {
            return new TimeSlotResponse(performanceTime, remainingSeats);
        }
    }

    public record RemainingSeatsResponse(
        String type,
        String remaining
    ) {
        public static RemainingSeatsResponse of(String type, String remaining) {
            return new RemainingSeatsResponse(type, remaining);
        }
    }
}
