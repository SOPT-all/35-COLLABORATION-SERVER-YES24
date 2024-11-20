package sopt.yes24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.yes24.entity.Ads;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
}
