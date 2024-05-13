package healthcalc;

public class Ingles_Mensaje extends Mensaje_Decorador{
	
	public Ingles_Mensaje(HealthHospital calcu) {
		super(calcu);
	}

	// “A person who is 1.83 meters tall and weighs 78 kilograms has a BMR of 23.29”
	@Override
	protected void mostrar(float altura, int peso, double indice_metabolico) {
		System.out.println("A person who is "+altura+" meters tall and weighs "+ (peso/1000) +" kilograms has a BMR of "+ indice_metabolico + ".");
	}

}
