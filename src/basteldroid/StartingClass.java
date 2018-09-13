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
	private Image image, currentSprite, character, characterDown, characterJumped, background, heliboy;
	private URL base;
	private Graphics second;
	private static Background bg1, bg2;
	private Heliboy hb, hb2;
	
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
	    character = getImage(base, "data\\character.png");
	    characterDown = getImage(base, "data\\down.png");
	    characterJumped = getImage(base, "data\\jumped.png");
	    currentSprite = character;
	    background = getImage(base, "data\\background.png");
	    heliboy = getImage(base, "data\\heliboy.png");
	}

	@Override
	public void start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(2160, 0);
		robot = new Robot();
		hb = new Heliboy(340, 360);
		hb2 = new Heliboy(700, 360);
		
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
			 bg1.update();
			 bg2.update();
			 robot.update();
			 hb.update();
			 hb2.update();
			 if (robot.isJumped()){
					currentSprite = characterJumped;
				}else if (robot.isJumped() == false && robot.isDucked() == false){
					currentSprite = character;
				}
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
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
		g.drawImage(currentSprite, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
		g.drawImage(heliboy, hb.getCenterX() - 48, hb.getCenterY() - 48, this);
		g.drawImage(heliboy, hb2.getCenterX() - 48, hb2.getCenterY() - 48, this);
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
			   currentSprite = characterDown;
	            if (robot.isJumped() == false){
	                robot.setDucked(true);
	                robot.setSpeedX(0);
	            }
		   break;

		   case KeyEvent.VK_LEFT:
			   robot.moveLeft();
			   robot.setMovingLeft(true);
		   break;

		   case KeyEvent.VK_RIGHT:
			   robot.moveRight();
			   robot.setMovingRight(true);
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
			   currentSprite = character;
	            robot.setDucked(false);
		      break;

		   case KeyEvent.VK_LEFT:
			   robot.stopLeft();
		      break;

		   case KeyEvent.VK_RIGHT:
			   robot.stopRight();
		      break;
		      
		   case KeyEvent.VK_SPACE:
			  break;

		   }
	}

	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}


}
