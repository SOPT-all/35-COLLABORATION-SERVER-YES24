package sopt.yes24.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sopt.yes24.dto.response.*;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketLikeResponse.TicketLikeData;
import sopt.yes24.service.FileStorageService;
import sopt.yes24.service.TicketService;

import java.io.IOException;
import java.util.List;

@RestController
public class TicketController {
    private final TicketService ticketService;
    private final FileStorageService fileStorageService;

    @Value("${server.url}")
    private String serverUrl;

    public TicketController(TicketService ticketService, FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
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
    public ResponseEntity<ConcertListResponse> getTicketList(
            @RequestParam(value = "sortBy", required = false, defaultValue = "random") String sortBy) {
        List<ConcertResponse> tickets = ticketService.getTicketList(sortBy);
        return ResponseEntity.ok(ConcertListResponse.of("Success", tickets));
    }

    @PatchMapping("/tickets/like/{ticket_id}")
    public ResponseEntity<TicketLikeResponse> likeTicket(@PathVariable("ticket_id") Long ticketId) {
        TicketLikeData ticketLikeData = ticketService.likeTicket(ticketId);
        return ResponseEntity.ok(TicketLikeResponse.of("Success", ticketLikeData));  
    }

    @PostMapping("/tickets/upload")
    public ResponseEntity<String> uploadTicketImage(@RequestParam("file") MultipartFile file) {
        try {
            // Ticket 이미지 처리 및 저장
            String fileUrl = ticketService.saveTicketImg(file, serverUrl);
            return ResponseEntity.ok("티켓 이미지 업로드 성공: " + fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("티켓 이미지 업로드 실패: " + e.getMessage());
        }
    }
}
