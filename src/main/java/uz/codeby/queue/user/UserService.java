package uz.codeby.queue.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers();
    User fetchUserByUsername(String username);
    void save(User user);
    void delete(String username, Integer status);
    boolean existsUserByUsername(String username);
    User getCurrentUser();
    UserDetailsService userDetailsService();
}
