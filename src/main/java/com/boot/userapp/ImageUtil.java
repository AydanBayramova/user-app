package com.boot.userapp;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageUtil {

    public static String encodeImageToBase64(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
