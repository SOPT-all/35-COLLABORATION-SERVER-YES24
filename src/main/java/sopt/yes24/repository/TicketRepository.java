package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // comment 값이 null이 아닌 티켓만 조회
    List<Ticket> findByCommentIsNotNull();

    // 인기순: 좋아요 순으로 정렬
    List<Ticket> findAllByOrderByNumberOfLikesDesc();

    // 평점순
    List<Ticket> findAllByOrderByRatingDesc();

    // 리뷰 많은 순
    List<Ticket> findAllByOrderByNumberOfReviewsDesc();

    // 종료 임박순
    List<Ticket> findAllByOrderByDateAsc();

    // comment가 없고 area가 있는 데이터만 조회
    List<Ticket> findByCommentIsNullAndAreaIsNotNull();
}
