package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class Proxy_Registro_HealthCalc implements HealthHospital, HealthStats{

	private HealthHospital calcu;
    private List<Float> lista_altura;
    private List<Float> lista_peso;
    private List<Integer> lista_edad;
    private List<Float> lista_indice_metabolico;
    private int numSexoH;
    private int numSexoM;
    // private int numPac; no hace falta al tener todas las alturas
  

    public Proxy_Registro_HealthCalc(HealthHospital calcu) {
        this.calcu = calcu;
        this.lista_altura = new ArrayList<>();
        this.lista_peso = new ArrayList<>();
        this.lista_edad = new ArrayList<>();
        this.lista_indice_metabolico = new ArrayList<>();
        this.numSexoH = 0;
        this.numSexoM = 0;
    }
    
    private float calcularMedia(List<? extends Number> lista) {
        float suma = 0;
        for (Number valor : lista) {
            suma += valor.floatValue();
        }
        return suma / lista.size();
    }
    
	@Override
	public float alturaMedia() {
		 return calcularMedia(lista_altura);
	}

	@Override
	public float pesoMedio() {
		 return calcularMedia(lista_peso);
	}

	@Override
	public float edadMedia() {
		 return calcularMedia(lista_edad);
	}

	@Override
	public float bmrMedio() {
		 return calcularMedia(lista_edad);
	}

	@Override
	public int numSexoH() {
		// TODO Auto-generated method stub
		return numSexoH;
	}

	@Override
	public int numSexoM() {
		// TODO Auto-generated method stub
		return numSexoM;
	}

	@Override
	public int numTotalPacientes() {
		return numSexoH + numSexoM; // complejidad de sumar 2 int (O(1)), complejidad de hacer lista_altura.size() es (O(N))
	}

	@Override
	public double bmr(char genero, int edad, float altura, int peso) {
		if (genero == 'm') {
        	//M de men, no confundir con mujer
        	numSexoH=1+numSexoH;
        } else {
        	numSexoM=1+numSexoM;
        }
		double bmr = calcu.bmr(genero, edad, altura, peso);
		lista_altura.add((float) altura);
		lista_edad.add((int) edad);
		lista_peso.add((float) peso);
		lista_indice_metabolico.add((float) bmr);
        return bmr;
	}

	@Override
	public int pesoIdeal(char genero, float altura) {
		if (genero == 'm') {
        	//M de men, no confundir con mujer
        	numSexoH=1+numSexoH;
        } else {
        	numSexoM=1+numSexoM;
        }
		float idealWeight = calcu.pesoIdeal(genero, altura);
		lista_altura.add((float) altura);
		// lista_peso.add((float) idealWeight); EN CASO DE QUERER METER ESTE PESO EN 
        return (int) idealWeight;
    }

}
