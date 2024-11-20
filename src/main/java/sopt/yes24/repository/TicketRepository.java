package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.yes24.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
