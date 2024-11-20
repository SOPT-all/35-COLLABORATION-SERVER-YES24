package sopt.yes24.dto.response;

import java.util.List;

public record HotTicketListResponse (String result, List<HotTicketResponse> datas){
    public static HotTicketListResponse of(String result, List<HotTicketResponse> datas) {
        return new HotTicketListResponse(result, datas);
    }
}
