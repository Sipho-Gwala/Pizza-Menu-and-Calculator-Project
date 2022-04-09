package guiTutorial;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyImagePanel extends JPanel {
	private Image image;
	
	public MyImagePanel(){
		try {
			image = ImageIO.read(new File("images/italian.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image == null)
			return;

		// draw the image in the upper-left corner

		g.drawImage(image, 10, 10,640,427, null);

        
     }
}
