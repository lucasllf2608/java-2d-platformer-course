package Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Mundo {

    public int WIDTH, HEIGHT;
    public int playerSpawnX, playerSpawnY;
    public Tile[] tiles;
    
    public Mundo(String path){
        try {
			BufferedImage level = ImageIO.read(getClass().getResource(path));
            int[] pixels = new int[level.getWidth() * level.getHeight()];
            tiles = new Tile[level.getWidth() * level.getHeight()];
            WIDTH = level.getWidth();
            HEIGHT = level.getHeight();
            level.getRGB(0, 0, level.getWidth(), level.getHeight(), pixels, 0, level.getWidth());
            
            for(int x = 0; x < level.getWidth(); x++){
               for(int y = 0; y < level.getHeight(); y++){
                int pixelAtual = pixels[x + (y * level.getWidth())];
                tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Tile.empty);
                    if(pixelAtual == 0xFFFBF236) {
                        //player
                        playerSpawnX = x * 16;
                        playerSpawnY = y * 16;
                        tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Tile.empty);
                    }else if(pixelAtual == 0xFF663931) {
                        //chao
                        tiles[x + (y * WIDTH)] = new Chao(x*16, y*16, Tile.chao);
                    }else if(pixelAtual == 0xFF8F974A) {
                        //chaoGrama
                        tiles[x + (y * WIDTH)] = new Chao(x*16, y*16, Tile.chaoGRAMA);
                    }else if(pixelAtual == 0xFFEB8931) {
                        //cenoura
                        tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Tile.empty);
                    }else if(pixelAtual == 0xFFFFFFFF) {
                        //empty
                        tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Tile.empty);
                    }
                }
            }
            level.setRGB(0, 0, level.getWidth(), level.getHeight(), pixels, 0, level.getWidth());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void render(Graphics g) {
    	for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                Tile tile = tiles[x + (y * WIDTH)];
                tile.render(g);
            }
        }
    }

}
