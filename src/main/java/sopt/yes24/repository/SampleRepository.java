package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.yes24.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
