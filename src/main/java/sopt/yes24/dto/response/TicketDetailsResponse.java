package sopt.yes24.dto.response;

import java.util.Arrays;
import java.util.List;

import sopt.yes24.entity.Ticket;

public record TicketDetailsResponse(
        String result,
        TicketDetails concert
) {
    public record TicketDetails(
            String concertId,
            String concertTitle,
            String concertArea,
            String concertAreaDetail,
            String concertImg,
            String concertDate,
            String concertDuration,
            String concertAge,
            String hypertext,
            String hyperlink,
            List<String> notice,
            List<String> performanceTimes,
            List<TicketPricing> ticketPricing
    ) {
        public static TicketDetails fromEntity(Ticket ticket, List<String> performanceTimes, List<TicketPricing> ticketPricing) {
            return new TicketDetails(
                    ticket.getTicketId().toString(),
                    ticket.getTitle(),
                    ticket.getAreaDetail(),
                    ticket.getArea(),
                    ticket.getImg(),
                    ticket.getDate().toString(),
                    ticket.getDuration(),
                    ticket.getAudienceRating(),
                    ticket.getHypertext(),
                    ticket.getHyperlink(),
                    Arrays.asList(ticket.getNotice().split("\n")),
                    performanceTimes,
                    ticketPricing
            );
        }
    }

    public record TicketPricing(
            String type,
            String price,
            String color
    ) {}

    public static TicketDetailsResponse of(String result, TicketDetails concert) {
        return new TicketDetailsResponse(result, concert);
    }
}
