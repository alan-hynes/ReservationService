package ie.atu.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    private final ReservationService service;

    @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @PostMapping("/reservations")
    public ReservationDetails createReservation(@RequestBody ReservationDetails details) {
        //  will add reservation creation logic after testing
        return  service.createReservation(details);
    }

    // will add other endpoints later eg. getReservation/deleteReservation

}
