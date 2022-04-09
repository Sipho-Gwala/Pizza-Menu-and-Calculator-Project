package pizza;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame myFrame = new JFrame();
        myFrame.setSize(500, 500);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Pizza Menu");
        myFrame.add(new PizzaPanel());
        myFrame.setVisible(true);

    }
}
