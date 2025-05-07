package uz.codeby.queue.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.codeby.queue.user.UserService;

import java.util.Map;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final UserService userService;
    @GetMapping("/queue")
    public String customers(Model model) {
        var user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }
    @PostMapping("/customers/{id}/update-log-status")
    @ResponseBody
    public ResponseEntity<?> updateLogStatus(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        int logStatus = body.get("logStatus");
        Customers customer = customerService.findById(id);
        customer.setLogStatus(logStatus);
        customerRepository.save(customer);
        return ResponseEntity.ok().build();
    }

}
