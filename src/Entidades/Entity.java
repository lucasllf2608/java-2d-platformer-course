package Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage sprite;


    public Entity(int x, int y, int width, int height, BufferedImage sprite){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }

}
