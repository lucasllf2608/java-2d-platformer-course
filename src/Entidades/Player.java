package Entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity{


	public boolean right, left, up, down;
	public double speed = 1.0;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if(right)
			x+=speed;
		if(left)
			x-=speed;
		if(up)
			y-=speed;
		if(down)
			y+=speed;
	}

	public void render(Graphics g) {
		super.render(g);
	}

}
