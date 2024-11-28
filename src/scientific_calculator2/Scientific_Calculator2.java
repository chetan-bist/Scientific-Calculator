package Scientific_Calculator2;

import java.awt.EventQueue;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Scientific_Calculator2 {

	double ans;
	private JFrame frame;
	private JTextField txtname;
	private JTextField txtresult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scientific_Calculator2 window = new Scientific_Calculator2();
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
	public Scientific_Calculator2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
             // Create a ScriptEngineManager
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get the JavaScript engine
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		txtname = new JTextField();
		txtname.setBounds(0, 10, 426, 64);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		String s;
		JLabel lblresult = new JLabel("");
		
		JButton btn1 = new JButton("1");
		s = btn1.getText();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btn1.getText();
				txtname.setText(number);
			}
		});
		btn1.setBounds(47, 132, 85, 21);
		frame.getContentPane().add(btn1);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btn3.getText();
				txtname.setText(number);
				
			}
		});
		btn3.setBounds(47, 173, 85, 21);
		frame.getContentPane().add(btn3);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btn2.getText();
				txtname.setText(number);
				
			}
		});
		btn2.setBounds(159, 132, 85, 21);
		frame.getContentPane().add(btn2);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btn4.getText();
				txtname.setText(number);
				
			}
		});
		btn4.setBounds(159, 163, 85, 21);
		frame.getContentPane().add(btn4);
		
		JButton btnshift = new JButton("shift");
		btnshift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnshift.setBounds(10, 98, 85, 21);
		frame.getContentPane().add(btnshift);
		
		JButton btnshow = new JButton("=");
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String expression = txtname.getText();
//                                Object ans = engine.eval(name);
				
                                try {
                        // Evaluate a simple mathematical expression
            
//                            Object result = engine.eval(name);

                        // Print the result
//                             System.out.println("Result: " + result);
//                            txtresult.setText(result.toString());
                            
                            //new featuer
                            expression = expression.replaceAll("sin\\((.*?)\\)", "Math.sin(Math.toRadians($1))");
                    expression = expression.replaceAll("cos\\((.*?)\\)", "Math.cos(Math.toRadians($1))");
                    expression = expression.replaceAll("tan\\((.*?)\\)", "Math.tan(Math.toRadians($1))");

                    // Use ScriptEngine to evaluate the expression
                    ScriptEngineManager manager = new ScriptEngineManager();
                    ScriptEngine engine = manager.getEngineByName("JavaScript");

                    // Evaluate the expression
                    Object result = engine.eval(expression);
                    txtresult.setText(result.toString());
                             } catch (ScriptException se) {
                                 se.printStackTrace();
                            }
			}
		});
		btnshow.setBounds(296, 163, 85, 21);
		frame.getContentPane().add(btnshow);
		
		
		lblresult.setBounds(0, 46, 426, 28);
		frame.getContentPane().add(lblresult);
		
		txtresult = new JTextField();
		txtresult.setBounds(0, 55, 426, 19);
		frame.getContentPane().add(txtresult);
		txtresult.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(57, 150, 85, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnopen = new JButton("(");
		btnopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btnopen.getText();
				txtname.setText(number);
			}
		});
		btnopen.setBounds(98, 98, 85, 21);
		frame.getContentPane().add(btnopen);
		
		JButton btnclose = new JButton(")");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btnclose.getText();
				txtname.setText(number);
			}
		});
		btnclose.setBounds(193, 98, 85, 21);
		frame.getContentPane().add(btnclose);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtname.getText()+btnAdd.getText();
				txtname.setText(number);
			}
		});
		btnAdd.setBounds(296, 98, 85, 21);
		frame.getContentPane().add(btnAdd);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

