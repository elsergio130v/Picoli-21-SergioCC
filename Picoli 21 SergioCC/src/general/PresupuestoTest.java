package general;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PresupuestoTest {
	int cantidadMenores = 5, cantidadTrabajadores = 5, cantidadAncianos = 5;
	ArrayList<Ser> listaParados;

	@BeforeEach
	void before() {
		listaParados = new ArrayList<>();
		int parados = 5;
		for (int i = 0; i < parados; i++) {
			Ser e;
			do {
				e = new Ser();
			} while (e.getEsperanzaVida() < 50);
			listaParados.add(e);
		}
		int edad = 18;
		for (int i = 0; i < edad; i++) {
			for (Ser ser : listaParados) {
				ser.envejecer();
			}
		}
		// Aqui tenemos n parados con 18 periodos
		// for (int i = 0; i < edad; i++) {
		// for (Ser ser : listaParados) {
		// ser.envejecer();
		// ser.getComportamiento().alimentar(Edades.adulto.getNecesidadVital()*2,
		// ser.getEsperanzaVida());
		// }
		// }
		// Ahora tenemos a n parados con ahorros
	}

	@Test
	void testCalcularDeficit() {
		Presupuesto presupuesto = new Presupuesto(cantidadMenores, cantidadTrabajadores, cantidadAncianos,
				listaParados);
		long capital = 1350;
		presupuesto.calcularPresupestoReal(capital);
		assertEquals(capital, presupuesto.getTotal());
	}

	@Test
	void testCalcularPresupuesto() {

		long resultado = 2250;
		Presupuesto presupuesto = new Presupuesto(cantidadMenores, cantidadTrabajadores, cantidadAncianos,
				listaParados);
		assertEquals(resultado, presupuesto.calcularPresupuestoOptimo());
	}

}
