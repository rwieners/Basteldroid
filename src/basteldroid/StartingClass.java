package basteldroid;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;


public class StartingClass extends Applet implements Runnable, KeyListener {

	private Robot robot;
	private Image image,character;
	private URL base;
	private Graphics second;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
	    frame.setTitle("Q-Bot Alpha");
	    try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}


		// Bildeinstellung
		character = getImage(base, "data/character.png");
	}

	@Override
	public void start() {
		robot = new Robot();
		
		// TODO Auto-generated method stub
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while (true) {
			 robot.update();
		      repaint();
		      
		         try {
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		      
		   }
		
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);

	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		   switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Bewege dich hoch");
		   break;

		   case KeyEvent.VK_DOWN:
			   System.out.println("Bewege dich runter");
		   break;

		   case KeyEvent.VK_LEFT:
			   robot.moveLeft();
		   break;

		   case KeyEvent.VK_RIGHT:
			   robot.moveRight();
		   break;

		   case KeyEvent.VK_SPACE:
			   robot.jump();
		   break;
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Stop dich zu bewegen");
		      break;

		   case KeyEvent.VK_DOWN:
			   System.out.println("Stop dich zu bewegen");
		      break;

		   case KeyEvent.VK_LEFT:
			   robot.stop();
		      break;

		   case KeyEvent.VK_RIGHT:
			   robot.stop();
		      break;
		      
		   case KeyEvent.VK_SPACE:
			   System.out.println("Stop zu springen");
		      break;

		   }
	}

}
