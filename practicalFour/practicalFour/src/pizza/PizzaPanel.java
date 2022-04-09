package pizza;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PizzaPanel extends JPanel {

    private Image image;
    private JTextArea type, topping, totalArea;
    private int total = 0, toppingAmout = 0;
    private String invalid,path,store="";
    private JComboBox<String> jcomb;
    JLabel imageLabel;


    public PizzaPanel() {
        type = new JTextArea(" Type Pizza");
        JLabel typeLable = new JLabel(" Type");
        topping = new JTextArea(1, 20);
        JLabel toppingLable = new JLabel(" Toppings");
        JButton toppingButton = new JButton("Add Toppings");
        toppingButton.setBounds(15, 5, 5, 15);
        JLabel totalLable = new JLabel(" Total");
        totalArea = new JTextArea(1, 20);
        JButton done = new JButton("Confirm");
        done.setBounds(15, 5, 5, 15);

        JPanel pan = new JPanel(new GridLayout(8, 1, 10, 10));
        this.setLayout(new GridLayout(1, 2));

        imageLabel = new JLabel();

        String[] pizza = {"Italian", "Mushroom", "Roman", "Three Cheese", "Veg Special", "Veg Standard"};
        jcomb = new JComboBox<>(pizza);
        jcomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String)jcomb.getSelectedItem();
                store = (String)jcomb.getSelectedItem();
                conversion();
                if (value.equalsIgnoreCase("Italian")) {
                    total = +100;
                } else if (value.equalsIgnoreCase("Mushroom")) {
                    total = +110;
                } else if (value.equalsIgnoreCase("Roman")) {
                    total = +120;
                } else if (value.equalsIgnoreCase("Three Cheese")) {
                    total = +130;
                } else if (value.equalsIgnoreCase("Veg Special")) {
                    total = +140;
                } else if (value.equalsIgnoreCase("Veg Standard")) {
                    total = +150;
                } else {
                    invalid = "invalid pizza";
                }
                totalArea.setText(" R" + total);
                imageLabel.setIcon(new ImageIcon(path));
            }
        });

        toppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = topping.getText();
                if (text.equalsIgnoreCase("add") || text.equalsIgnoreCase("add topping")) {
                    toppingAmout = total + 10;
                    totalArea.setText(" R" + toppingAmout);
                    total += 10;
                } else {
                    topping.setText(null);
                }
            }
        });
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String order = totalArea.getText();
                if (order.equalsIgnoreCase("")) {
                    totalArea.setText("select an order on menu");
                } else {
                    totalArea.setText(" R" + total + "\n" + "Successful ordered");
                }
            }
        });

        this.add(imageLabel);
        pan.add(typeLable);
        pan.add(jcomb);
        pan.add(toppingLable);
        pan.add(topping);
        pan.add(toppingButton);
        pan.add(totalLable);
        pan.add(totalArea);
        pan.add(done);
        this.add(pan);
    }

    public void conversion() {
        path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\italian.jpg";
        if (store.equals("Italian")) {
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\italian.jpg";
        }else if(store.equals("Mushroom")){
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\mushroom.jpg";
        }else if(store.equals("Roman")){
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\roman.jpg";
        }else if(store.equals("Three Cheese")){
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\three-cheese.jpg";
        }else if(store.equals("Veg Special")){
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\veg-special.jpg";
        }else if(store.equals("Veg Standard")){
            path = "C:\\Users\\Student\\Desktop\\PizzaMenu Proj and Calculator\\practicalFour\\practicalFour\\images\\veg-standard.jpg";
        }else{

        }
    }
}
