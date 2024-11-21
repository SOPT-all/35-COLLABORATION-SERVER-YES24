package sopt.yes24.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopt.yes24.entity.Performance;
import sopt.yes24.entity.SeatAvailability;

public interface SeatAvailabilityRepository extends JpaRepository<SeatAvailability, Long> {

    List<SeatAvailability> findByPerformance(Performance performance);
}
