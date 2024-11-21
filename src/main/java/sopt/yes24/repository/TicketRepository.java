package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // comment 값이 null이 아닌 티켓만 조회
    List<Ticket> findByCommentIsNotNull();

    // 좋아요 순으로 상위 10개 데이터 가져오기. 단, comment 없고, area 있는 데이터 = MainTicket 즉, Concert Ticket
    @Query("SELECT t FROM Ticket t WHERE t.comment IS NULL AND t.area IS NOT NULL ORDER BY t.numberOfLikes DESC")
    List<Ticket> findTop10ConcertTicketsByLikes();

}
