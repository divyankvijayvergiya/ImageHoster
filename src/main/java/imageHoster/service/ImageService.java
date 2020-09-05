package imageHoster.service;

import imageHoster.HardCodedImage;
import imageHoster.model.Image;
import imageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;
    private List<Image> images = new ArrayList<>();
    private HardCodedImage hardCodedImage = new HardCodedImage();

    //A constructor which adds two hard-coded images in the list
    //Note that the imageFile contains image in Base64 format as string
    public ImageService() {

        Date date = new Date();
        images.add(new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(), date));
        images.add(new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), date));
    }

    //The method returns the list of two harc-coded images
    public List<Image> getAllImages() {
        return new ImageService().images;
    }

    //The method does not store the image in the database
    public void uploadImage(Image image) {
        image.setDate(new Date());
        imageRepository.uploadImage(image);
        System.out.println("New Image: " + image);
    }
}
