package sopt.yes24.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sopt.yes24.dto.request.SeatAvailabilityRequest;
import sopt.yes24.dto.response.PerformaceDateListResponse;
import sopt.yes24.dto.response.SeatAvailabilityListResponse;
import sopt.yes24.dto.response.SeatAvailabilityListResponse.TimeSlotResponse;
import sopt.yes24.service.PerformanceService;
import sopt.yes24.service.PerformanceServiceIF;

public class PerformanceController {
    private final PerformanceServiceIF performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping("/tickets/availableDate/{ticket_id}")
    public ResponseEntity<PerformaceDateListResponse> getAvailableDatesByTicketId(@PathVariable("ticket_id") Long ticketId) {
        List<String> availableDates = performanceService.getAvailableDatesByTicketId(ticketId);
        return ResponseEntity.ok(PerformaceDateListResponse.of("Success", ticketId.toString(), availableDates));
    }

    @PostMapping("/tickets/availableTimeSlots")
    public ResponseEntity<SeatAvailabilityListResponse> getAvailableSeats(@RequestBody SeatAvailabilityRequest seatAvailabilityRequest) {
        Long concertId = Long.parseLong(seatAvailabilityRequest.concert_id());
        List<TimeSlotResponse> availableSeats = performanceService.getAvailableSeats(concertId, LocalDate.parse(seatAvailabilityRequest.performance_time()));
        return ResponseEntity.ok(SeatAvailabilityListResponse.of("Success", seatAvailabilityRequest.concert_id(), availableSeats));
    }
}
