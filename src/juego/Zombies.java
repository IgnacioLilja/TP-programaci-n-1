package juego;

import java.awt.Color;

import entorno.Entorno;

public class Zombies {
	private int x;
	private int y;
	private int ancho;
	private int alto;
		
		Zombies(int x, int y, int ancho, int alto){
			this.x=x;
			this.y=y;
			this.ancho=ancho;
			this.alto=alto;

		}
		public void dibujarPlanta(Entorno e) {
			e.dibujarRectangulo(x, y, ancho, alto, 0, Color.BLACK);	
		}
			
}
