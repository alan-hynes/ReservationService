package ie.atu.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ReservationDetails createReservation(ReservationDetails details) {
        validateReservationDetails(details);
        ReservationDetails savedReservation = reservationRepository.save(details);
        return savedReservation;
    }

    // need to methods eg. cancelReservation

    public boolean validateReservationDetails(ReservationDetails details) {
        // validation logic
        return true; // Or false based on the validation
    }
}
