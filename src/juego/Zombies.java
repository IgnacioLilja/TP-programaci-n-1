package juego;

import java.awt.Color;

import entorno.Entorno;

public class Zombies {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private double velocidad;
		
		Zombies(int x, int y, int ancho, int alto){
			this.x=x;
			this.y=y;
			this.ancho=ancho;
			this.alto=alto;
			this.velocidad = 1.5;

		}
		public void dibujarZombie(Entorno e) {
			e.dibujarRectangulo(x, y, ancho, alto, 0, Color.BLUE);	
		}
		
		public void moverZombie() {
			this.x -= velocidad;
		}
			
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getAncho() {
			return ancho;
		}

		public void setAncho(int ancho) {
			this.ancho = ancho;
		}

		public int getAlto() {
			return alto;
		}

		public void setAlto(int alto) {
			this.alto = alto;
		}
}
