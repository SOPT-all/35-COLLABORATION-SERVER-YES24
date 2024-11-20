package sopt.yes24.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.yes24.dto.response.HotTicketListResponse;
import sopt.yes24.dto.response.HotTicketResponse;
import sopt.yes24.service.TicketService;

import java.util.List;

@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets/hot")
    public ResponseEntity<HotTicketListResponse> getHotTickets() {
        List<HotTicketResponse> tickets = ticketService.getHotTickets();
        return ResponseEntity.ok(HotTicketListResponse.of("Success", tickets));
    }
}
