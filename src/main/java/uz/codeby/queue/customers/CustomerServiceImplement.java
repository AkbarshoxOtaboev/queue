package uz.codeby.queue.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.codeby.queue.tickets.TicketService;

import java.time.LocalDate;
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
        return customerRepository.findAll();
    }


    @Override
    public Customers save(String name) {
        Customers customers = new Customers();
        customers.setName(name);
        customers.setTicket(ticketService.addTicket());
        customerRepository.save(customers);
        return customers;
    }


}
