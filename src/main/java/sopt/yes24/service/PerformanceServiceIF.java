package sopt.yes24.service;

import java.time.LocalDate;
import java.util.List;

import sopt.yes24.dto.response.SeatAvailabilityListResponse.TimeSlotResponse;


public interface PerformanceServiceIF {

    public List<String> getAvailableDatesByTicketId(Long ticketId);

    public List<TimeSlotResponse> getAvailableSeats(Long ticketId, LocalDate date);

}
