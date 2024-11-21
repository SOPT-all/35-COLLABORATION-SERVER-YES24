package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record MainTicketResponse(Long ticketId, String title, String area, String img) {
    public static MainTicketResponse fromEntity(Ticket ticket) {
        return new MainTicketResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getArea(),
                ticket.getImg()
                );
    }
}
