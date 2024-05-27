package healthcalc.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.Gender;
import healthcalc.HealthCalcImpl;
import healthcalc.persona_pac;

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
            Gender genero = vista.getGenero();
            try {
                float resultado = modelo.idealWeight(new persona_pac(altura, genero));
                vista.setResultText(resultado);
            } catch (Exception error) {
                String msg = comando + ": " + error.getMessage();
                vista.error(msg);
            }

        } else if (comando.equals("getBMR")) {
            int altura = vista.getAltura();
            Gender genero = vista.getGenero();
            int edad = vista.getEdad();
            float peso = vista.getPeso();
            try {
                float resultado = modelo.basalMetabolicRate(new persona_pac(peso, altura, edad, genero));
                vista.setResultText(resultado);
            } catch (Exception error) {
                String msg = comando + ": " + error.getMessage();
                vista.error(msg);
            }

        }

    }

}
