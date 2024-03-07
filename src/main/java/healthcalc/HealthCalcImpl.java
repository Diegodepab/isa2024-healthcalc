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
            }
            throw new IllegalArgumentException("La altura introducida es menor a la esperada, recuerda que es altura en cm");
            
        }
    }

	@Override
	public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
