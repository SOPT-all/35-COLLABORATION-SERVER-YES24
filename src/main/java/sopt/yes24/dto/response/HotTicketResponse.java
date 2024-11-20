package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record HotTicketResponse (
        Long ticket_id, String title, String area, String date, String comment, String img
){
    public static HotTicketResponse fromEntity(Ticket ticket) {
        String formattedDate = ticket.getDate().toString();

        return new HotTicketResponse(
                ticket.ticket_id(),
                ticket.getTitle(),
                ticket.getArea(),
                formattedDate,
                ticket.getComment(),
                ticket.getImg()
        );
    }
}
