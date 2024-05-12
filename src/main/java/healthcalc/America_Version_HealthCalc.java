package healthcalc;

/**
 * Clase que implementa la versión americana de la calculadora de salud utilizando el patrón decorador.
 * Se refiere a unidades inglesas (anglosajonas).
 * 1 kg = 2,20462 libras y según Google, 1 pie es 0.3048 metros.
 */
public class America_Version_HealthCalc extends decorator_HealthCalc {

    public America_Version_HealthCalc(HealthHospital calcu) {
        super(calcu);
    }

    /**
     * Estoy haciendo una calculadora que recibe la altura en pies y el peso en libras
     * y devuelve el bmr como siempre y el peso ideal en libras
     */    
    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        int alturaMetros = convertirPiesAMetros(altura);
        int pesoGramos = convertirLibrasAGramos(peso);
        return calcu.bmr(genero, edad, alturaMetros, pesoGramos);
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        int alturaMetros = convertirPiesAMetros(altura);
        return convertirKGALibras(calcu.pesoIdeal(genero, alturaMetros));
    }

    private int convertirPiesAMetros(float alturaPies) {
        return (int) (alturaPies * 0.3048);
    }

    private int convertirLibrasAGramos(int peso) {
        return (int) (peso * 2.20462);
    }

    private int convertirKGALibras(int pesoKG) {
        return (int) Math.round(pesoKG * 2.20462);
    }
}

