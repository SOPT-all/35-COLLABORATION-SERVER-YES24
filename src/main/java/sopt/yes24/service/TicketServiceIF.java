package sopt.yes24.service;

import sopt.yes24.dto.response.HotTicketResponse;
import sopt.yes24.dto.response.MainTicketResponse;
import sopt.yes24.dto.response.RankedTicketResponse;
import sopt.yes24.dto.response.TicketListResponse;
import sopt.yes24.dto.response.TicketDetailsResponse.TicketDetails;
import sopt.yes24.dto.response.TicketLikeResponse.TicketLikeData;

import java.util.List;

public interface TicketServiceIF {
    public List<HotTicketResponse> getHotTickets();
    public List<MainTicketResponse> getMainTickets();
    public List<RankedTicketResponse> getRankedTickets();
    public List<TicketListResponse> getTicketList(String sortBy);
    public TicketDetails getTicketDetails(Long ticketId);
    public TicketLikeData likeTicket(Long ticketId);
}