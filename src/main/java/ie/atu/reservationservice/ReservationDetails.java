package ie.atu.reservationservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetails {
    private Long id;
    private String customerName;
    private String reservationTime;

}
