package sopt.yes24.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import sopt.yes24.dto.response.SeatAvailabilityListResponse.RemainingSeatsResponse;
import sopt.yes24.dto.response.SeatAvailabilityListResponse.TimeSlotResponse;
import sopt.yes24.entity.Performance;
import sopt.yes24.entity.SeatAvailability;
import sopt.yes24.repository.PerformanceRepository;
import sopt.yes24.repository.SeatAvailabilityRepository;

@Service
public class PerformanceService implements PerformanceServiceIF {
    
    private final PerformanceRepository performanceRepository;
    private final SeatAvailabilityRepository seatAvailabilityRepository;

    public PerformanceService(PerformanceRepository performanceRepository, SeatAvailabilityRepository seatAvailabilityRepository) {
        this.performanceRepository = performanceRepository;
        this.seatAvailabilityRepository = seatAvailabilityRepository;
    }

    @Override
    public List<String> getAvailableDatesByTicketId(Long ticketId) {
        List<Performance> performances = performanceRepository.findByTicket_TicketId(ticketId);
        return performances.stream()
            .map(Performance::getViewingTime)
            .map(date -> date.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    @Override
    public List<TimeSlotResponse> getAvailableSeats(Long ticketId, LocalDate date) {
        List<Performance> performances = performanceRepository.findByTicket_TicketId(ticketId);
        Performance performance = performances.stream()
            .filter(p -> p.getViewingTime().toLocalDate().equals(date))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No performance found for given date"));

        List<SeatAvailability> seatAvailabilities = seatAvailabilityRepository.findByPerformance(performance);
        List<RemainingSeatsResponse> remainingSeatsResponses = new ArrayList<>();
        for (SeatAvailability seatAvailability : seatAvailabilities) {
            String type = seatAvailability.getSeatType();
            String remaining = seatAvailability.getTotalSeats().toString();
            RemainingSeatsResponse remainingSeatsResponse = RemainingSeatsResponse.of(type, remaining);
            remainingSeatsResponses.add(remainingSeatsResponse);
        }
        String amPm = performance.getViewingTime().getHour() < 12 ? "오전" : "오후";
        String performanceTime = amPm + " " + performance.getViewingTime().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm"));
        TimeSlotResponse timeSlotResponse = TimeSlotResponse.of(performanceTime, remainingSeatsResponses);
        return List.of(timeSlotResponse);
    }
    
}
