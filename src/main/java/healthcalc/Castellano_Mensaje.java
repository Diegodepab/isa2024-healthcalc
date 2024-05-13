package healthcalc;

public class Castellano_Mensaje extends Mensaje_Decorador{

	public Castellano_Mensaje(HealthHospital calcu) {
		super(calcu);
		// TODO Auto-generated constructor stub
	}

	// “La persona con altura 1.83 metros y 78 Kg tiene un BMR de 23.29.”
	@Override
	protected void mostrar(float altura, int peso, double indice_metabolico) {
		//COMPROBAR QUE UNIDADES SALE
		System.out.println("La persona con altura "+altura+" metros y "+ (peso/1000) +" kg tiene un BMR de "+ indice_metabolico + ".");
	}

}
