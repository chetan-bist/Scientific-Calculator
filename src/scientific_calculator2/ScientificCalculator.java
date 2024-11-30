package scientific_calculator2;
import com.Dao.Calculator;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import javax.script.ScriptException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class ScientificCalculator {

	private JFrame frame;
	private JTextField textField;
	private Calculator calculator;
        private StringBuilder input;
        List<Integer> digits;
        JLabel lblRaorDe;
        int length;
	
	double result;
	String operation = "false";
	String answer;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScientificCalculator window = new ScientificCalculator();
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
	public ScientificCalculator() {
		calculator = new Calculator();
        input = new StringBuilder();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);

                frame.setBounds(100, 100, 357, 716);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(10, 39, 320, 63);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SCIENTFIC CALCULATOR");
		lblNewLabel.setBounds(10, 11, 320, 27);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				input.append(btn2.getText());
				textField.setText(input.toString());
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn2.setBounds(139, 499, 64, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				input.append(btn5.getText());
				textField.setText(input.toString());
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn5.setBounds(139, 439, 64, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				input.append(btn8.getText());
				textField.setText(input.toString());
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn8.setBounds(139, 379, 64, 50);
		frame.getContentPane().add(btn8);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            input.setLength(0);
                            textField.setText("");

			}
		});

                btnC.setBounds(139, 316, 64, 50);
		frame.getContentPane().add(btnC);
		
		JButton btnLn = new JButton("sinh");
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a = Math.sinh(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);

			}
		});
		btnLn.setFont(new Font("Tahoma", Font.PLAIN, 13));

                btnLn.setBounds(139, 248, 64, 50);
		frame.getContentPane().add(btnLn);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn0.getText());
				textField.setText(input.toString());
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 21));

                btn0.setBounds(74, 559, 129, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				input.append("sin(");
                                textField.setText(input.toString());

			}
		});
		btnSin.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnSin.setBounds(139, 187, 64, 50);
		frame.getContentPane().add(btnSin);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btnDot.getText());
				textField.setText(input.toString());
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 21));

                btnDot.setBounds(202, 559, 64, 50);
		frame.getContentPane().add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				processExpression();
			}
		});
		
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));

                btnEqual.setBounds(266, 559, 64, 50);
		frame.getContentPane().add(btnEqual);
		
		JButton btnXrx = new JButton("X^Y");
		btnXrx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				input.append(" ").append("^").append(" ");
				textField.setText(input.toString());

			}
		});
		btnXrx.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnXrx.setBounds(10, 316, 64, 50);
		frame.getContentPane().add(btnXrx);
		
		JButton btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            if(operation == "true"){
                                operation = "false";
                                input.append("log10(");
                                textField.setText(input.toString());
                            }else{
                            input.append("log(");
                                textField.setText(input.toString());
                            }

			}
		});
		btnLog.setFont(new Font("Tahoma", Font.PLAIN, 12));

                btnLog.setBounds(74, 249, 64, 50);
		frame.getContentPane().add(btnLog);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                             if (input.length() > 0) {
	                    input.deleteCharAt(input.length() - 1);
	                    textField.setText(input.toString());
	                }

			}
		});
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 19));

                btnCe.setBounds(74, 316, 64, 50);
		frame.getContentPane().add(btnCe);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                                input.append(btn7.getText());
				textField.setText(input.toString());
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn7.setBounds(74, 379, 64, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn4.getText());
				textField.setText(input.toString());
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn4.setBounds(74, 439, 64, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn1.getText());
				textField.setText(input.toString());
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn1.setBounds(74, 499, 64, 50);
		frame.getContentPane().add(btn1);
		
		JButton btnX = new JButton("x³");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		   double a = (Double.parseDouble(textField.getText()));
			textField.setText(String.valueOf(Math.pow(a, 3)));
                        input.setLength(0);

			}
		});
		btnX.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnX.setBounds(10, 379, 64, 50);
		frame.getContentPane().add(btnX);
		
		JButton btnEx = new JButton("ln");
		btnEx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("ln(");
                                textField.setText(input.toString());

			}
		});
		btnEx.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnEx.setBounds(74, 619, 64, 50);
		frame.getContentPane().add(btnEx);
		
		JButton btnx = new JButton("1/x");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a =1/ Math.sqrt(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);

			}
		});
		btnx.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnx.setBounds(9, 248, 64, 50);
		frame.getContentPane().add(btnx);
		
		JButton btnSqrt = new JButton("√");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("√(");
                                textField.setText(input.toString());
				
			
			}
		});
		btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 17));

                btnSqrt.setBounds(10, 619, 64, 50);
		frame.getContentPane().add(btnSqrt);
		
		JButton btnCos = new JButton("cos");
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("cos(");
                                textField.setText(input.toString());

			}
		});
		btnCos.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnCos.setBounds(202, 187, 64, 50);
		frame.getContentPane().add(btnCos);
		
		JButton btnCos_1 = new JButton("cosh");
		btnCos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("cosh(");
                                textField.setText(input.toString());

			}
		});
		btnCos_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

                btnCos_1.setBounds(202, 248, 64, 50);
		frame.getContentPane().add(btnCos_1);
		
		JButton btnBackSpace = new JButton("B");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String backSpace=null;
				if(textField.getText().length()>0)
				{
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace=str.toString();
					textField.setText(backSpace);
				}
			}
		});
		btnBackSpace.setFont(new Font("Tahoma", Font.PLAIN, 19));

                btnBackSpace.setBounds(202, 316, 64, 50);
		frame.getContentPane().add(btnBackSpace);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn9.getText());
				textField.setText(input.toString());
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn9.setBounds(202, 379, 64, 50);
		frame.getContentPane().add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn6.getText());
				textField.setText(input.toString());
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn6.setBounds(202, 439, 64, 50);
		frame.getContentPane().add(btn6);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append(btn3.getText());
				textField.setText(input.toString());
                            
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 23));

                btn3.setBounds(202, 499, 64, 50);
		frame.getContentPane().add(btn3);
		
		JButton btnTan = new JButton("tan");
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("tan(");
                                textField.setText(input.toString());

			}
		});
		btnTan.setFont(new Font("Tahoma", Font.BOLD, 12));

                btnTan.setBounds(266, 187, 64, 50);
		frame.getContentPane().add(btnTan);
		
		JButton btnTan_1 = new JButton("tanh");
		btnTan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            input.append("tanh(");
                                textField.setText(input.toString());

			}
		});
		btnTan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
                btnTan_1.setBounds(266, 248, 64, 50);
		frame.getContentPane().add(btnTan_1);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            if(operation == "true"){
                                operation = "false";
                               
                                input.append(" ").append("e^").append(" ");
				textField.setText(input.toString());
                                }else{
				input.append(" ").append(btnPlus.getText()).append(" ");
				textField.setText(input.toString());
                            }
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));

                btnPlus.setBounds(266, 316, 64, 50);
		frame.getContentPane().add(btnPlus);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                            if(operation == "true"){
                                operation = "false";
                                int d=Integer.parseInt(textField.getText());
                                if(calculator.isPrime(d)){
                                    textResult.setText(String.valueOf(d));

                                     input.setLength(0);
                                }else{
                                    textResult.setText(String.valueOf(factorize(d)));
                                     input.setLength(0);
                                    input.append(result);
                                }
                            }else{
                            input.append(" ").append(btnSub.getText()).append(" ");
				textField.setText(input.toString());
                            }
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 21));
                btnSub.setBounds(266, 379, 64, 50);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if(operation=="true")
                            {
                                operation = "false";
                                input.append(" ").append("p").append(" ");
				textField.setText(input.toString());
                            }else{
                            input.append(" ").append(btnMul.getText()).append(" ");
				textField.setText(input.toString());
                            }
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.PLAIN, 21));
                btnMul.setBounds(266, 439, 64, 50);
		frame.getContentPane().add(btnMul);
		
		JButton btnDivide = new JButton("÷");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if(operation=="true"){
                                operation = "false";
                                input.append(" ").append("C").append(" ");
				textField.setText(input.toString());
                                
                            }else{
                            input.append(" ").append(btnDivide.getText()).append(" ");
				textField.setText(input.toString());
                            }
			}
		});
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 21));
                btnDivide.setBounds(266, 499, 64, 50);
		frame.getContentPane().add(btnDivide);
		
		JButton btnP_1 = new JButton("x²");
		btnP_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a = (Double.parseDouble(textField.getText()));
				textResult.setText(String.valueOf(Math.pow(a, 2)));
                                input.setLength(0);

			}
		});
		btnP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                btnP_1.setBounds(10, 439, 64, 50);
		frame.getContentPane().add(btnP_1);
		
		JButton btnN = new JButton("n!");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
                    input.append(" ").append("!").append(" ");
				textField.setText(input.toString());

			}
		});
		btnN.setFont(new Font("Tahoma", Font.PLAIN, 18));
                btnN.setBounds(10, 499, 64, 50);
		frame.getContentPane().add(btnN);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(72, 291, 1, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(19, 191, 1, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 191, 320, 2);
		frame.getContentPane().add(separator_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ON");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
                rdbtnNewRadioButton.setBounds(10, 126, 63, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("OFF");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn1.setEnabled(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);

                rdbtnNewRadioButton_1.setBounds(74, 126, 64, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton button = new JButton("+/-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double a=Double.parseDouble(String.valueOf(textResult.getText()));
				a=Math.abs(a);
				textResult.setText(String.valueOf(a));
                                input.setLength(0);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));

                button.setBounds(10, 559, 64, 50);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("shift");
                btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                            operation = "true";
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnNewButton.setBounds(232, 112, 85, 21);
                btnNewButton.setBounds(233, 125, 85, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("nPr");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(285, 428, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
                
                JLabel lblNewLabel_3_1_1 = new JLabel("log\n" +"10");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(83, 236, 45, 13);
		frame.getContentPane().add(lblNewLabel_3_1_1);
		
                JLabel lblNewLabel_3_1 = new JLabel("e^x");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(285, 303, 45, 13);
		frame.getContentPane().add(lblNewLabel_3_1);
                
		JLabel lblNewLabel_2 = new JLabel("nCr");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblNewLabel_2.setBounds(285, 426, 45, 13);
                lblNewLabel_2.setBounds(285, 487, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("pr");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(285, 364, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		

                textResult = new JTextField();
		textResult.setFont(new Font("Tahoma", Font.BOLD, 15));
		textResult.setBounds(99, 81, 229, 21);
		frame.getContentPane().add(textResult);
		textResult.setColumns(10);
		
		JButton btnOpen = new JButton("(");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.append("(");
                textField.setText(input.toString());
			}
		});
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 17));

                btnOpen.setBounds(10, 187, 64, 50);
		frame.getContentPane().add(btnOpen);
		
		JButton btnClose = new JButton(")");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.append(")");
                textField.setText(input.toString());
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));

                btnClose.setBounds(74, 187, 64, 50);
		frame.getContentPane().add(btnClose);
                JButton btnRa = new JButton("R");
		btnRa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                           lblRaorDe.setText("R");
                                double a=Double.parseDouble(String.valueOf(textField.getText()));
                           
                            textResult.setText(String.valueOf(String.format("%.4f",Math.toDegrees(a))));
                            input.setLength(0);
			}
		});
		btnRa.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRa.setBounds(10, 155, 45, 21);
		frame.getContentPane().add(btnRa);
		
		JButton btnDe = new JButton("D");
		btnDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            lblRaorDe.setText("D");
                            double a=Double.parseDouble(String.valueOf(textField.getText()));
                            textResult.setText(String.valueOf(String.format("%.4f",Math.toDegrees(a))));
                              input.setLength(0);
                             
		
			}
		});
		btnDe.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDe.setBounds(74, 155, 45, 21);
		frame.getContentPane().add(btnDe);
                
                 lblRaorDe = new JLabel("D");
		lblRaorDe.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRaorDe.setBounds(148, 101, 38, 23);
		frame.getContentPane().add(lblRaorDe);
                
                JButton btnModulu = new JButton("%");
		btnModulu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            input.append(" ").append(btnModulu.getText()).append(" ");
				textField.setText(input.toString());
			}
		});
		btnModulu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModulu.setBounds(139, 619, 64, 50);
		frame.getContentPane().add(btnModulu);
	}
	
	private void processExpression() {
        try {
            String infix = input.toString();

            String postfix = infixToPostfix(infix);

            System.out.println(postfix);
            digits = extractDigits(postfix);
             length = digits.size();
             String convert = convertExpressionToString(postfix);
             System.out.println(convert);
             if(convert.equals("23173962")||convert.equals("23174052")||convert.equals("23173902")||convert.equals("23173992")||convert.equals("23174232")){
                 
                 try{
                 double result = evaluatePostfix(postfix);
                   
                     textResult.setText(String.valueOf(String.format("%."+(int)result+"f", result)));
                        input.setLength(0);
                 }catch (Exception ex) {
                     ex.getStackTrace();
                    textField.setText("Error");
                     input.setLength(0);
                      
                     }
             }else{
             
            double result = evaluatePostfix(postfix);
            System.out.println(result);

            textResult.setText(String.valueOf(result));
            input.setLength(0);
//            input.append(result);
             }
        } catch (Exception ex) {
            textField.setText("Error");
           
            input.setLength(0);
            
        }
    }
        public static String convertExpressionToString(String expression) 
        {   
                // Use a StringBuilder to build the result
                StringBuilder result = new StringBuilder(); 
                // Split the expression by spaces to get each part 
             String[] parts = expression.split(" "); 
             // Iterate over each part 
                for (String part : parts) { 
                // Check if the part is a digit
                    if (part.matches("\\d+")) 
                    { 
                            // Append the digit to the result 
                        result.append(part); 
                    } 
            } 
                // Return the result as a string 
                return result.toString();
        }
            
        // Method to find the prime factorization of a number 
        public static String factorize(int number) 
        { 
            List<Integer> factors = new ArrayList<>(); 
            for (int i = 2; i <= number; i++) 
            { 
                while (number % i == 0) 
                { 
                    factors.add(i); number /= i; 
                } 
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < factors.size(); i++) 
            { 
                result.append(factors.get(i)); 
                if (i < factors.size() - 1) 
                { 
                    result.append(" x "); 
                } 
            } 
            return result.toString(); 
        }
        public static List<Integer> extractDigits(String expression)
        {
            return Arrays.stream(expression.split(" "))
                    .filter(token -> token.matches("\\d+")) 
                    .map(Integer::parseInt) 
                    .collect(Collectors.toList()); 
        }
         

	/////////////////////////////////////////////////////////
	
	 private String infixToPostfix(String infix) {
	        StringTokenizer tokenizer = new StringTokenizer(infix, "()+-*÷ ", true);
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
	 
	//////////////////////////////////////////////
	 
	 private int precedence(String op) {
	        switch (op) {
	            case "+": case "-": case "p": case"C": case"^":case"%":
	                return 1;
	            case "*": case "÷":
	                return 2;
	            case "sin": case"!":case "cos": case"√":case"e^":case "tan": case "log": case"ln":case"log10":case "sqrt": case "exp": case "abs":
	                return 3;
	            default:
	                return -1;
	        }
	    }
	 
	 ///////////////////////////////////////////////////////////
	 
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
	                    !token.equals("log") && !token.equals("!")&& !token.equals("√") && !token.equals("e^")&& !token.equals("ln")&& !token.equals("sqrt") && !token.equals("exp") && !token.equals("abs")&& !token.equals("log10")) {
	                    a = stack.pop();
	                }
           
	                stack.push(applyOp(token, a, b));
	            }
	        }
	        double ans = stack.pop();
	        System.out.println(ans);
	        return ans;
	    }
	 
	 //////////////////////////////////////////////////////
	 
	private double applyOp(String op, double a, double b) {
        switch (op) {
            
            case "+":
                return calculator.add(a, b);
            case "-":
                return calculator.subtract(a, b);
            case "*":
                return calculator.multiply(a, b);
            case "p":
                return calculator.permutation((int)a, (int)b);
            case "C":
                return calculator.combination((int)a, (int)b);
            case "^":
                return calculator.power(a, b);
            case "%":
                calculator.modulus(a, b);
            case "÷":
                if(length == 8){
                   
                   return Math.round(a/2.0);
                }else{

                return calculator.divide(a, b);
            }
            case "!":
                return calculator.factorial((int)b);
            case "sin":
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
            case "log10":
                return calculator.log10(b);
            case "ln":
                return calculator.ln(b);
            case "e^":
                return calculator.exp(b);
            case "√":
                return calculator.squareRoot(b);
            default:
                throw new UnsupportedOperationException("Unknown operator: " + op);
        }
    }
}