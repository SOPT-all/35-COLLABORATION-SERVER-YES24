package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record HotTicketResponse (
        Long ticketId, String title, String area, String date, String comment, String img
){
    public static HotTicketResponse fromEntity(Ticket ticket) {
        String formattedDate = ticket.getDate().toString();

        return new HotTicketResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getArea(),
                formattedDate,
                ticket.getComment(),
                ticket.getImg()
        );
    }
}
