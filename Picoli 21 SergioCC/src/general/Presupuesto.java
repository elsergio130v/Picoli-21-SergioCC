package general;

import java.util.ArrayList;

public class Presupuesto {
	private Sector menores;
	private Sector ancianos;
	private Sector trabajadores;

	private ArrayList<Ser> listaParados;

	public Presupuesto(long cantidadMenores, long cantidadTrabajadores, long cantidadAncianos,
			ArrayList<Ser> listaParados) {
		super();
		this.menores = new Sector(cantidadMenores, .55f, 1f, Edades.menor);
		this.ancianos = new Sector(cantidadAncianos, .3f, 1f, Edades.anciano);
		this.trabajadores = new Sector(cantidadTrabajadores, 1f, 2f, Edades.adulto);
		this.listaParados = listaParados;
	}

	public void calcularPresupestoReal(long capital) {
		menores.setPorcentajeReal(capital);
		capital-=menores.getTotal();
		ancianos.setPorcentajeReal(capital);
		capital-=ancianos.getTotal();
		trabajadores.setPorcentajeReal(capital);
		capital-=trabajadores.getTotal();
	}

	public long getTotal() {
		long total = menores.getTotal();
		total += ancianos.getTotal();
		total += trabajadores.getTotal();
		total += calcularNecesidadParados();
		return total;
	}
	
	public long calcularPresupuestoOptimo() {
		long total = menores.getTotal();
		total += ancianos.getTotal();
		total += trabajadores.getTotal();
		total += calcularNecesidadParados();
		return total;
	}

	private long calcularNecesidadParados() {
		long total = 0;
		for (Ser ser : listaParados) {
			Comportamiento comportamiento = ser.getComportamiento();
			total += ((Adulto) comportamiento).getNecesidad();
		}
		return total;
	}
}
