package sopt.yes24.service;

import org.springframework.stereotype.Service;
import sopt.yes24.dto.response.HotTicketResponse;
import sopt.yes24.repository.TicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<HotTicketResponse> getHotTickets() {
        return ticketRepository.findByCommentIsNotNull()
                .stream()
                .map(HotTicketResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
