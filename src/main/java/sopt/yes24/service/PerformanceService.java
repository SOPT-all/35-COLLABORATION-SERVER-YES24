package sopt.yes24.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import sopt.yes24.entity.Performance;
import sopt.yes24.repository.PerformanceRepository;

@Service
public class PerformanceService implements PerformanceServiceIF {
    
    private final PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    @Override
    public List<String> getAvailableDates() {
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableDates'");
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
    public List<String> getAvailableSeats(Long ticketId, LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvailableSeats'");
    }
    
}
