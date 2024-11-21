package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record ConcertResponse (Long concert_id, String concert_title, String concert_area, String concert_img){
    public static ConcertResponse fromEntity(Ticket ticket) {
        return new ConcertResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getArea(),
                ticket.getImg()
        );
    }
}
