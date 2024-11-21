package sopt.yes24.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Performance;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    List<Performance> findByTicket_TicketId(Long ticketId);
}
