package imageHoster.controller;

import imageHoster.HardCodedImage;
import imageHoster.model.Image;
import imageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    private HardCodedImage hardCodedImage;

    @RequestMapping("/images")
    public String getAllImagePosts(Model model){

        model.addAttribute("images",imageService.getAllImages());
        return "images";
    }

    @RequestMapping("/images/{title}")
    public String showImage(@PathVariable("title") String title, Model model) {
        Date date = new Date();
        Image image = null;
        if (title.equals("Dr. Strange")) {
            image = new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(), "Dr. Strange has a time stone", date);
        } else if (title.equals("SpiderMan")) {
            image = new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), "Spider man dies in Infinity War", date);
        }

        model.addAttribute("image", image);
        return "images/image";
    }
}
