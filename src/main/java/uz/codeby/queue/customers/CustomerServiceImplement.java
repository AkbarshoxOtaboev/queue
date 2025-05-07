package uz.codeby.queue.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.codeby.queue.tickets.TicketService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplement implements CustomerService {
    private final CustomerRepository customerRepository;
    private final TicketService ticketService;

    @Override
    public void create(Customers customers) {
        customers.setTicket(ticketService.addTicket());
        customerRepository.save(customers);
    }

    @Override
    public List<Customers> findAll() {
        return customerRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }


    @Override
    public Customers save(String name) {
        Customers customers = new Customers();
        customers.setStatus(1);
        customers.setLogStatus(0);
        customers.setName(name);
        customers.setTicket(ticketService.addTicket());
        customerRepository.save(customers);
        return customers;
    }

    @Override
    public Customers findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }


}
