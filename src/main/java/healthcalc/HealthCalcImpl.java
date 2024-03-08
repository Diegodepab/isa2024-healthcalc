/**
 * 
 */
package healthcalc;

/**
 * @author DiegoDePablo
 *
 */
public class HealthCalcImpl implements HealthCalc {
    @Override
    public float idealWeight(int height, char gender) throws Exception {
        Character sexo = Character.toUpperCase(gender);
        if (sexo != 'W' && sexo != 'M') {
            throw new IllegalArgumentException("Solo se acepta entradas de 'w' for Woman (mujer) y 'm' for men (hombre)");
        } else if (height > 272) {
            throw new IllegalArgumentException("La altura introducida es demasiado alta, revisa los valores introducidos");
        } else {
            if (sexo == 'M') {
                if (height >= 110) {
                	return height - 100 - (height - 150) / 4f;
                    //variation return Math.round((height - 100 - (height - 150) / 4f )* 100) / 100;
                } 
            } else {
                if (height >= 100) {
                	return height - 100 - (height - 150) / 2.5f;
                } 
            }throw new IllegalArgumentException("La altura introducida es menor a la esperada, recuerda que es altura en cm");
        }
    }

	@Override
	public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
		if (20 > weight || weight > 650) {
        	throw new IllegalArgumentException("valor de peso incorrecto (solo se aceptaran valores dentro del umbral 20kg<X<650kg)");
		} else if (40 > height || height > 275) {
            throw new IllegalArgumentException("valor de altura incorrecto (solo se aceptaran valores dentro del umbral 40cm<X<275cm)");
        }else { 
        	Character sexo = Character.toUpperCase(gender);
        	if (sexo != 'W' && sexo != 'M') {
                throw new IllegalArgumentException("valor de sexo incorrecto (solo se aceptaran valores correspondientes a 'm' y 'w')");
            }else if (0 > age || age > 100) {
                throw new IllegalArgumentException("edad incorrecto (solo se aceptaran valores dentro del umbral 0<X<100 años)");
            }else if (sexo == 'M') {
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
