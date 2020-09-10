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
        return imageRepository.getAllImages();
    }

    //The method does not store the image in the database
    public void uploadImage(Image image) {
        image.setDate(new Date());
        imageRepository.uploadImage(image);
        System.out.println("New Image: " + image);
    }


    //The method calls the getImageByTitle() method in the Repository and passes the title of the image to be fetched
    public Image getImageById(Integer id) {
        return imageRepository.getImageById(id);
    }

    //The method calls the getImage() method in the Repository and passes the id of the image to be fetched
    public Image getImage(Integer imageId) {
        return imageRepository.getImage(imageId);
    }

    //The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
    public void updateImage(Image updatedImage) {
        updatedImage.setDate(new Date());
        imageRepository.updateImage(updatedImage);
    }

    //The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
    public void deleteImage(Integer imageId) {
        imageRepository.deleteImage(imageId);
    }


}
