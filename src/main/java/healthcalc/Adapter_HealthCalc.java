package healthcalc;

/**
 * @author DiegoDePab
 *
 */
public class Adapter_HealthCalc implements HealthHospital{
	private HealthCalcImpl calcu;

    public Adapter_HealthCalc() {
    	calcu = HealthCalcImpl.getInstance();
    }

	@Override
	public double bmr(Gender genero, int edad, float altura, int peso) {
		float peso_kg = peso / 1000;
		float altura_cm = altura * 100; 
		double indice_Metabolico_Basal = 0;
		try {
			indice_Metabolico_Basal = calcu.basalMetabolicRate(new persona_pac(peso_kg, altura_cm, edad, genero));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return (double) indice_Metabolico_Basal;
	}

	@Override
	public int pesoIdeal(Gender genero, float altura) {
		float altura_cm = altura * 100; 
        try {
			return (int) calcu.getIdealBodyWeight(new persona_pac(altura_cm, genero));
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}



}
