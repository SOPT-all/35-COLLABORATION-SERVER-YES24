package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record MainTicketResponse(
        Long ticketId,
        String title,
        String area,
        String img,
        String period) {
}
