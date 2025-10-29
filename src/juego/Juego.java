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
	private Menu menu;
	private Plantas planta;
	private Zombies[]zombie;
	private Regalos[]regalo;
	
	private int puntaje;
	private int zombiesEliminados;
	private int contador;
	private int tiempoSeg;
	private int tiempoT;
	// Variables y métodos propios de cada grupo
	
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 1200, 600);
		
		this.tablero = new Tablero(5, 10, 1200, 450, 00, 150, 2);
		
		this.menu = new Menu(600,75,1170,130);
		
		this.planta = new Plantas(80,60,100,70); 
		
		this.regalo = new Regalos[5];
		for (int i=0;i<5;i++) {
			int x = tablero.getCentroX(1);
			int y = tablero.getCentroY(i + 1);
			regalo[i] = new Regalos(x,y,60,60);
		}
		
		this.zombie = new Zombies[5];
		for(int i=0;i<zombie.length;i++) {
			int x = tablero.getCentroX(1);
			int y = tablero.getCentroY(i + 1);
			zombie[i] = new Zombies(x+1200,y,60,60);
		}
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
	public void tick() {
		tablero.dibujarTablero(entorno);
		for(int i = 0; i<regalo.length; i++) {
			regalo[i].dibujarRegalo(entorno);
		}
		if(planta != null) {
			 planta.actualizarPlanta();
			 planta.dibujarPlanta(entorno);
		}
		
		
		menu.dibujar(entorno, zombiesEliminados, tiempoSeg, planta, planta !=null && planta.plantaDisponible());
		
		for(int i = 0; i<zombie.length; i++) {
			if (zombie[i] != null) {
				zombie[i].dibujarZombie(entorno);
				zombie[i].moverZombie();
			}
		}
		tiempoT++;
		if (tiempoT % 60==0) {
			tiempoSeg++;
		}
		 
		
		if(entorno.estaPresionado(entorno.BOTON_IZQUIERDO) && planta !=null && planta.mouseSobrePlanta(entorno.mouseX(),entorno.mouseY()) && planta.plantaDisponible()) {
			this.planta.setX(entorno.mouseX());
			this.planta.setY(entorno.mouseY());  
		}
	
		if (!entorno.estaPresionado(entorno.BOTON_IZQUIERDO) && planta !=null && !planta.plantaEnCasilla()) {
	        int anchoCelda = tablero.getAnchoCelda();
	        int altoCelda = tablero.getAltoCelda();

	        int columna = (planta.getX() - tablero.getInicioX()) / anchoCelda;
	        int fila = (planta.getY() - tablero.getInicioY()) / altoCelda;

	        if (columna >= 1 && columna <= 4 && fila >= 0 && fila < 5) {
	            int centroX = tablero.getInicioX() + columna * anchoCelda + anchoCelda / 2;
	            int centroY = tablero.getInicioY() + fila * altoCelda + altoCelda / 2;
	            planta.enCasilla(centroX, centroY);
	        }	
	        if (planta !=null && planta.plantaEnCasilla() && planta.plantaDisponible()) {
	        	planta = new Plantas(80,60,100,70);
	        }
	        
		}
		
		if(planta!=null && planta.estaColocada()) {
			if(!planta.plantaDisponible()) {
				if(tiempoT%300==0) {
					this.planta = new Plantas(80,60,100,70);
				}
			}
		}
		
		
		for(int i = 0; i<zombie.length; i++) {
			if(planta.colisionaConZombie(zombie[i])) {
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
