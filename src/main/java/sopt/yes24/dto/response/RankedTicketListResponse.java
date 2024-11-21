package sopt.yes24.dto.response;

import java.util.List;

public record RankedTicketListResponse(String result, List<RankedTicketResponse> ranking) {
    public static RankedTicketListResponse of(String result, List<RankedTicketResponse> ranking) {
        return new RankedTicketListResponse(result, ranking);
    }

}
