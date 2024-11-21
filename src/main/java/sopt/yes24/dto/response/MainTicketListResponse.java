package sopt.yes24.dto.response;

import java.util.List;

public record MainTicketListResponse(String result, List<MainTicketResponse> datas) {
    public static MainTicketListResponse of (String result, List<MainTicketResponse> datas) {
        return new MainTicketListResponse(result, datas);
    }
}
