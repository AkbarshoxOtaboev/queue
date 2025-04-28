package uz.codeby.queue.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User fetchUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    @Override
    public void save(User user) {
        user.setStatus(1);
        userRepository.save(user);
    }

    @Override
    public void delete(String username, Integer status) {
        User user = fetchUserByUsername(username);
        user.setStatus(status.equals(1) ? 0 : 1);
        userRepository.save(user);
    }

    @Override
    public boolean existsUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return fetchUserByUsername(username);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::fetchUserByUsername;
    }


}
