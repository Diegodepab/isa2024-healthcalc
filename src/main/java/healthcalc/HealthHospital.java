package healthcalc;

public interface HealthHospital {
	//En el Hospital Costa del Sol de Marbella se han interesado por nuestra calculadora de salud y la quieren
	//	integrar en su sistema informático. Para ello nos han dado la siguiente interfaz HealthHospital
    public double bmr(char genero, int edad, float altura, int peso);
    //nota: en la practica 7 aplicaremos refactorings, esta dejar tal cual
    
    public int pesoIdeal(char genero, float altura);
    
    //Nótese que el hospital usa la altura en metros y el peso en gramos.
}
