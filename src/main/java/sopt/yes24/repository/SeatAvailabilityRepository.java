package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.yes24.entity.SeatAvailability;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailability, Long> {
}
