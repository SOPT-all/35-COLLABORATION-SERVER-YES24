package sopt.yes24.service;

import sopt.yes24.dto.response.*;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketLikeResponse.TicketLikeData;

import java.util.List;

public interface TicketServiceIF {
    public List<HotTicketResponse> getHotTickets();
    public List<MainTicketResponse> getMainTickets();
    public List<RankedTicketResponse> getRankedTickets();
    public List<ConcertResponse> getTicketList(String sortBy);
    public TicketDetails getTicketDetails(Long ticketId);
    public TicketLikeData likeTicket(Long ticketId);
}