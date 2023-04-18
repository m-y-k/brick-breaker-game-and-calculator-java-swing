package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton numberButtons[] = new JButton[10];
    JButton functionButtons[] = new JButton[9];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton decimalButton, equalsToButton, deleteButton, clearButton, negativeButton;
    JPanel numberPanel;
    Panel bottomPanel;
    Font myFont = new Font("Ink free",Font.BOLD,30); /// Baskerville Old Face, Ink free
    double operator1 = 0, operator2 = 0, result = 0;
    char operator;
    public void paint(Graphics g) {
        // background
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);
    }
    Calculator() {
        // launching a frame here
        frame = new JFrame("Calculator!!");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 202, 251, 190
        frame.setBounds(450,130,500, 500);
        frame.getContentPane().setBackground(new java.awt.Color(192,192,192));
        // 255, 230, 192
        frame.setLayout(null);

        // image icon
        ImageIcon image = new ImageIcon("icon.jpg");
        frame.setIconImage(image.getImage());

        // textfield for input
        textfield = new JTextField();
        textfield.setBounds(70, 10, 340, 70);
        textfield.setFont(myFont);
        textfield.setBackground(new java.awt.Color(255, 255, 224)); // 255, 255, 224
        textfield.setEditable(false);

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsToButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("AC");
        negativeButton = new JButton("-ve");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsToButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for(int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setBackground(new Color(224, 224, 224));
            functionButtons[i].setBorder(BorderFactory.createEtchedBorder());
            functionButtons[i].setFocusable(false);
        }
        // coloring decimalButton
        functionButtons[4].setBackground(new java.awt.Color( 200, 230, 200));
        // lower row
        functionButtons[6].setBackground(new java.awt.Color(255, 204, 255));
        functionButtons[8].setBackground(new java.awt.Color(255, 204, 255));
        // coloring allClearButton
        functionButtons[7].setBackground(new java.awt.Color(255, 153, 153));
        // coloring equalsToButton separately
        functionButtons[5].setBackground(new java.awt.Color(255, 255, 204));

        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setBackground(new java.awt.Color( 204, 255, 255));
            numberButtons[i].setBorder(BorderFactory.createEtchedBorder());
            numberButtons[i].setFocusable(false);
        }

        // numbers
        numberPanel = new JPanel();
        numberPanel.setBounds(110, 85, 300, 300);
        numberPanel.setLayout(new GridLayout(4,4,5,5));
        // numbers backgroung color
        numberPanel.setBackground(new java.awt.Color(192,192,192)); // 202, 251, 190

        // bottom keys
        bottomPanel = new Panel();
        bottomPanel.setBounds(110, 390, 300, 55);
        bottomPanel.setLayout(new GridLayout(1,3,10,10));

        numberPanel.add(divisionButton);
        numberPanel.add(numberButtons[7]);
        numberPanel.add(numberButtons[8]);
        numberPanel.add(numberButtons[9]);

        numberPanel.add(multiplicationButton);
        numberPanel.add(numberButtons[4]);
        numberPanel.add(numberButtons[5]);
        numberPanel.add(numberButtons[6]);

        numberPanel.add(subtractionButton);
        numberPanel.add(numberButtons[1]);
        numberPanel.add(numberButtons[2]);
        numberPanel.add(numberButtons[3]);

        numberPanel.add(additionButton);
        numberPanel.add(numberButtons[0]);
        numberPanel.add(decimalButton);
        numberPanel.add(equalsToButton);

        frame.add(numberPanel);
        bottomPanel.add(negativeButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);
        frame.add(bottomPanel);

        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()== decimalButton) {
            String text = textfield.getText();
            int decimal = 0;
            for (int i = 0; i < text.length(); i++)
                if (text.charAt(i) == '.') decimal++;
            if (decimal == 0)
                textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == additionButton)
            operation(textfield.getText(), '+');

        if(e.getSource() == subtractionButton)
            operation(textfield.getText(), '-');

        if(e.getSource() == multiplicationButton)
            operation(textfield.getText(), '*');

        if(e.getSource() == divisionButton)
            operation(textfield.getText(), '/');

        if(e.getSource() == equalsToButton) {
            operator2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case'+':
                    result = operator1 + operator2;
                    break;
                case'-':
                    result = operator1 - operator2;
                    break;
                case'*':
                    result = operator1 * operator2;
                    break;
                case'/':
                    result = operator1 / operator2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            operator1 = result;
        }
        if(e.getSource() == clearButton) {
            textfield.setText("");
        }
        if(e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText(string.substring(0,string.length() - 1));
        }
        if(e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp = -temp;
            textfield.setText(String.valueOf(temp));
        }
    }

    private void operation (String number, char operator) {
        if (number.length() != 0) {
            operator1 = Double.parseDouble(number);
            this.operator = operator;
            textfield.setText("");
        }
    }
}