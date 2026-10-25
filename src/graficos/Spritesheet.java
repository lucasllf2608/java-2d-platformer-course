package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mundo.Camera;

public class Spritesheet {

    public BufferedImage spritSheet;

    public Spritesheet(String path){
        try {
            spritSheet = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int width, int height){
        return spritSheet.getSubimage(x-Camera.x, y-Camera.y, width, height);
    }
}
