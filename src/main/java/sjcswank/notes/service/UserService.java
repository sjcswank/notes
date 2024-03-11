package sjcswank.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjcswank.notes.model.User;
import sjcswank.notes.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> singleUser(String username) {

        return userRepository.findByUsername(username);
    }

    public User createUser(String username, String password) {
        return userRepository.insert(new User(username, password));
    }
}
