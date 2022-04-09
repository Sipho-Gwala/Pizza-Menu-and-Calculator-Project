package guiTutorial;

import javax.swing.*;

public class CalcPanelApp {

	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setSize(350,350);
		myFrame.setTitle("Simple Calculator");
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(new CalcPanelInner());
		myFrame.setVisible(true);

	}

}
