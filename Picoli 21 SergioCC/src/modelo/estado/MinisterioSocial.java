package modelo.estado;

import java.util.ArrayDeque;
import java.util.ArrayList;

import modelo.ser.Adulto;
import modelo.ser.Ser;

//Se encarga de gestionar menores,ancianos y parados
// se encarga del pago de estos sectores
public class MinisterioSocial {
	ArrayList<Ser> menores = new ArrayList<Ser>(); 
	ArrayList<Ser> ancianos = new ArrayList<Ser>();
	ArrayDeque<Adulto> parados = new ArrayDeque<Adulto>();	
	
	public MinisterioSocial() {
		super();
		envejecer();
	}

	public void envejecer() {
		envejecerParados();
		envejecerMenores();
		envejecerAncianos();
	}
	public void envejecerParados() {
		if (!(this.parados.isEmpty())) {
			Ser[] arrayParados=(Ser[]) pasarArray();
			for (int i = 0; i <arrayParados.length ; i++) {
				arrayParados[i].envejecer();
			}
		}
	}
	public void envejecerMenores() {
		if (!(this.menores.isEmpty())) {
			for (int i = 0; i <this.menores.size(); i++) {
				this.menores.get(i).envejecer();
			}
		}
	}
	public void envejecerAncianos() {
		if (!(this.ancianos.isEmpty())) {
			for (int i = 0; i <this.ancianos.size(); i++) {
				this.ancianos.get(i).envejecer();
			}
		}
	}

	public long getSizeMenores() {
		
		return (long)this.menores.size();
	}
	
	public long getSizeAncianos() {
		
		return (long)this.ancianos.size();
	}
	
	public long getSizeParados() {
		
		return (long)this.parados.size();
	}
	

	public Object[] pasarArray() {
		return this.parados.toArray();
		
	}
	
	public ArrayList<Ser> getListaMenores() {
			return this.menores;
	}
	public ArrayDeque<Adulto> getListaParados() {
		return this.parados;
	}
	public ArrayList<Ser> getListaAncianos() {
		return this.ancianos;
	}

}
