package sopt.yes24.dto.response;

public record ConcertResponse (
        Long concert_id,
        String concert_title,
        String concert_date,
        String concert_area,
        String concert_img){

}
