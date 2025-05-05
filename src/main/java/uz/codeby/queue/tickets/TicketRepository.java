package uz.codeby.queue.tickets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findByLastUpdatedDate(LocalDate lastUpdatedDate);
}
