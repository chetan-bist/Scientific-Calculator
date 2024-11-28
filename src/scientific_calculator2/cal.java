/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientific_calculator2;

/**
 *
 * @author Chetabist
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.StringTokenizer;
import com.Dao.*;

public class cal extends JFrame implements ActionListener {

    private JTextField display;
    private Calculator calculator;
    private StringBuilder input;

    public cal() {
        calculator = new Calculator();
        input = new StringBuilder();
        setTitle("Scientific Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 4));

        String[] buttons = {
                "7", "8", "9", "/", "(", ")",
                "4", "5", "6", "*", "C", "CE",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "log",
                "sqrt", "exp", "x^2", "|x|"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "7": case "8": case "9": case "4": case "5":
            case "6": case "1": case "2": case "3": case "0": case ".":
                input.append(command);
                display.setText(input.toString());
                break;
            case "+": case "-": case "*": case "/":
                input.append(" ").append(command).append(" ");
                display.setText(input.toString());
                break;
            case "=":
                processExpression();
                break;
            case "sin":
                input.append("sin(");
                display.setText(input.toString());
                break;
            case "cos":
                input.append("cos(");
                display.setText(input.toString());
                break;
            case "tan":
                input.append("tan(");
                display.setText(input.toString());
                break;
            case "log":
                input.append("log(");
                display.setText(input.toString());
                break;
            case "sqrt":
                input.append("sqrt(");
                display.setText(input.toString());
                break;
            case "exp":
                input.append("exp(");
                display.setText(input.toString());
                break;
            case "x^2":
                input.append("^2");
                display.setText(input.toString());
                break;
            case "|x|":
                input.append("abs(");
                display.setText(input.toString());
                break;
            case "(":
                input.append("(");
                display.setText(input.toString());
                break;
            case ")":
                input.append(")");
                display.setText(input.toString());
                break;
            case "C":
                input.setLength(0);
                display.setText("");
                break;
            case "CE":
                if (input.length() > 0) {
                    input.deleteCharAt(input.length() - 1);
                    display.setText(input.toString());
                }
                break;
            default:
                display.setText("Invalid Input");
                input.setLength(0);
                break;
        }
    }

    private void processExpression() {
        try {
            String infix = input.toString();
            String postfix = infixToPostfix(infix);
            double result = evaluatePostfix(postfix);

            display.setText(String.valueOf(result));
            input.setLength(0);
            input.append(result);
        } catch (Exception ex) {
            display.setText("Error");
            input.setLength(0);
        }
    }

    private String infixToPostfix(String infix) {
        StringTokenizer tokenizer = new StringTokenizer(infix, "()+-*/ ", true);
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (Character.isDigit(token.charAt(0))) {
                postfix.append(token).append(' ');
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop(); // Pop the '('
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString();
    }

    private int precedence(String op) {
        switch (op) {
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
            case "sin": case "cos": case "tan": case "log": case "sqrt": case "exp": case "abs":
                return 3;
            default:
                return -1;
        }
    }

    private double evaluatePostfix(String postfix) throws ScriptException {
        StringTokenizer tokenizer = new StringTokenizer(postfix);
        Stack<Double> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = 0;
                if (!token.equals("sin") && !token.equals("cos") && !token.equals("tan") &&
                    !token.equals("log") && !token.equals("sqrt") && !token.equals("exp") && !token.equals("abs")) {
                    a = stack.pop();
                }
                stack.push(applyOp(token, a, b));
            }
        }
        double ans = stack.pop();
        System.out.println(ans);
        return ans;
    }

    private double applyOp(String op, double a, double b) {
        switch (op) {
            case "+":
                return calculator.add(a, b);
            case "-":
                return calculator.subtract(a, b);
            case "*":
                return calculator.multiply(a, b);
            case "/":
                return calculator.divide(a, b);
            case "sin":
                System.out.println(Math.sin(1));
                return calculator.sine(b, true); // sin is a unary operator
            case "cos":
                return calculator.cosine(b, true); // cos is a unary operator
            case "tan":
                return calculator.tangent(b, true); // tan is a unary operator
            case "log":
                return calculator.log10(b); // log is a unary operator
            case "sqrt":
                return calculator.squareRoot(b); // sqrt is a unary operator
            case "exp":
                return calculator.exp(b); // exp is a unary operator
            case "abs":
                return calculator.absolute(b); // abs is a unary operator
            default:
                throw new UnsupportedOperationException("Unknown operator: " + op);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new cal().setVisible(true);
        });
    }
}

  

