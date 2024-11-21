package sopt.yes24.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sopt.yes24.dto.response.PerformaceDateListResponse;
import sopt.yes24.service.PerformanceService;
import sopt.yes24.service.PerformanceServiceIF;

public class PerformanceController {
    private final PerformanceServiceIF performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    public List<String> getAvailableDates() {
        return null;
    }

    @GetMapping("/tickets/availableDate/{ticket_id}")
    public ResponseEntity<PerformaceDateListResponse> getAvailableDatesByTicketId(@PathVariable("ticket_id") Long ticketId) {
        List<String> availableDates = performanceService.getAvailableDatesByTicketId(ticketId);
        return ResponseEntity.ok(PerformaceDateListResponse.of("Success", ticketId.toString(), availableDates));
    }

    public List<String> getAvailableSeats(Long ticketId, LocalDate date) {
        return null;
    }
}
