package healthcalc.GUI;

import java.awt.EventQueue;


import healthcalc.HealthCalcImpl;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = new HealthCalcImpl();
					calculadora_vista vista = new calculadora_vista();
					calculadora_controlador controlador = new calculadora_controlador(modelo, vista);
					vista.control(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
