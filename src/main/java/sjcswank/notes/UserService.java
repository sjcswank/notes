package sjcswank.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> singleUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(String username) {
        return userRepository.insert(new User(username));
    }
}
