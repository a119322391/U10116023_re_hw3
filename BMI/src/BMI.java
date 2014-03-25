import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class BMICalculator extends JFrame {
  // Create text fields for interest rate, years
  // loan amount, monthly payment, and total payment
  private JTextField jtfNAME = new JTextField();
  private JTextField jtfAGE = new JTextField();
  private JTextField jtfHEIGHT = new JTextField();
  private JTextField jtfWEIGHT = new JTextField();
  private JTextField jtfBMI = new JTextField();
  private JTextField jtfCONDITION = new JTextField();
  // Create a Compute Payment button
  private JButton jbtBMI = new JButton("GO");

  public BMICalculator() {
    // Panel p1 to hold labels and text fields
    JPanel p1 = new JPanel(new GridLayout(6, 2));
    p1.add(new JLabel("NAME"));
    p1.add(jtfNAME);
    p1.add(new JLabel("AGE"));
    p1.add(jtfAGE);
    p1.add(new JLabel("HEIGHT"));
    p1.add(jtfHEIGHT);
    p1.add(new JLabel("WEIGHT"));
    p1.add(jtfWEIGHT);
    p1.add(new JLabel("BMI"));
    p1.add(jtfBMI);
    p1.add(new JLabel("CONDITION"));
    p1.add(jtfCONDITION);
    p1.setBorder(new
      TitledBorder("Enter NAME AGE HEIGHT WEIGHT"));

    // Panel p2 to hold the button
    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtBMI);

    // Add the panels to the frame
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listener
    jbtBMI.addActionListener(new ButtonListener());
  }

  /** Handle the Compute Payment button */
  private class ButtonListener implements ActionListener {
    @Override 
    public void actionPerformed(ActionEvent e) {
      // Get values from text fields
      String name = jtfNAME.getText();
      int age = Integer.parseInt(jtfAGE.getText());
      double  height=
        Double.parseDouble(jtfHEIGHT.getText());
      double  weight=
    	        Double.parseDouble(jtfWEIGHT.getText());
      // Create a loan object
      BMI MYBMI = new BMI(name, age, weight, height);

      // Display monthly payment and total payment
      jtfBMI.setText(String.format("%.2f", MYBMI.getBMI()));
      jtfCONDITION.setText(String.format("%s",
    		  MYBMI.getStatus()));
    }
  }
  
  public static void main(String[] args) {
    BMICalculator frame = new BMICalculator();
    frame.setSize(400,400);
    frame.setTitle("LoanCalculator");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}

class BMI {
		  private String name;
		  private int age;
		  private double weight; // in pounds
		  private double height; // in inches
		  public static final double KILOGRAMS_PER_POUND = 0.45359237; 
		  public static final double METERS_PER_INCH = 0.0254;  
		  
		  public BMI(String name, int age, double weight, double height) {
		    this.name = name;
		    this.age = age;
		    this.weight = weight;
		    this.height = height;
		  }
		  
		  public BMI(String name, double weight, double height) {
		    this(name, 20, weight, height);
		  }
		  
		  public double getBMI() {
		    double bmi = weight * KILOGRAMS_PER_POUND / 
		      ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		    return Math.round(bmi * 100) / 100.0;
		  }
		  
		  public String getStatus() {
		    double bmi = getBMI();
		    if (bmi < 18.5)
		      return "Underweight";
		    else if (bmi < 25)
		      return "Normal";
		    else if (bmi < 30)
		      return "Overweight";
		    else
		      return "Obese";
		  }
		  
		  public String getName() {
		    return name;
		  }
		  
		  public int getAge() {
		    return age;
		  }
		  
		  public double getWeight() {
		    return weight;
		  }
		  
		  public double getHeight() {
		    return height;
		  }
		}
