package general;

public class Sector {
	private long cantidad;
	private float porcentajeMinimo;
	private float porcentajeReal;
	private Edades edad;

	public Sector(long cantidad, float porcentajeMinimo, float porcentajeReal, Edades edad) {
		super();
		this.cantidad = cantidad;
		this.porcentajeMinimo = porcentajeMinimo;
		this.porcentajeReal = porcentajeReal;
		this.edad = edad;
	}

	private long getCantidad() {
		return cantidad;
	}

	private void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	private float getPorcentajeMinimo() {
		return porcentajeMinimo;
	}

	private void setPorcentajeMinimo(float porcentajeMinimo) {
		this.porcentajeMinimo = porcentajeMinimo;
	}

	private float getPorcentajeReal() {
		return porcentajeReal;
	}

	public long getTotal() {
		return (long) (cantidad * (edad.getNecesidadVital() * porcentajeReal));
	}

	public void setPorcentajeReal(long capital) {
		float loquecomecadabicho = capital / cantidad;
		long cantidadMinima = (long) (cantidad * edad.getNecesidadVital() * porcentajeMinimo);
		if (capital <= cantidadMinima) {
			porcentajeReal = porcentajeMinimo;
		} else {
			porcentajeReal = loquecomecadabicho / edad.getNecesidadVital();
			if (porcentajeReal > 1)
				porcentajeReal = 1;
		}
	}

}
