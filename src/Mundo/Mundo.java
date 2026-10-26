package Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entidades.Entity;
import main.Game;

public class Mundo {

    public int WIDTH, HEIGHT;
    public int playerSpawnX, playerSpawnY;
    public Tile[] tiles;
    
    public Mundo(String path){
        try {
			BufferedImage level = ImageIO.read(new File(path));
            int[] pixels = new int[level.getWidth() * level.getHeight()];
            tiles = new Tile[level.getWidth() * level.getHeight()];
            WIDTH = level.getWidth();
            HEIGHT = level.getHeight();
            level.getRGB(0, 0, level.getWidth(), level.getHeight(), pixels, 0, level.getWidth());
            
            for(int x = 0; x < level.getWidth(); x++){
               for(int y = 0; y < level.getHeight(); y++){
                int pixelAtual = pixels[x + (y * level.getWidth())];
                tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Entity.empty);
                    if(pixelAtual == 0xFFFBF236) {
                        //player
                        Game.player.setX(x*16);
                        Game.player.setY(y*16);
                    }else if(pixelAtual == 0xFF663931) {
                        //chao
                        tiles[x + (y * WIDTH)] = new Chao(x*16, y*16, Entity.chao);
                    }else if(pixelAtual == 0xFF8F974A) {
                        //chaoGrama
                        tiles[x + (y * WIDTH)] = new Chao(x*16, y*16, Entity.chaoGRAMA);
                    }else if(pixelAtual == 0xFFFFFFFF) {
                        //empty
                        tiles[x + (y * WIDTH)] = new Empty(x*16, y*16, Entity.empty);
                    }
                }
            }
            level.setRGB(0, 0, level.getWidth(), level.getHeight(), pixels, 0, level.getWidth());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void render(Graphics g) {
        int xi = Camera.x/16;
        int yi = Camera.y/16;
        int xf = xi + (Game.WIDTH/16);
        int yf = yi + (Game.HEIGHT/16);
    	for(int x = xi; x <= xf; x++) {
            for(int y = yi; y <= yf; y++) {
                  if(x < 0 || y < 0 || x >= WIDTH ||  y >= HEIGHT)  {
                    continue;
                }
                Tile tile = tiles[x + (y * WIDTH)];
                tile.render(g);
            }
        }
    }

}
