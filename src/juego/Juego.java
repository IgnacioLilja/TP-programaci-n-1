package juego;


import java.awt.Color;
import java.util.Random;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Tablero tablero;
	private Plantas planta;
	private Zombies zombie;
	// Variables y métodos propios de cada grupo
	
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 1200, 600);
		this.tablero = new Tablero(5, 10, 1200, 450, 00, 150, 2);
		this.planta = new Plantas(60,60,100,70);
		this.zombie = new Zombies(1205,195,100,70);
		// Inicializar lo que haga falta para el juego

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		tablero.dibujarTablero(entorno);
		zombie.dibujarZombie(entorno);
		zombie.moverZombie();
		
		if(planta!=null) {
			this.planta.dibujarPlanta(entorno);			
		
		if(entorno.estaPresionado(entorno.BOTON_IZQUIERDO) && planta.mouseSobrePlanta(entorno.mouseX(),entorno.mouseY())) {
			this.planta.setX(entorno.mouseX());
			this.planta.setY(entorno.mouseY());
		
		}

		if(planta.colisionaConZombie(zombie)) {
			this.planta=null;
				}
		}
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
