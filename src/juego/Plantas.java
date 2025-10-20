package juego;

import java.awt.Color;

import entorno.Entorno;

public class Plantas {
		private int x;
		private int y;
		private int diametro;
		private Color color;
		
		Plantas(int x, int y, int d, Color c){
			this.x=x;
			this.y=y;
			this.diametro=d;
			this.color=c;
		}

		public void dibujar(Entorno e) {
			e.dibujarCirculo(x, y, diametro, color);
		}
		public boolean colisionaConEntornoPorAbajo(Entorno e){
			return this.y-this.diametro/2 > e.alto();
		}
		
		public boolean mouseSobreLaBarra(int mouseX, int mouseY) {
			int bordeIzquierdo=this.x - (this.diametro/2);
			int bordeDerecho=this.x + (this.diametro/2);
			int bordeSuperior=this.y - (this.diametro/2);
			int bordeInferior=this.y + (this.diametro/2);
			
			if(mouseX >= bordeIzquierdo && mouseX<=bordeDerecho &&
					mouseY >= bordeSuperior && mouseY<= bordeInferior) {
				return true;
			}
			else {
				return false;			
			}
		}

		public void moverAbajo() {
			this.y=this.y+1;
		}
		
		public int getX() {		
			return this.x;
		}
		
		public void setX(int valor) {
			if(valor>=0) {
				this.x=valor;			
			}
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getDiametro() {
			return diametro;
		}

		public void setDiametro(int diametro) {
			this.diametro = diametro;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
		
}
