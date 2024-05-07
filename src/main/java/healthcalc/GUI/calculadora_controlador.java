package healthcalc.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalcImpl;

public class calculadora_controlador implements ActionListener {

    private HealthCalcImpl modelo = HealthCalcImpl.getInstance();;
    private calculadora_vista vista;

    public calculadora_controlador(HealthCalcImpl modelo, calculadora_vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("getIdealWeight")) {
            // idealWeight

            int altura = vista.getAltura();
            char genero = vista.getGenero();
            try {
                float resultado = modelo.idealWeight(altura, genero);
                vista.setResultText(resultado);
            } catch (Exception error) {
                String msg = comando + ": " + error.getMessage();
                vista.error(msg);
            }

        } else if (comando.equals("getBMR")) {
            int altura = vista.getAltura();
            char genero = vista.getGenero();
            int edad = vista.getEdad();
            float peso = vista.getPeso();
            try {
                float resultado = modelo.basalMetabolicRate(peso, altura, genero, edad);
                vista.setResultText(resultado);
            } catch (Exception error) {
                String msg = comando + ": " + error.getMessage();
                vista.error(msg);
            }

        }

    }

}
