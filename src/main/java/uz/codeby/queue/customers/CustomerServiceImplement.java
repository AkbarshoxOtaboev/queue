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

    @Override
    public void deleteById(Long id, Integer status) {
        Customers customers = findById(id);
        customers.setStatus(status.equals(1) ? 0 : 1);
        customers.setLogStatus(status.equals(1) ? 3 : 0);
        customerRepository.save(customers);
    }

    @Override
    public CustomerStatusDTO getCustomerStatus() {
        Object[] result = customerRepository.countsStudentStatusRaw().get(0);
        return new CustomerStatusDTO(
                ((Number) result[0]).intValue(),
                ((Number) result[1]).intValue(),
                ((Number) result[2]).intValue(),
                ((Number) result[3]).intValue()
        );
    }
}
