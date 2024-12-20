package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // comment 값이 null이 아닌 티켓만 조회, What's Hot 티켓
    List<Ticket> findByCommentIsNotNull();
    // comment 값이 null이고, area값이 null이 아닌 티켓만 조회, 메인티켓(콘서트티켓)
    List<Ticket> findByCommentIsNullAndAreaIsNotNull();
    // 좋아요 순으로 상위 10개 데이터 가져오기. 단, comment 없고, area 있는 데이터 = MainTicket 즉, Concert Ticket
    @Query("SELECT t FROM Ticket t WHERE t.comment IS NULL AND t.area IS NOT NULL ORDER BY t.numberOfLikes DESC")
    List<Ticket> findTop10ConcertTicketsByLikes();
    // 인기순: 좋아요 순으로 정렬
    List<Ticket> findAllByOrderByNumberOfLikesDesc();

    // 평점순
    List<Ticket> findAllByOrderByRatingDesc();

    // 리뷰 많은 순
    List<Ticket> findAllByOrderByNumberOfReviewsDesc();

    // 종료 임박순
    List<Ticket> findAllByOrderByDateAsc();
}
