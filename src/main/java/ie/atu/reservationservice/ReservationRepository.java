package ie.atu.reservationservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationDetails, Long> {
}
