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
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
