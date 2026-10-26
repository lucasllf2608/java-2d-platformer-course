package Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Mundo.Camera;
import main.Game;

public class Entity {
    protected double x;
    protected double y;
    protected int width;
    protected int height;
    protected BufferedImage sprite;

    public static BufferedImage chao = Game.spritesheet.getSprite(0, 0, 16, 16);
    public static BufferedImage chaoGRAMA = Game.spritesheet.getSprite(16, 0, 16, 16);
    public static BufferedImage grama = chaoGRAMA;
    public static BufferedImage empty = Game.spritesheet.getSprite(16, 32, 16, 16);

    public Entity(int x, int y, int width, int height, BufferedImage sprite){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getSprite() {
        return sprite;
    }   

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }       



    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sprite, this.getX()-Camera.x, this.getY()-Camera.y, null);
    }

}
