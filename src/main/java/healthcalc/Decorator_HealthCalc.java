package healthcalc;

public class Decorator_HealthCalc implements HealthHospital{
	protected HealthHospital calcu;

	public Decorator_HealthCalc(HealthHospital calcu) {
		super();
		this.calcu = calcu;
	}

	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		return calcu.bmr(genero, edad, altura, peso);
	}

	@Override
	public int pesoIdeal(Gender genero, float altura) {
		return calcu.pesoIdeal(genero, altura);
	}
}
