package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record TicketLikeResponse(String result, String concertId, String numberOfLikes, String like) {
    public record TicketLikeData(Long concertId, int numberOfLikes, boolean like) {
        public static TicketLikeData fromEntity(Ticket ticket) {
            return new TicketLikeData(ticket.getTicketId(), ticket.getNumberOfLikes(), ticket.isLikeStatus());
        }
    }

    public static TicketLikeResponse of(String result, TicketLikeData data) {
        return new TicketLikeResponse(
            result,
            String.valueOf(data.concertId),
            String.valueOf(data.numberOfLikes),
            String.valueOf(data.like)
        );
    }
}
