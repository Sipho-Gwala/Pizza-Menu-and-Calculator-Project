/*
 * Created on Feb 29, 2004
 * 
 */
package guiTutorial;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Presenter
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CalcPanelInner extends JPanel {
	JTextField xInput, yInput; // Input boxes for the numbers.
	JTextField answer;	// for displaying the answer, or an error message if appropriate.

	CalcPanelInner() {

		//Create the JLabel and JTextField for the first number (x input)
		xInput = new JTextField(); //will contain 0 by default
		JLabel xLabel = new JLabel("   X    =    ");	//The argument to the JLabel constructor is the string we want the label to contain.
		//Create a JPanel to hold this TextField and label
		JPanel xPanel = new JPanel();
		//Set the layout of the xPanel to BorderLayout.
		xPanel.setLayout(new BorderLayout());
		//now add the textfield and the label
		xPanel.add(xLabel, BorderLayout.WEST);	//the label must be to the west of centre of the xPanel
		xPanel.add(xInput,BorderLayout.CENTER);
	
		//Create the JLabel and JTextField for y input
		yInput = new JTextField();
		JLabel yLabel = new JLabel("   Y    =    ");
		JPanel yPanel = new JPanel();
		yPanel.setLayout(new BorderLayout());
		yPanel.add(yLabel, BorderLayout.WEST);
		yPanel.add(yInput,BorderLayout.CENTER);
		
		//Create the JLabel and JTextField for the answer
		answer = new JTextField(" ");
		answer.setEditable(false);
		JLabel answerLabel = new JLabel("  ANSWER  :  ");
		JPanel answerPanel = new JPanel();
		answerPanel.setLayout(new BorderLayout());
		answerPanel.add(answerLabel, BorderLayout.WEST);
		answerPanel.add(answer,BorderLayout.CENTER);
		
		//Create a Listener object
		ActionListener command = new CommandAction();
		
		//Create the panel of buttons			  
		JPanel buttonPanel = new JPanel();
		//We�ll use another layout called grid layout.  
		//We need to specify the number of rows (1) and number of columns (4) for our grid.
		buttonPanel.setLayout(new GridLayout(1, 4));
		//Now create the four buttons and add each one to the buttonPanel
		JButton plus = new JButton("+");
		plus.addActionListener(command);
		buttonPanel.add(plus);

		JButton minus = new JButton("-");
		buttonPanel.add(minus);
		minus.addActionListener(command);
		
		JButton times = new JButton("*");
		buttonPanel.add(times);
		times.addActionListener(command);
		
		JButton div = new JButton("/");
		buttonPanel.add(div);
		div.addActionListener(command);
		
		//Set up the calcPanel
		setLayout(new GridLayout(4,1,3,3));
		add(answerPanel);
		add(xPanel);
		add(yPanel);
		add(buttonPanel);
		setSize(50,50);
		setVisible(true);
	}

	private class CommandAction implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				
				
				// When the user clicks a button, get the numbers
						 // from the input boxes and perform the operation
						 // indicated by the button.  Put the result in
						 // the answer label.  If an error occurs, an
						 // error message is put in the label.
   
					double x, y;  // The numbers from the input boxes.
      
					/* Get a number from the xInput TextField.  Use 
					   xInput.getText() to get its contents as a String.
					   Convert this String to a double.  The try...catch
					   statement will check for errors in the String.  If 
					   the string is not a legal number, the error message
					   "Illegal data for x." is put into the answer and
					   the actionPerformed() method ends. */

					try {
					   String xStr = xInput.getText();
					   x = Double.parseDouble(xStr);
					}
					catch (NumberFormatException e) {
						  // The string xStr is not a legal number.
					   answer.setText("Illegal data for x.");
					   return;
					}
      
					/* Get a number from yInput in the same way. */

					try {
					   String yStr = yInput.getText();
					   y = Double.parseDouble(yStr);
					}
					catch (NumberFormatException e) {
					   answer.setText("Illegal data for y.");
					   return;
					}
      
					/* Perfrom the operation based on the action command
					   from the button.  Note that division by zero produces
					   an error message. */

					String op = evt.getActionCommand();
					if (op.equals("+"))
					   answer.setText( x+" + "+y+" = " + (x+y) );
					else if (op.equals("-"))
					   answer.setText( x+" -"+ y +"= " + (x-y) );
					else if (op.equals("*"))
					   answer.setText( x+" * "+ y+" = " + (x*y) );
					else if (op.equals("/")) {
					   if (y == 0)
						  answer.setText("Can't divide by zero!");
					   else
						  answer.setText( x+" / "+ y +" = " + (x/y) );
					}
			}
	}



}
