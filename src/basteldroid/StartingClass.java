package basteldroid;

// http://www.basteldroid.de/lektion-2-grundgerust/
import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(800, 400);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
	}

	@Override
	public void start() {
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			System.out.println("Bewege dich hoch");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Bewege dich runter");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Bewege dich links");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Bewege dich rechts");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Spring");
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			System.out.println("Stop dich zu bewegen");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Stop dich zu bewegen");
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Stop dich zu bewegen");
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Stop dich zu bewegen");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("Stop zu springen");
			break;
		}
	}

}
