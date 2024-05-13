package healthcalc;

public abstract class Mensaje_Decorador implements HealthHospital {
	protected HealthHospital calcu;
	protected abstract void mostrar(float altura, int peso, double indice_metabolico);
	
	public Mensaje_Decorador(HealthHospital calcu) {
		super();
		this.calcu = calcu;
	}

	@Override
	public int pesoIdeal(char genero, float altura) {
		// TODO Auto-generated method stub
		return calcu.pesoIdeal(genero, altura);
	}
	
	// la calculadora debe mostrar por pantalla un mensaje preciso con la información
	//de la operación “BMR” cada vez que se invoca
	@Override
	public double bmr(char genero, int edad, float altura, int peso) {
		double indice_metabolico= calcu.bmr(genero, edad, altura, peso);
		mostrar(altura, peso, indice_metabolico);
		return indice_metabolico;
	}
	
}
