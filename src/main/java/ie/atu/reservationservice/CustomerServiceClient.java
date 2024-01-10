package ie.atu.reservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8081")
public interface CustomerServiceClient {
    @GetMapping("/customers/{customerId}")
    CustomerDetails getCustomer(@PathVariable Long customerId);
}
