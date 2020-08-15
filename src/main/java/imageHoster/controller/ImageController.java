package imageHoster.controller;

import imageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;
    @RequestMapping("/images")
    public String getAllImagePosts(Model model){

        model.addAttribute("images",imageService.getAllImages());
        return "images";
    }
}
