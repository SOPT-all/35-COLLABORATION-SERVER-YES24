package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

import java.util.Date;

public record ConcertResponse (Long concert_id, String concert_title, String concert_date, String concert_area, String concert_img){

    public static ConcertResponse fromEntity(Ticket ticket) {
        String formattedDate = ticket.getDate() != null ? ticket.getDate().toString() : "N/A";

        return new ConcertResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                formattedDate,
                ticket.getArea(),
                ticket.getImg()
        );
    }
}
