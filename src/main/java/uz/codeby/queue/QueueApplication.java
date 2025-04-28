package uz.codeby.queue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import uz.codeby.queue.user.Role;
import uz.codeby.queue.user.User;
import uz.codeby.queue.user.UserService;

@SpringBootApplication
public class QueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueueApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, PasswordEncoder passwordEncoder) {
        if(!userService.existsUserByUsername("admin")) {
            return args -> {
                var admin = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .fullName("SUPER ADMIN")
                        .role(Role.ADMIN)
                        .status(1)
                        .build();
                userService.save(admin);
            };
        }else {
            return args -> {};
        }
    }

}
