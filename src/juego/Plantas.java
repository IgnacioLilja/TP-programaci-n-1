package juego;

import java.awt.Color;

import entorno.Entorno;

public class Plantas {
	private int x;
	private int y;
	private int ancho;
	private int alto;
		
		Plantas(int x, int y, int ancho, int alto){
			this.x=x;
			this.y=y;
			this.ancho=ancho;
			this.alto=alto;
		}

		public void dibujarPlanta(Entorno e) {
			e.dibujarRectangulo(x, y, ancho, alto, 0, Color.GREEN);	
		}
		public boolean colisionaConZombie(Zombies p) {
			if(p==null) {
				return false;
			}
			int bordeIzquierdo=this.x - (this.ancho/2);
			int bordeDerecho=this.x + (this.ancho/2);
			int bordeSuperior=this.y - (this.alto/2);
			int bordeInferior=this.y + (this.alto/2);		
			
			int xCercano=Math.max(bordeIzquierdo, Math.min(bordeDerecho,p.getX()));
			int yCercano=Math.max(bordeSuperior, Math.min(bordeInferior,p.getY()));
			
			int difX=xCercano-p.getX();
			int difY=yCercano-p.getY();
			int distancia=(int) Math.sqrt((difX*difX)+(difY*difY));
			
			if(distancia<=p.getAncho()/2) {
				return true;
			}else {
				return false;
			}			
		}
		
		public boolean mouseSobrePlanta(int mouseX, int mouseY) {
			int bordeIzquierdo=this.x - (this.ancho/2);
			int bordeDerecho=this.x + (this.ancho/2);
			int bordeSuperior=this.y - (this.alto/2);
			int bordeInferior=this.y + (this.alto/2);
			
			if(mouseX >= bordeIzquierdo && mouseX<=bordeDerecho &&
					mouseY >= bordeSuperior && mouseY<= bordeInferior) {
				return true;
			}
			else {
				return false;			
			}
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
