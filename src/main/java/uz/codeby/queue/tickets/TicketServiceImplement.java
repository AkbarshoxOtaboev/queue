package uz.codeby.queue.tickets;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TicketServiceImplement implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Integer addTicket() {
        LocalDate today = LocalDate.now();
        Ticket ticket = ticketRepository.findByLastUpdatedDate(today);

        if (ticket == null) {
            ticket = new Ticket();
            ticket.setCurrentNumber(1);
            ticket.setLastUpdatedDate(today);
            ticketRepository.save(ticket);
        }else {
            ticket.setCurrentNumber(ticket.getCurrentNumber() + 1);
            ticketRepository.save(ticket);
        }
        return ticket.getCurrentNumber();
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void resetTicketsAtMidnight() {
        LocalDate today = LocalDate.now();
        Ticket ticket = ticketRepository.findByLastUpdatedDate(today);
        if (ticket != null) {
            ticket.setCurrentNumber(1);
            ticketRepository.save(ticket);
        }
    }
}
