package uz.codeby.queue;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import uz.codeby.queue.customers.CustomerService;
import uz.codeby.queue.customers.Customers;
import uz.codeby.queue.user.UserService;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class DashboardController {
    private final UserService userService;
    private final CustomerService customerService;
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("customer", new Customers());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        var user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Dashboard");
        return "dashboard";
    }
    @GetMapping("/dashboard/users")
    public String users(Model model) {
        var user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Users");
        return "users";
    }

    @PostMapping("/create/queue")
    public ResponseEntity<Customers> createQueue(@RequestParam("name")String name) {
        Customers customers = customerService.save(name);
        return ResponseEntity.ok(customers);
    }
}
