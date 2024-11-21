package sopt.yes24.dto.request;

public record SeatAvailabilityRequest(
    String concert_id,
    String performance_time
) {
}
