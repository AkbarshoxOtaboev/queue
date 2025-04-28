package uz.codeby.queue.customers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.codeby.queue.user.UserService;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final UserService userService;
    @GetMapping("/queue")
    public String customers(Model model) {
        var user = userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }
}
