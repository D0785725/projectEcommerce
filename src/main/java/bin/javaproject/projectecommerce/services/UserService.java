package bin.javaproject.projectecommerce.services;
import bin.javaproject.projectecommerce.entity.User;
import bin.javaproject.projectecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Helper method to find user based on Principal
//    public User findUserByPrincipal(Principal principal) {
//        String username = principal.getName();
//        Optional<User> userOptional = userRepository.findByUsername(username);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }
    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}