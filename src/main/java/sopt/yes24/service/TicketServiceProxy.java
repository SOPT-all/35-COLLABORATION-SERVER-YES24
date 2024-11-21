package sopt.yes24.service;

import sopt.yes24.dto.response.*;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketLikeResponse.TicketLikeData;

import java.util.List;

public class TicketServiceProxy implements TicketServiceIF{
    @Override
    public List<HotTicketResponse> getHotTickets() {
        return List.of();
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
    public List<TicketListResponse> getTicketList(String sortBy) {
        return List.of();
    }

    @Override
    public TicketDetails getTicketDetails(Long ticketId) {
        return null;
    }

    @Override
    public TicketLikeData likeTicket(Long ticketId) {
        return null;
    }
}
