package uz.codeby.queue;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/create/queue")
    public String createQueue(@ModelAttribute("customers")Customers customers) {
        customerService.create(customers);
        return "redirect:/";
    }
}
