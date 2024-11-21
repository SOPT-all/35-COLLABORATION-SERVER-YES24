package sopt.yes24.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sopt.yes24.dto.response.HotTicketListResponse;
import sopt.yes24.dto.response.HotTicketResponse;
import sopt.yes24.dto.response.MainTicketResponse;
import sopt.yes24.dto.response.TicketDetailsResponse;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketListResponse;
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

    // 공연 상세 페이지 추가
    @GetMapping("/tickets/details/{ticket_id}")
    public ResponseEntity<TicketDetailsResponse> getTicketDetails(@PathVariable("ticket_id") Long ticketId) {
        TicketDetails ticketDetails = ticketService.getTicketDetails(ticketId);
        return ResponseEntity.ok(TicketDetailsResponse.of("Success",ticketDetails));
    }


    //todo 내가 틀만 만들어 놔썽!
    @GetMapping("/tickets/main")
    public ResponseEntity<MainTicketListResponse> getMainTickets() {
        List<MainTicketResponse> tickets = ticketService.getMainTickets();
        return ResponseEntity.ok(MainTicketListResponse.of("Success", tickets));
    }

    @GetMapping("/tickets/ranked")
    public ResponseEntity<RankedTicketListResponse> getRankedTickets() {
        List<RankedTicketResponse> tickets = ticketService.getRankedTickets();
        return ResponseEntity.ok(RankedTicketListResponse.of("Success", tickets));
    }

    @GetMapping("/tickets/list")
    public ResponseEntity<TicketListResponse> getTicketList(@RequestParam String sortBy) {
        List<TicketListResponse> tickets = ticketService.getTicketList(sortBy);
        return ResponseEntity.ok(TicketListResponse.of("Success", tickets));
    }


    @PostMapping("/tickets/like/{ticket_id}")
    public ResponseEntity<Void> likeTicket(@PathVariable("ticket_id") Long ticketId) {
        ticketService.likeTicket(ticketId);
        return ResponseEntity.ok().build();
    }
}
