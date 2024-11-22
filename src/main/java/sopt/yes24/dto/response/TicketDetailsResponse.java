package sopt.yes24.dto.response;

import java.util.Arrays;
import java.util.List;

import sopt.yes24.entity.Ticket;

public record TicketDetailsResponse(
        String result,
        TicketDetails concert
) {
    public record TicketDetails(
            String concert_id,
            String concert_title, 
            String concert_area,
            String concert_img,
            String concert_date,
            String concert_duration,
            String concert_age,
            String hypertext,
            String hyperlink,
            List<String> notice,
            List<String> performance_times,
            List<TicketPricing> ticket_pricing
    ) {
        public static TicketDetails fromEntity(Ticket ticket, List<String> performanceTimes, List<TicketPricing> ticketPricing) {
            return new TicketDetails(
                    ticket.getTicketId().toString(),
                    ticket.getTitle(),
                    ticket.getArea(),
                    ticket.getImg(),
                    ticket.getPeriod(),
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
