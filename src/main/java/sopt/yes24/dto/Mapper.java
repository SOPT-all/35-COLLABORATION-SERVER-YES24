package sopt.yes24.dto;

import sopt.yes24.dto.response.AdsResponse;
import sopt.yes24.dto.response.ConcertResponse;
import sopt.yes24.dto.response.HotTicketResponse;
import sopt.yes24.dto.response.MainTicketResponse;
import sopt.yes24.entity.Ads;
import sopt.yes24.entity.Ticket;

public class Mapper {
    private Mapper() {

    }

    public static MainTicketResponse toMainTicketResponse(Ticket ticket) {
        return new MainTicketResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getArea(),
                ticket.getImg(),
                ticket.getPeriod()
        );
    }

    public static AdsResponse toAdsResponse(Ads ads) {
        return new AdsResponse(
                ads.getAdsId(),
                ads.getAdsImg()
        );
    }

    public static ConcertResponse toConcertResponse(Ticket ticket) {
        return new ConcertResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getDate() != null ? ticket.getDate().toString() : null,
                ticket.getArea(),
                ticket.getImg()
        );
    }

    public static HotTicketResponse toHotTicketResponse(Ticket ticket) {
        return new HotTicketResponse(
                ticket.getTicketId(),
                ticket.getTitle(),
                ticket.getArea(),
                ticket.getDate() != null ? ticket.getDate().toString() : null,
                ticket.getComment(),
                ticket.getImg()
        );
    }
}
