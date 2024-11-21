package sopt.yes24.service;

import java.time.LocalDate;
import java.util.List;


public interface PerformanceServiceIF {
    public List<String> getAvailableDates();

    public List<String> getAvailableDatesByTicketId(Long ticketId);

    public List<String> getAvailableSeats(Long ticketId, LocalDate date);

}
