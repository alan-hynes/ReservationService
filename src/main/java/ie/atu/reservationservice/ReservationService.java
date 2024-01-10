package ie.atu.reservationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CustomerServiceClient customerServiceClient;
    private final NotificationServiceClient notificationServiceClient;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              CustomerServiceClient customerServiceClient,
                              NotificationServiceClient notificationServiceClient) {
        this.reservationRepository = reservationRepository;
        this.customerServiceClient = customerServiceClient;
        this.notificationServiceClient = notificationServiceClient;
    }

    public ReservationDetails createReservation(ReservationDetails details) {
        CustomerDetails customer = customerServiceClient.getCustomer(details.getCustomerId());
        if (customer == null) {
            throw new IllegalArgumentException("Invalid customer ID");
        }
        ReservationDetails savedReservation = reservationRepository.save(details);

        NotificationRequest notificationRequest = new NotificationRequest(customer.getEmail(), "Reservation confirmed");
        notificationServiceClient.sendNotification(notificationRequest);

        return savedReservation;
    }



    public boolean validateReservationDetails(ReservationDetails details) {
        // validation logic
        return true; // Or false based on the validation
    }
}
