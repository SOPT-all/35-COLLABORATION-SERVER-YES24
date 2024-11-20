package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // comment 값이 null이 아닌 티켓만 조회
    List<Ticket> findByCommentIsNotNull();
}