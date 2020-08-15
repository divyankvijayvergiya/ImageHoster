package imageHoster.controller;

import imageHoster.model.User;
import imageHoster.model.UserProfile;
import imageHoster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user) {
        //Complete this method
        //Call the business logic which currently does not store the details of the user in the database
        //After registration, again redirect to the registration page
        return "redirect:/users/login";
    }

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user){
        if(userService.login(user)){
            return "redirect:/images";
        } else {
            return "users/login";
        }
    }


}
