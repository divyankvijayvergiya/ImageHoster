package imageHoster.service;

import imageHoster.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void registerUser(User newUser) {
        return;
    }

    public boolean login(User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

}
