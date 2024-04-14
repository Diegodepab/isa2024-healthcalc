package healthcalc.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.GUI.calculadora_vista;
import healthcalc.HealthCalcImpl;

public class calculadora_controlador implements ActionListener {
    
    private HealthCalcImpl modelo;
    private calculadora_vista vista;

    public calculadora_controlador(HealthCalcImpl modelo, calculadora_vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        try {
            switch (comando) {
                case "Calcular Peso Ideal":
                    calcularPesoIdeal();
                    break;
                case "Calcular BMR":
                    calcularBMR();
                    break;
                // Agregar más casos según sea necesario para manejar otros comandos
                default:
                    // Manejar comandos desconocidos o no implementados
                    break;
            }
        } catch (NumberFormatException ex) {
            vista.invalidInputs("Entrada inválida. Asegúrate de ingresar valores numéricos.");
        } catch (Exception ex) {
            vista.invalidInputs("Error al procesar el comando '" + comando + "': " + ex.getMessage());
        }
    }

    private void calcularPesoIdeal() throws Exception {
        int altura = vista.getAltura();
        char genero = vista.getGenero();
        float resultado = modelo.idealWeight(altura, genero);
        vista.setResultPI(resultado);
    }

    private void calcularBMR() throws Exception {
        int altura = vista.getAltura();
        char genero = vista.getGenero();
        int edad = vista.getEdad();
        float peso = vista.getPeso();
        float resultado = modelo.basalMetabolicRate(peso, altura, genero, edad);
        vista.setResultBMR(resultado);
    }
}
