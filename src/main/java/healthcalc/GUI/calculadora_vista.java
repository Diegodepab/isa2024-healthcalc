package healthcalc.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBackground(new Color(224, 255, 255));
        btnCalculate.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnCalculate.setBounds(20, 220, 166, 40);
        frame.getContentPane().add(btnCalculate);
        
        JLabel lblSexo = new JLabel("Gender:");
        lblSexo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblSexo.setBounds(20, 94, 66, 24);
        frame.getContentPane().add(lblSexo);

        // Action listeners para mostrar/ocultar campos de edad y peso según la acción seleccionada
        idealWeightRadioButton.addActionListener(e -> {
            txtAge.setVisible(false);
            lblAgeUnit.setVisible(false);
            txtWeight.setVisible(false);
            lblWeightUnit.setVisible(false);
        });

        basalMetabolicRateRadioButton.addActionListener(e -> {
            txtAge.setVisible(true);
            lblAgeUnit.setVisible(true);
            txtWeight.setVisible(true);
            lblWeightUnit.setVisible(true);
        });
	
	
	}

}
