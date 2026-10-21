package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Entidades.Entity;
import Entidades.Player;
import graficos.Spritesheet;

public class Game extends Canvas implements Runnable, KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703857005506331083L;
	public static JFrame jframe;
	private static Thread gameThread;
	private boolean isRunning = true;

	
	private static int WIDTH = 160;
	private static int HEIGHT = 160;
	private static int SCALE = 3;

	private BufferedImage fundo;
	public List<Entity> entities = new ArrayList<>();
	public static Spritesheet spritesheet;
	public Player player;

	public Game(){
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		fundo = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		// Aula: fundo preto no buffer. Depois descomente para usar a imagem.
		// try {
		// 	fundo = ImageIO.read(new File("res/fundo.jpg"));
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }

    entities = new ArrayList<>();
	spritesheet = new Spritesheet("/res/spriteSheet-course.png");
	player = new Player(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
	entities.add(player);

	}

	public void initFrame(){
	jframe = new JFrame("JOGO");
		jframe.add(this);
		jframe.setResizable(false);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	public synchronized void start() {
		gameThread = new Thread(this);
		isRunning = true;
		gameThread.start();	
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void tick() {
		for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.tick();
		}
	}

	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = fundo.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

        for(int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.render(g);
		}
		g.dispose();
		
		g = buffer.getDrawGraphics();
		g.drawImage(fundo, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.dispose();
		buffer.show();

		
		/*
		Graphics g = this.getGraphics();
		g.drawImage(fundo, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.dispose();
		*/
	}

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();

		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if(delta > 1){
				tick();
				render();
				frames++;
				delta--;
			}

			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
		stop();
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W){
			player.up= true;
		} else if(e.getKeyCode() == KeyEvent.VK_A){
			player.left= true;
		} else if(e.getKeyCode() == KeyEvent.VK_S){
			player.down= true;
		} else if(e.getKeyCode() == KeyEvent.VK_D){
			player.right= true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_W){
			player.up= false;
		} else if(e.getKeyCode() == KeyEvent.VK_A){
			player.left= false;
		} else if(e.getKeyCode() == KeyEvent.VK_S){
			player.down= false;
		} else if(e.getKeyCode() == KeyEvent.VK_D){
			player.right= false;
		}
		
	}

}
