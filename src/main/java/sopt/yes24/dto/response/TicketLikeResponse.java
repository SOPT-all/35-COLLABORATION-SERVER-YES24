package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record TicketLikeResponse(String result, String concer_id, String number_of_likes, String like) {
    public record TicketLikeData(Long concert_id, int number_of_likes, boolean like) {
        public static TicketLikeData fromEntity(Ticket ticket) {
            return new TicketLikeData(ticket.getTicketId(), ticket.getNumberOfLikes(), ticket.isLikeStatus());
        }
    }

    public static TicketLikeResponse of(String result, TicketLikeData data) {
        return new TicketLikeResponse(
            result,
            String.valueOf(data.concert_id),
            String.valueOf(data.number_of_likes),
            String.valueOf(data.like)
        );
    }
}
