package graficos;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

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

	public Game(){
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
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

	}

	public void tick() {

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

}
