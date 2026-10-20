package Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity{

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {

	}

	public void render(Graphics g) {
		super.render(g);
	}

}
