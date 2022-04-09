package guiTutorial;

import javax.swing.*;
import java.awt.image.ImagingOpException;
import java.io.IOException;

public class MyImagePanelApp {

	public static void main(String[] args)throws IOException {
		JFrame myFrame = new JFrame();
		myFrame.setSize(1024, 768);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setTitle("MyPanel");
		myFrame.add(new MyImagePanel());
		myFrame.setVisible(true);

	}

}
