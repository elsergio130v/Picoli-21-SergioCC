package general;

import java.util.Observable;
import java.util.Observer;

import utiles.Utiles;

public class Ser {
	private static final int vidaMax = 120;
	private static final int vidaMin = 0;
	private MyObservable aAdultos = new MyObservable();
	private MyObservable aAnciano = new MyObservable();
	private MyObservable obsDropSaving = new MyObservable();
	protected float esperanzaVida;
	protected int edad;
	public Comportamiento comportamiento;

	public Ser() {
		super();
		esperanzaVida = calculaEsperanzaVida(vidaMin, vidaMax);
		comportamiento = new Menor();
	}

	public boolean isAlive() {
		return this.edad <= this.esperanzaVida;
	}

	public boolean envejecer() {
		this.edad++;
		if (pasaAAdulto()) {
			// TODO hay que comprobar la viabilidad del menor
						//TODO
			//si el menor no alcanza el 55% del factor desarrollo
			//no se le considera viable y ese ser muere
			if (!((Menor) this.comportamiento).viabilidadMenor()) {
				//hacer morir al ser si no es viable				
//				Ser.muere();	
			}
			comportamiento = new Adulto();
			this.aAdultos.notifica(this);
		}
		if (pasaAAnciano()) {
			// Una solucion para no tener clases sin propiedades
			// son los objetos anonimos
			//TODO quitar dinero al adulto antes de que se jubile
			this.set0Saving(this);
			this.obsDropSaving.notifica(this);
			comportamiento = new Comportamiento() {

				@Override
				public float alimentar(int sueldo, float esperanzaVida) {
					return recalcularVejez(sueldo, esperanzaVida);
				}

				float recalcularVejez(int sueldo, float esperanzaVida) {
					// TODO recalcular la esperanza de vida
					return esperanzaVida;
				}

			};
			this.aAnciano.notifica(this);
		}
		return isAlive();
	}

	public boolean vivir(int sueldo) {
		this.esperanzaVida = comportamiento.alimentar(sueldo, this.esperanzaVida);
		return envejecer();
	}

	public Ser(Ser ser) {
		this.edad = ser.edad;
		this.esperanzaVida = ser.esperanzaVida;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	private int calculaEsperanzaVida(int minimo, int maximo) {
		return Utiles.dameNumero(maximo);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	protected void recalcularEsperanzaDeVida(int sueldo) {
		// TODO recalculando
		
	}

	public boolean pasaAAnciano() {
		return edad == Edades.adulto.getEdadMaxima();
	}

	public boolean pasaAAdulto() {
		return edad == Edades.menor.getEdadMaxima();
	}

	public void addAdultoObserver(Observer obj) {
		aAdultos.addObserver(obj);

	}

	public void addAncianoObserver(Observer obj) {
		aAnciano.addObserver(obj);

	}
	public void addObsDropSaving(Observer obj) {
		obsDropSaving.addObserver(obj);
		
	}
	public void set0Saving(Ser ser) {
		((Adulto)ser.comportamiento).setAhorro(0);
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}
	
}
