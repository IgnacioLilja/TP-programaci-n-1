package juego;

import java.awt.Color;

import entorno.Entorno;

public class Regalos {
	private int x;
	private int y;
	private int ancho;
	private int alto;
		

	Regalos(int x, int y, int ancho, int alto){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
	}		
	public void dibujarRegalo(Entorno e) {
		e.dibujarRectangulo(x, y, ancho, alto, 0, Color.BLUE);
	}
}
