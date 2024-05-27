package healthcalc;

public abstract class Mensaje_Decorador implements HealthHospital {
	protected HealthHospital calcu;
	
	
	public Mensaje_Decorador(HealthHospital calcu) {
		super();
		this.calcu = calcu;
	}
	
	protected abstract void mostrar(float altura, int peso, double indice_metabolico);
	
	@Override
	public int pesoIdeal(Gender genero, float altura) {
		// TODO Auto-generated method stub
		return calcu.pesoIdeal(genero, altura);
	}
	
	// la calculadora debe mostrar por pantalla un mensaje preciso con la información
	//de la operación “BMR” cada vez que se invoca
	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		double indice_metabolico;
		try {
			indice_metabolico = calcu.bmr(genero, edad, altura, peso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		mostrar(altura, peso, indice_metabolico);
		return indice_metabolico;
	}
	
}
