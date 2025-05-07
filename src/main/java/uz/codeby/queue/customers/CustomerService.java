package uz.codeby.queue.customers;

import java.util.List;

public interface CustomerService {
    void create(Customers customers);
    List<Customers> findAll();
    Customers save(String name);
    Customers findById(Long id);
}
