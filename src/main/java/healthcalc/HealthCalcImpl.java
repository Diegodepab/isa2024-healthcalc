/**
 * 
 */
package healthcalc;

/**
 * @author DiegoDePab
 *
 */
public class HealthCalcImpl implements CardiovascularMetrics, MetabolicMetrics {
	
	// Patron Singular
	private static HealthCalcImpl instance;

	private HealthCalcImpl() {
		//inicializa la calculadora 
		super();
	}

	public static HealthCalcImpl getInstance() {
		if (instance == null) {
			instance = new HealthCalcImpl();
			//Lazy initialization (inicialización perezosa)
	    }
	        return instance;
	 }
	
    @Override
    public double getIdealBodyWeight(Person person) {
    	float height = person.height();
    	Gender genero = person.gender();
        if (height > 272) {
            throw new IllegalArgumentException("La altura introducida es demasiado alta, revisa los valores introducidos");
        } else {
            if (genero == Gender.MALE) {
                if (height >= 110) {
                	return height - 100 - (height - 150) / 4d;
                    //variation return Math.round((height - 100 - (height - 150) / 4f )* 100) / 100;
                } 
            } else {
                if (height >= 100) {
                	return height - 100 - (height - 150) / 2.5d;
                } 
            }throw new IllegalArgumentException("La altura introducida es menor a la esperada, recuerda que es altura en cm");
        }
    }

	@Override
	public double basalMetabolicRate(Person person) {
		float height= person.height();
        Gender genero= person.gender();
        float weight= person.weight();
        int age= person.age();
		if (20 > weight || weight > 650) {
        	throw new IllegalArgumentException("valor de peso incorrecto (solo se aceptaran valores dentro del umbral 20kg<X<650kg)");
		} else if (40 > height || height > 275) {
            throw new IllegalArgumentException("valor de altura incorrecto (solo se aceptaran valores dentro del umbral 40cm<X<275cm)");
        }else { 
        	if (0 > age || age > 100) {
                throw new IllegalArgumentException("edad incorrecto (solo se aceptaran valores dentro del umbral 0<X<100 años)");
            }else if (genero == Gender.MALE) {
            	float BMR = 10 * weight + 6.25f * height - 5 * age + 5;
            	if (BMR > 0) {return BMR;} 
            	else {throw new IllegalArgumentException("valores introducidos no son adecuados para el calculo");}	
        }else {
        	float BMR = 10 * weight + 6.25f * height - 5 * age - 161;
        	if (BMR > 0) {return BMR;} 
        	else {throw new IllegalArgumentException("valores introducidos no son adecuados para el calculo");}	
        }	
        }
	}

}
