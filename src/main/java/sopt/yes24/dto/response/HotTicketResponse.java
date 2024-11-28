package sopt.yes24.dto.response;

import sopt.yes24.entity.Ticket;

public record HotTicketResponse (
        Long ticket_id,
        String ticket_title,
        String ticket_area, 
        String ticket_date,
        String comment,
        String img_url
){
}
