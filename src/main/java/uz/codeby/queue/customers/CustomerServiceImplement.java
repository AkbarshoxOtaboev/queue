package uz.codeby.queue.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public void create(Customers customers) {
        customers.setTicket(15);
        customerRepository.save(customers);
    }

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }
}
