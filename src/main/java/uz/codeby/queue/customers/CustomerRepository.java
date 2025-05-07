package uz.codeby.queue.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query(value = "select " +
            "(select COUNT(*) from _customers where log_status = 0) as statusOne, " +
            "(select COUNT(*) from _customers where log_status = 1) as statusTwo, " +
            "(select COUNT(*) from _customers where log_status = 2) as statusThree, " +
            "(select COUNT(*) from _customers where status = 0) as statusFour",
            nativeQuery = true)
    List<Object[]> countsStudentStatusRaw();
}
