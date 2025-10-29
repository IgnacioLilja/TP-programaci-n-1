package juego;

import java.awt.Color;

import entorno.Entorno;

public class Menu {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	
	public Menu(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void dibujar(Entorno e, int zombiesEliminados, int tiempoSegundos, Plantas planta, boolean olantaDisponible) {
		e.dibujarRectangulo(x, y, ancho, alto, 0, new java.awt.Color(200, 200, 200));	
		e.dibujarRectangulo(x - ancho/2 + 170, y- 500, 180, 25, 0, new Color(80, 80, 80));
		e.escribirTexto("Zombies: " + zombiesEliminados, x - ancho/2 + 470, y - 10);
		e.dibujarRectangulo(x - ancho/2 + 460, y - 500, 150, 25, 0, new Color(80, 80, 80));
		e.escribirTexto("Tiempo: " + tiempoSegundos + " s", x - ancho/2 + 470, y + 10);
		e.dibujarRectangulo(x - 520, y, 120, 120, 0, new Color(50,80,120));		
		planta.dibujarPlanta(e);
	}
	
	
	
	
}
