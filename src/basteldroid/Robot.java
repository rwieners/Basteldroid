package basteldroid;

import java.awt.Graphics;

public class Robot {
	 	//Variablen welche nur in einer Klasse ben�tigt werden, sollten Privat sein
		//So k�nnen nur die dazugeh�rigen Methoden diese �ndern.
		private int centerX = 100;
		private int centerY = 382;
		private boolean jumped = false;

		private int speedX = 0;
		private int speedY = 1;

		public void update() {

			// Bewegt den Roboter oder passt den Hintergrund an.
			if (speedX < 0) {
				centerX += speedX; //Hier wird speedX zu centerX addiert
			} else if (speedX == 0) {
				System.out.println("Hintergrund nicht bewegen.");

			} else {
			  if (centerX <= 150) { //Falls centerX in den linken 150 Pixeln ist
				centerX += speedX; // �ndere centerX durch addieren von speedX
				} else {
					System.out.println("Hintergrund bewegen");
				}
			}

			// Update der Y Position

			if (centerY + speedY >= 382) {
				centerY = 382;
				// 382 bedeutet unsere Figur steht auf dem Boden
			}else{                       
			 centerY += speedY; 
		         // addiert speedY zu centerY um die neue Position zu berechnen
			  }

			// Hier wird das Springen kontrolliert
			if (jumped == true) {
				speedY += 1; // Solange die Figur in der Luft ist, addiere 1
				// Dadurch f�llt die Figur auf den Boden

				if (centerY + speedY >= 382) {
					centerY = 382;
					speedY = 0;
					jumped = false;
				}

			}

			// Verhindert das unsere Spielfigur einen gewissen Punkt
			// in X Richtung �berschreitet
			if (centerX + speedX <= 60) { 
			// falls bei addieren von speedX centerX auf kleiner als 60 f�llt, 
		        // ist speedX = 61
				centerX = 61;
			}
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

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}

		public void moveRight() {
			speedX = 6;
		}

		public void moveLeft() {
			speedX = -6;
		}

		public void stop() {
			speedX = 0;
		}

		public void jump() {
			if (jumped == false) {
				speedY = -15;
				jumped = true;
			}

		}
}