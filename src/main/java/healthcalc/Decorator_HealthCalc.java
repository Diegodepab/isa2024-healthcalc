package healthcalc;

public class Decorator_HealthCalc implements HealthHospital{
	protected HealthHospital calcu;

	public Decorator_HealthCalc(HealthHospital calcu) {
		super();
		this.calcu = calcu;
	}

	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		try {
			return calcu.bmr(genero, edad, altura, peso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int pesoIdeal(Gender genero, float altura) {
		return calcu.pesoIdeal(genero, altura);
	}
}
