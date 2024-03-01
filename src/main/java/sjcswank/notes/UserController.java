package sjcswank.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String username) {
        return new ResponseEntity<Optional<User>>(userService.singleUser(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<User>(userService.createUser(payload.get("username")), HttpStatus.CREATED);
    }
}
