package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import game.Game;

public class Gui implements KeyListener{
	public Game game = new Game();
	public JFrame frame = new JFrame();
	private final int sizeOfElement = 20; //the size of an element in the window, in terms of pixels.
	public boolean gameGoing = true;
	private final BufferedImage[] images;
	
	public Gui() {
		//this array will contain the images so that the array in "Game"'s legend matches easily.
		images = new BufferedImage[7];
		try {
			images[0] = readAndScale(new File("art/gap.png"));
			images[1] = readAndScale(new File("art/wall.png"));
			images[2] = readAndScale(new File("art/35lbs.png"));
			images[3] = readAndScale(new File("art/whey.png"));
			images[4] = readAndScale(new File("art/Red_Baddie.png"));
			images[5] = readAndScale(new File("art/Pec_Man.png"));
			images[6] = images[1];
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public void initialize() {
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setTitle("Pec-Man");
	}
	
	public void drawGame() {
		if (gameGoing) {
			JPanel pane = new JPanel() {
				private static final long serialVersionUID = 1L;

				@Override
            	protected void paintComponent(Graphics g) {
                	super.paintComponent(g);
                	for (int i = 0; i < game.map.length; i++) {
                		final int yVal = i * sizeOfElement;
                		for (int j = 0; j < game.map[i].length; j++) {
                			final int xVal = j * sizeOfElement;
                			BufferedImage image = images[game.map[i][j]];
                			g.drawImage(image, xVal, yVal, null);
                		}
                	}
                	g.drawString("Score: " + game.getScore(), (game.map.length * sizeOfElement) - sizeOfElement, sizeOfElement);
            	}
        	};
        	frame.add(pane);
        	frame.repaint();
        }
	}
	
	public void drawDead() {
		JPanel pane = new JPanel() {
			private static final long serialVersionUID = -7101785437309649577L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("You are Dead", sizeOfElement, sizeOfElement);
            }
        };
        frame.dispose();
        frame = new JFrame();
        initialize();
        frame.add(pane);
        frame.repaint();
        //frame.setVisible(false);
	}
	
	public void drawWin() {
		JPanel pane = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6201607795636459535L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString("You Won", 50, 50);
            }
        };
        frame.setVisible(false);
        frame = new JFrame();
        initialize();

        frame.add(pane);
        frame.repaint();
		
	}
	
	private BufferedImage readAndScale(File f) throws IOException {
		BufferedImage b = ImageIO.read(f);
		return resize(b, sizeOfElement, sizeOfElement);
	}
	
	private BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
			case KeyEvent.VK_UP : 
				game.movePecMan(0);
				game.moveGhosts();
				//System.out.println("up");
				break;
			case KeyEvent.VK_DOWN : 
				game.movePecMan(1);
				game.moveGhosts();
				//System.out.println("down");
				break;
			case KeyEvent.VK_RIGHT : 
				game.movePecMan(2);
				game.moveGhosts();
				//System.out.println("right");
				break;
			case KeyEvent.VK_LEFT : 
				game.movePecMan(3);
				game.moveGhosts();
				//System.out.println("left");
				break;
		}
		if (game.isAWinner()) {
			//System.out.println("you win");
			gameGoing = false;
			drawWin();
		}
		if (game.isDead()) {
			//System.out.println("you ded");
			gameGoing = false;
			drawDead();
		}
		this.drawGame();
	}

	@Override
	public void keyReleased(KeyEvent e) {} 
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void dump() {
		frame.dispose();
	}
}
