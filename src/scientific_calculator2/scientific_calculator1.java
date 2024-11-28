import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class scientific_calculator1 extends JFrame {
    private JTextField inputField;  // Input field for expressions
    private JLabel resultLabel;    // Label to display results

    public scientific_calculator1() {
        // Set up the frame
        setTitle("Expression Evaluator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setToolTipText("Enter expression like 4*5*sin(5)");

        // Evaluate button
        JButton evalButton = new JButton("Evaluate");
        evalButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Add input field and button to panel
        inputPanel.add(inputField);
        inputPanel.add(evalButton);

        // Result label
        resultLabel = new JLabel("Result: ", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add components to the frame
        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        // Button action listener
        evalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input expression
                    String expression = inputField.getText();

                    // Replace mathematical functions with JavaScript equivalents
                    expression = expression.replaceAll("sin\\((.*?)\\)", "Math.sin(Math.toRadians($1))");
                    expression = expression.replaceAll("cos\\((.*?)\\)", "Math.cos(Math.toRadians($1))");
                    expression = expression.replaceAll("tan\\((.*?)\\)", "Math.tan(Math.toRadians($1))");

                    // Use ScriptEngine to evaluate the expression
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByName("JavaScript");

                    // Evaluate the expression
                    Object result = engine.eval(expression);

                    // Display the result
                    resultLabel.setText("Result: " + result.toString());
                } catch (ScriptException ex) {
                    resultLabel.setText("Error: Invalid Expression");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the Swing application
        SwingUtilities.invokeLater(() -> {
            scientific_calculator1 evaluator = new scientific_calculator1();
            evaluator.setVisible(true);
        });
    }
}
