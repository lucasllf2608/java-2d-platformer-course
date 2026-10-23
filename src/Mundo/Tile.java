package Mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Tile {
    public static BufferedImage chao = Game.spritesheet.getSprite(16, 0, 16, 16);
    public static BufferedImage chaoGRAMA = Game.spritesheet.getSprite(0, 0, 16, 16);
    public static BufferedImage grama = chaoGRAMA;
    public static BufferedImage empty = Game.spritesheet.getSprite(16, 32, 16, 16);

    public int x, y;
    public BufferedImage sprite;

    public Tile(int x, int y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }   

    public void render(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }
}
