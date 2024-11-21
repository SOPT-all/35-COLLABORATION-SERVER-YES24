package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record RankedTicketResponse(int rank, Long ticket_id, String img_url) {
    public static RankedTicketResponse fromEntity(Ticket ticket, int rank) {
        return new RankedTicketResponse(rank, ticket.getTicketId(), ticket.getImg());
    }
}
