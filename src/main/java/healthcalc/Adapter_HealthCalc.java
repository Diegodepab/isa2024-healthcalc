package healthcalc;

public class Adapter_HealthCalc implements HealthHospital{
	private HealthCalc calcu;

    public Adapter_HealthCalc() {
    	calcu = HealthCalcImpl.getInstance();
    }

	@Override
	public double bmr(char genero, int edad, float altura, int peso) {
		float peso_kg = peso / 1000;
		float altura_cm = altura * 100; 
		float indice_Metabolico_Basal = 0;
		try {
			indice_Metabolico_Basal = calcu.basalMetabolicRate(peso_kg, (int) altura_cm, genero, edad);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return (double) indice_Metabolico_Basal;
	}

	@Override
	public int pesoIdeal(char genero, float altura) {
		float altura_cm = altura * 100; 
        try {
			return (int) calcu.idealWeight((int) altura_cm, genero);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
