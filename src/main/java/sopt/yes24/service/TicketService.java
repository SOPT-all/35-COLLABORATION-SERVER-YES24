package sopt.yes24.service;

import org.springframework.stereotype.Service;
import sopt.yes24.dto.response.*;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketPricing;
import sopt.yes24.dto.response.TicketLikeResponse.TicketLikeData;
import sopt.yes24.entity.Performance;
import sopt.yes24.entity.Ticket;
import sopt.yes24.repository.TicketRepository;
import sopt.yes24.repository.PerformanceRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements TicketServiceIF {
    private final TicketRepository ticketRepository;
    private final PerformanceRepository performanceRepository;
    
    public TicketService(TicketRepository ticketRepository, PerformanceRepository performanceRepository) {
        this.ticketRepository = ticketRepository;
        this.performanceRepository = performanceRepository;
    }

    public List<HotTicketResponse> getHotTickets() {
        return ticketRepository.findByCommentIsNotNull()
                .stream()
                .map(HotTicketResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDetails getTicketDetails(Long ticketId) {
        List<Performance> performances = performanceRepository.findByTicket_TicketId(ticketId);
        List<String> performanceTimes = performances.stream()
                .map(performance -> performance.getViewingTime().toString())
                .sorted()
                .collect(Collectors.toList());
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        String[] ticketPricing = ticket.getTicketPricing().split("\n");
        List<TicketPricing> pricingList = new ArrayList<>();
        for (int i = 0; i < ticketPricing.length; i++) {
            String[] parts = ticketPricing[i].split(" ");
            if (parts.length >= 2) {
                    pricingList.add(new TicketPricing(
                    parts[0],  // type (e.g., "R석")
                    parts[1],  // price (e.g., "88,000원")
                    ColorMapper.getColorForSeatType(parts[0], ticketPricing.length)
                ));
            }
        }
        return TicketDetails.fromEntity(ticket, performanceTimes, pricingList);
    }

    @Override
    public List<MainTicketResponse> getMainTickets() {
        return List.of();
    }

    @Override
    public List<RankedTicketResponse> getRankedTickets() {
        return List.of();
    }

    @Override
    public List<ConcertResponse> getTicketList(String sortBy) {
        List<Ticket> tickets;

        switch (sortBy) {
            case "popular":
                tickets = ticketRepository.findAllByOrderByNumberOfLikesDesc();
                break;
            case "rating":
                tickets = ticketRepository.findAllByOrderByRatingDesc();
                break;
            case "reviews":
                tickets = ticketRepository.findAllByOrderByNumberOfReviewsDesc();
                break;
            case "ending":
                tickets = ticketRepository.findAllByOrderByDateAsc();
                break;
            case "random":
            default:
                tickets = ticketRepository.findByCommentIsNullAndAreaIsNotNull();
                Collections.shuffle(tickets);
                break;
        }

        return tickets.stream()
                .map(ConcertResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TicketLikeData likeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        if (ticket.isLikeStatus()) {
            ticket.setLikeStatus(false);
            ticket.setNumberOfLikes(ticket.getNumberOfLikes() - 1);
        } else {
            ticket.setLikeStatus(true);
            ticket.setNumberOfLikes(ticket.getNumberOfLikes() + 1);
        }
        ticketRepository.save(ticket);
        return TicketLikeData.fromEntity(ticket);
    }
}
