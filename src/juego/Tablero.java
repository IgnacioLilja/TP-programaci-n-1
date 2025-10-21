package juego;
import java.awt.Color;
import entorno.Entorno;

public class Tablero {
		private int filas;
		private int columnas;
		private int anchoTotal;
		private int altoTotal;
		private int inicioX;
		private int inicioY;
		private int borde;
		
		public Tablero(int filas, int columnas, int anchoTotal, int altoTotal, int inicioX, int inicioY, int borde) {
			this.filas = filas;
			this.columnas = columnas;
			this.anchoTotal = anchoTotal;
			this.altoTotal = altoTotal;
			this.inicioX = inicioX;
			this.inicioY = inicioY;
			this.borde = borde;
		}
		
		public void dibujarTablero(Entorno e) {
			int anchoCelda = anchoTotal/ columnas;
			int altoCelda = altoTotal/ filas;
			
			for(int fila=0; fila < filas; fila++) {
				for(int columna=0;columna<columnas;columna++) {
					
					int x = inicioX + columna * anchoCelda + anchoCelda/2;
					int y = inicioY + fila * altoCelda + altoCelda/2;
					
					e.dibujarRectangulo((double)x, (double)y,(double) anchoCelda,(double) altoCelda, 0.0, Color.WHITE);
					
					e.dibujarRectangulo((double)x, (double)y,(double) anchoCelda-2*borde,(double) altoCelda-2*borde, 0.0, Color.RED);

				}
			}
		}
	}
	
	


