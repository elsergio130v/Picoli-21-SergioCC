package modelo.estado;

import java.util.ArrayDeque;
import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de los trabajadores y parados
//porque se encarga de contratar y despedir
public class MinisterioIndustria {
	private ArrayDeque<Adulto> trabajadores = new ArrayDeque<Adulto>();
	private ArrayList<Ser> andresito = new ArrayList<Ser>();
	
	public void envejecer() {
		//	TODO	
		//no le entra nada por que tenemos en esta clase la lista de los trabajadores.
	}
	public void contratar(ArrayList<Ser> trabajadores, ArrayList<Ser> parados) {
		//		TODO
//		teneis los metodos para la lista de parados y el de trabajadores esta hecho,
//		por si lo necesitamos en otra clase o en el propio estado.
	}
	public long getSizeTrabajadores() {
		return (long)this.trabajadores.size();
	}
	private ArrayDeque<Adulto> getListaParados() {	
		MinisterioSocial social = new MinisterioSocial();
		return social.getListaParados();
	}
	
	public ArrayDeque<Adulto> getListaTrabajadores(){
		return this.trabajadores;
	}
	

}
