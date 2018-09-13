package basteldroid;

import java.awt.Graphics;

public class Robot {
	 	//Variablen welche nur in einer Klasse benötigt werden, sollten Privat sein
		//So können nur die dazugehörigen Methoden diese ändern.
		final int JUMPSPEED = -15;
		final int MOVESPEED = 5;
		final int GROUND = 382;
	
		private int centerX = 100;
		private int centerY = GROUND;
		private boolean jumped = false;
		private boolean movingLeft = false;
	    private boolean movingRight = false;
	    private boolean ducked = false;
	    
	    	private static Background bg1 = StartingClass.getBg1();                 
	    	private static Background bg2 = StartingClass.getBg2();

		private int speedX = 0;
		private int speedY = 1;

		public void update() {

			// Bewegt den Roboter oder passt den Hintergrund an.
			 if (speedX < 0) {
		            centerX += speedX;
		        }
		        if (speedX == 0 || speedX < 0) {
		            bg1.setSpeedX(0);
		            bg2.setSpeedX(0);

		        }
		        if (centerX <= 200 && speedX > 0) {
		            centerX += speedX;
		        }
		        if (speedX > 0 && centerX > 200){
		            bg1.setSpeedX(-MOVESPEED);
		            bg2.setSpeedX(-MOVESPEED);
		        }

			// Update der Y Position

		        centerY += speedY;
		        if (centerY + speedY >= GROUND) {
		            centerY = GROUND;
		        }

			// Hier wird das Springen kontrolliert
		        if (jumped == true) {
		            speedY += 1;

		            if (centerY + speedY >= GROUND) {
		                centerY = GROUND;
		                speedY = 0;
		                jumped = false;
		            }

		        }

			// Verhindert das unsere Spielfigur einen gewissen Punkt
			// in X Richtung überschreitet
			if (centerX + speedX <= 60) { 
			// falls bei addieren von speedX centerX auf kleiner als 60 fällt, 
		        // ist speedX = 61
				centerX = 61;
			}
		}

		public void moveRight() {
			if (ducked == false) {
	            speedX = MOVESPEED;
	        }
		}

		public void moveLeft() {
			if (ducked == false) {
	            speedX = -MOVESPEED;
	        }
		}

		public void stop() {
			if (isMovingRight() == false && isMovingLeft() == false) {
	            speedX = 0;
	        }

	        if (isMovingRight() == false && isMovingLeft() == true) {
	            moveLeft();
	        }

	        if (isMovingRight() == true && isMovingLeft() == false) {
	            moveRight();
	        }

	    }
		
		public void stopRight() {
	        setMovingRight(false);
	        stop();
	    }

	    public void stopLeft() {
	        setMovingLeft(false);
	        stop();
	    }

		public void jump() {
			if (jumped == false) {
	            speedY = JUMPSPEED;
	            jumped = true;
	        }

		}

		public int getJUMPSPEED() {
			return JUMPSPEED;
		}

		public int getMOVESPEED() {
			return MOVESPEED;
		}

		public int getGROUND() {
			return GROUND;
		}

		public int getCenterX() {
			return centerX;
		}

		public int getCenterY() {
			return centerY;
		}

		public boolean isJumped() {
			return jumped;
		}

		public boolean isMovingLeft() {
			return movingLeft;
		}

		public boolean isMovingRight() {
			return movingRight;
		}

		public boolean isDucked() {
			return ducked;
		}

		public static Background getBg1() {
			return bg1;
		}

		public static Background getBg2() {
			return bg2;
		}

		public int getSpeedX() {
			return speedX;
		}

		public int getSpeedY() {
			return speedY;
		}

		public void setCenterX(int centerX) {
			this.centerX = centerX;
		}

		public void setCenterY(int centerY) {
			this.centerY = centerY;
		}

		public void setJumped(boolean jumped) {
			this.jumped = jumped;
		}

		public void setMovingLeft(boolean movingLeft) {
			this.movingLeft = movingLeft;
		}

		public void setMovingRight(boolean movingRight) {
			this.movingRight = movingRight;
		}

		public void setDucked(boolean ducked) {
			this.ducked = ducked;
		}

		public static void setBg1(Background bg1) {
			Robot.bg1 = bg1;
		}

		public static void setBg2(Background bg2) {
			Robot.bg2 = bg2;
		}

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}
		
}
