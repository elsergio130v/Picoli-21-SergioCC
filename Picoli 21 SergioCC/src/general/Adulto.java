package general;


public class Adulto implements Comportamiento{
	private long ahorro;
	
	public long getAhorro() {
		return ahorro;
	}

	public void setAhorro(long ahorro) {
		this.ahorro = ahorro;
	}

	@Override
	public float alimentar(int sueldo,float esperanzaVida) {
		int necesidadVitalSatisfecha = 0;
		int resto = sueldo - Edades.adulto.getNecesidadVital();
			// resto sera -20
			this.ahorro += resto;
			// ahorros -10
			if (ahorro < 0) {
				necesidadVitalSatisfecha = (int) (Edades.adulto.getNecesidadVital() - ahorro);
				this.ahorro = 0;
			}
			
		return recalcularEsperanzaDeVida(sueldo,esperanzaVida);
	}

	private float recalcularEsperanzaDeVida(int sueldo, float esperanzaVida) {
		//diria que funciona, pero no lo he probado		
		esperanzaVida+=reajustarEV(sueldo);
		
		return esperanzaVida;
	}

	public long getNecesidad() {
		if(this.ahorro<Edades.adulto.getNecesidadVital()) {
			return Edades.adulto.getNecesidadVital()-this.ahorro;
		}
		return 0;
	}
	public float reajustarEV (int sueldo) {
		float resta = 0;
		if (sueldo<=99f && sueldo <=50f) {
			resta= -0.5f;
		}if (sueldo<=49f && sueldo <=0f) 
			resta = -1f;
			return resta;
		}
	}
	
