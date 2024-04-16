package healthcalc.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class calculadora_vista {

    private JFrame frame;
    private JTextField txtHeight;
    private JTextField txtAge;
    private JTextField txtWeight;
    private JRadioButton idealWeightRadioButton;
    private JRadioButton basalMetabolicRateRadioButton;
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private ButtonGroup actionButtonGroup;
    private ButtonGroup genderButtonGroup;
    private JTextField resultado; // Nuevo JTextField para mostrar los resultados
    private JLabel labelKg; // Nuevo JLabel para mostrar "kg"
    private JButton btnCalculate; // Declarar el botón como una variable de clase
    private JButton btnCalculate_IW;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    calculadora_vista window = new calculadora_vista();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public calculadora_vista() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Calculadora de Salud");
        frame.getContentPane().setBackground(new Color(72, 209, 204));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        frame.getContentPane().setBackground(new Color(240, 240, 240));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        idealWeightRadioButton = new JRadioButton("Ideal Weight");
        idealWeightRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        idealWeightRadioButton.setBounds(20, 20, 144, 30);
        frame.getContentPane().add(idealWeightRadioButton);

        basalMetabolicRateRadioButton = new JRadioButton("Basal Metabolic Rate");
        basalMetabolicRateRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        basalMetabolicRateRadioButton.setBounds(160, 20, 203, 30);
        frame.getContentPane().add(basalMetabolicRateRadioButton);

        actionButtonGroup = new ButtonGroup();
        actionButtonGroup.add(idealWeightRadioButton);
        actionButtonGroup.add(basalMetabolicRateRadioButton);

        JLabel lblAction = new JLabel("Patient Data:");
        lblAction.setFont(new Font("Verdana", Font.PLAIN, 18));
        lblAction.setBounds(13, 56, 136, 24);
        frame.getContentPane().add(lblAction);

        hombreRadioButton = new JRadioButton("Male");
        hombreRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        hombreRadioButton.setBounds(90, 90, 100, 30);
        frame.getContentPane().add(hombreRadioButton);

        mujerRadioButton = new JRadioButton("Female");
        mujerRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        mujerRadioButton.setBounds(193, 90, 100, 30);
        frame.getContentPane().add(mujerRadioButton);

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(hombreRadioButton);
        genderButtonGroup.add(mujerRadioButton);

        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblHeight.setBounds(20, 130, 60, 20);
        frame.getContentPane().add(lblHeight);

        JLabel lblHeightUnit = new JLabel("cm");
        lblHeightUnit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblHeightUnit.setBounds(227, 128, 37, 24);
        frame.getContentPane().add(lblHeightUnit);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblAge.setBounds(20, 160, 60, 20);
        frame.getContentPane().add(lblAge);

        JLabel lblAgeUnit = new JLabel("years");
        lblAgeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblAgeUnit.setBounds(227, 155, 66, 30);
        frame.getContentPane().add(lblAgeUnit);

        JLabel lblWeight = new JLabel("Weight:");
        lblWeight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblWeight.setBounds(20, 190, 60, 20);
        frame.getContentPane().add(lblWeight);

        JLabel lblWeightUnit = new JLabel("kg");
        lblWeightUnit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblWeightUnit.setBounds(227, 190, 20, 20);
        frame.getContentPane().add(lblWeightUnit);

        txtHeight = new JTextField();
        txtHeight.setBounds(90, 130, 120, 20);
        frame.getContentPane().add(txtHeight);
        txtHeight.setColumns(10);

        txtAge = new JTextField();
        txtAge.setBounds(90, 160, 120, 20);
        frame.getContentPane().add(txtAge);
        txtAge.setColumns(10);

        txtWeight = new JTextField();
        txtWeight.setBounds(90, 190, 120, 20);
        frame.getContentPane().add(txtWeight);
        txtWeight.setColumns(10);

        btnCalculate = new JButton("Calculate"); // Aquí está la corrección
        btnCalculate.setBackground(new Color(224, 255, 255));
        btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnCalculate.setBounds(20, 220, 166, 40);
        frame.getContentPane().add(btnCalculate);

        btnCalculate_IW = new JButton("Calculate IW"); // Aquí está la corrección
        btnCalculate_IW.setBackground(new Color(224, 255, 255));
        btnCalculate_IW.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnCalculate_IW.setBounds(20, 220, 166, 40);
        frame.getContentPane().add(btnCalculate_IW);

        JLabel lblSexo = new JLabel("Gender:");
        lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSexo.setBounds(20, 94, 66, 24);
        frame.getContentPane().add(lblSexo);

        // Crear el JTextField para mostrar los resultados
        resultado = new JTextField();
        resultado.setEditable(false); // Hacer que el JTextField sea solo de lectura
        resultado.setBounds(210, 220, 80, 40);
        frame.getContentPane().add(resultado);

        labelKg = new JLabel("SELECT MODO");
        labelKg.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelKg.setBounds(300, 220, 120, 40);
        frame.getContentPane().add(labelKg);

        // Action listeners para mostrar/ocultar campos de edad y peso según la acción
        // seleccionada

        idealWeightRadioButton.addActionListener(e -> {
            txtAge.setVisible(false);
            lblAgeUnit.setVisible(false);
            txtWeight.setVisible(false);
            lblWeightUnit.setVisible(false);
            btnCalculate.setVisible(false);
            labelKg.setText("kg"); // Restablecer el texto del JLabel a "kg" cuando se selecciona "Ideal Weight"
        });

        basalMetabolicRateRadioButton.addActionListener(e -> {
            txtAge.setVisible(true);
            lblAgeUnit.setVisible(true);
            txtWeight.setVisible(true);
            lblWeightUnit.setVisible(true);
            btnCalculate.setVisible(true);
            labelKg.setText("cal/día"); // Cambiar el texto del JLabel a "cal/día" cuando se selecciona "Basal Metabolic
                                        // Rate"
        });

    }

    // Registrar Controlador
    public void control(ActionListener act) {
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                act.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "getBMR"));
                // Mandar la acción "getBMR" al controlador al hacer clic en el botón de
                // calcular
            }
        });

        btnCalculate_IW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                act.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "getIdealWeight"));
                // Mandar la acción "getIdealWeight" al controlador al hacer clic en el botón de
                // calcular IW
            }
        });

    }

    // Obtener valores
    public int getEdad() {
        try {
            return Integer.parseInt(txtAge.getText());
        } catch (NumberFormatException e) {
            return 0; // En caso de error, devolver un valor predeterminado
        }
    }

    public int getAltura() {
        try {
            return Integer.parseInt(txtHeight.getText());
        } catch (NumberFormatException e) {
            return 0; // En caso de error, devolver un valor predeterminado
        }
    }

    public float getPeso() {
        try {
            return Float.parseFloat(txtWeight.getText());
        } catch (NumberFormatException e) {
            return 0; // En caso de error, devolver un valor predeterminado
        }
    }

    public char getGenero() {
        if (mujerRadioButton.isSelected()) {
            return 'w';
        } else {
            return 'm';
        }
    }

    public JButton getBtnCalculate() {
        return btnCalculate;
    }
    // tratamiento de errores

    public void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void invalidInputs(String errCode) {
        JOptionPane.showMessageDialog(frame,
                errCode,
                "Ingrese valores válidos para la altura, peso, género y edad",
                JOptionPane.ERROR_MESSAGE);
    }

    public void noInputsErr() {
        JOptionPane.showMessageDialog(frame,
                "Debe rellenar los campos necesarios antes de calcular",
                "Ha sucedido un error",
                JOptionPane.ERROR_MESSAGE);
    }

    public void setResultText(float resultado2) {
        resultado.setText(String.valueOf(resultado2));
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

}
