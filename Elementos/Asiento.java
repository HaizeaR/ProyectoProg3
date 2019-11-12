package Elementos;

import javax.swing.ImageIcon;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.prism.Graphics;
import javax.swing.*;
import java.awt.*;
import sun.java2d.loops.DrawRect;
import sun.java2d.pipe.DrawImage;

public class Asiento {

	// Pensar si queremos código individual de asiento o
	// si queremos que la coordenada sea el código

	private int codigo;
	private int fila;
	private int columna;
	// Bloques de 10*10
	protected int tamanyo = 10; // Tamaño (ancho = alto) de la ficha

	private String nombre; // cambia en función de si está seleccionado o no

	// asiento_v --> seleccionado
	// asiento_g --> libre -- por defecto este
	// asiento_r --> ocupado

	/**
	 * Constructor de la clase Asiento
	 * 
	 * @param codigo
	 * @param fila
	 * @param columna
	 */
	public Asiento(int codigo, int fila, int columna, int tamanyo) {
		this.codigo = codigo;
		this.fila = fila;
		this.columna = columna;
		this.tamanyo = tamanyo;

	}

	// GETTERS AND SETTERS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(int tamanyo) {
		this.tamanyo = tamanyo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Asiento [Codigo=" + codigo + ", Coordenada= (" + fila + "-" + columna + ")]";
	}

	public void dibujar(Graphics g) {

		//ImageIcon icon = new ImageIcon(nombre + ".png");
		//super.paintComponent(g);
		//g.setColo
		//g.drawRect(0, 0, tamanyo, tamanyo);
		// icon.paintIcon(this, g, fila, columna);

	}

}
