import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CalculatorBox extends JFrame implements ActionListener {

        Double a;
        String theResult;

        ArrayList<Double> noEntered = new ArrayList<>();

        String operator = "null";

        JPanel control;
        JPanel row1;
        JPanel row2;
        JPanel row3;
        JPanel row4;
        JPanel row5;

        JPanel showInput;
        JTextField textField;
        JPanel answerPanel;
        JLabel answer;

        JButton add = new JButton("+");
        JButton clear = new JButton("AC");
        JButton delete = new JButton("D");
        JButton subtract = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton equalTo = new JButton("=");
        //JButton dot = new JButton(".");


        JButton[] numbers = new JButton[11];
        String[] name = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};

        CalculatorBox() {

        clear.setFocusable(false);
        clear.setFont(new Font("serif", Font.ITALIC, 30));
        clear.setBackground(Color.black);
        clear.setOpaque(true);
        clear.addActionListener(this);
        clear.setBorderPainted(false);
        clear.setForeground(Color.orange);

        delete.setFocusable(false);
        delete.addActionListener(this);
        delete.setFont(new Font("serif", Font.PLAIN, 30));

        add.setFocusable(false);
        add.addActionListener(this);
        add.setFont(new Font("serif", Font.PLAIN, 30));

        subtract.setFocusable(false);
        subtract.addActionListener(this);
        subtract.setFont(new Font("serif", Font.PLAIN, 30));

        multiply.setFocusable(false);
        multiply.addActionListener(this);
        multiply.setFont(new Font("serif", Font.PLAIN, 30));

        divide.setFocusable(false);
        divide.addActionListener(this);
        divide.setFont(new Font("serif", Font.PLAIN, 30));

        equalTo.setFocusable(false);
        equalTo.addActionListener(this);
        equalTo.setFont(new Font("serif", Font.PLAIN, 30));

        control = new JPanel();
        control.setPreferredSize(new Dimension(600, 480));
        control.setBackground(Color.darkGray);
        control.setLayout(new GridLayout(5, 1, 0, 0));

        row1 = new JPanel();
        row1.setLayout(new GridLayout(1, 4));
        row1.setBackground(Color.gray);

        row2 = new JPanel();
        row2.setLayout(new GridLayout(1, 4));
        row2.setBackground(Color.gray);

        row3 = new JPanel();
        row3.setLayout(new GridLayout());
        row3.setBackground(Color.gray);

        row4 = new JPanel();
        row4.setLayout(new GridLayout());
        row4.setBackground(Color.gray);

        row5 = new JPanel();
        row5.setLayout(new GridLayout());
        row5.setBackground(Color.gray);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new JButton(name[i]);
            numbers[i].addActionListener(this);
            numbers[i].setFocusable(false);
            numbers[i].setFont(new Font("serif", Font.PLAIN, 30));
            numbers[i].setForeground(Color.black);
            //control.add(numbers[i]);

        }


        row1.add(delete);
        row1.add(clear);
        row2.add(numbers[7]);
        row2.add(numbers[8]);
        row2.add(numbers[9]);
        row2.add(multiply);
        row3.add(numbers[4]);
        row3.add(numbers[5]);
        row3.add(numbers[6]);
        row3.add(subtract);
        row4.add(numbers[1]);
        row4.add(numbers[2]);
        row4.add(numbers[3]);
        row4.add(add);
        row5.add(numbers[10]);
        row5.add(numbers[0]);
        row5.add(equalTo);
        row5.add(divide);

        control.add(row1);
        control.add(row2);
        control.add(row3);
        control.add(row4);
        control.add(row5);

        showInput = new JPanel();
        showInput.setPreferredSize(new Dimension(650, 120));
        showInput.setBackground(new Color(190, 150, 0));
        showInput.setLayout(new BorderLayout());

        textField = new JTextField("");
        textField.setFont(new Font("serif", Font.PLAIN, 50));
        textField.setForeground(Color.black);

        answerPanel = new JPanel();
        answerPanel.setLayout(new BorderLayout());
        answerPanel.setBackground(new Color(190, 150, 0));

        answer = new JLabel("");
        answer.setFont(new Font("serif", Font.PLAIN, 50));
        //answer.setHorizontalTextPosition(600);
        answer.setForeground(Color.black);

        answerPanel.add(answer, BorderLayout.EAST);

        showInput.add(textField, BorderLayout.NORTH);
        showInput.add(answerPanel, BorderLayout.SOUTH);


        this.setTitle("INCH CALCULATOR");
        this.setSize(450, 700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(showInput, BorderLayout.NORTH);
        this.add(control, BorderLayout.CENTER);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed (ActionEvent e){

        for (JButton btn : numbers) {
            JButton selectedBtn = (JButton) e.getSource();
            if (selectedBtn == btn) {
                add.setEnabled(true);
                subtract.setEnabled(true);
                divide.setEnabled(true);
                multiply.setEnabled(true);
                appendToOutput(btn.getText());
            }
        }

        if (e.getSource() == delete) {
            int len = textField.getText().length();
            textField.setText(textField.getText().substring(0, len - 1));
        }

        else if (e.getSource() == clear) {
            noEntered.clear();
            textField.setText("");
            answer.setText("");
            operator = "null";
        }

        else if (e.getSource() == add) {
            if (operator.equalsIgnoreCase("add") || operator.equalsIgnoreCase("null")) {
                operator = "add";
                try {
                    a = Double.parseDouble(textField.getText());
                } catch (NumberFormatException q) {
                    System.out.print(".");
                }
                noEntered.add(a);
                textField.setText("");
                if (noEntered.size() < 2) {
                    noEntered.add(0.0);
                }
                Calculate(noEntered);
            }
            else if (!operator.equalsIgnoreCase("add")){
                a = Double.parseDouble(textField.getText());
                noEntered.add(a);
                textField.setText("");
                Calculate(noEntered);
            }
            operator = "add";
        }

        else if (e.getSource() == subtract) {
            if (operator.equalsIgnoreCase("-") || operator.equalsIgnoreCase("null")) {
                operator = "-";
                try {
                    a = Double.parseDouble(textField.getText());
                } catch (NumberFormatException q) {
                    System.out.print(".");
                }
                noEntered.add(a);
                textField.setText("");
                if (noEntered.size() < 2) {
                    noEntered.add(0.0);
                }
                Calculate(noEntered);
            }
            else if (!operator.equalsIgnoreCase("-")){
                a = Double.parseDouble(textField.getText());
                noEntered.add(a);
                textField.setText("");
                Calculate(noEntered);
            }
            operator = "-";
        }

        else if (e.getSource() == multiply) {
            if (operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("null")) {
                operator = "*";
                try {
                    a = Double.parseDouble(textField.getText());
                } catch (NumberFormatException q) {
                    System.out.print(".");
                }
                noEntered.add(a);
                textField.setText("");
                if (noEntered.size() < 2) {
                    noEntered.add(1.0);
                }
                Calculate(noEntered);
            }
            else if (!operator.equalsIgnoreCase("*")){
                a = Double.parseDouble(textField.getText());
                noEntered.add(a);
                textField.setText("");
                Calculate(noEntered);
            }
            operator = "*";
        }

        else if (e.getSource() == divide) {
            if (operator.equalsIgnoreCase("/") || operator.equalsIgnoreCase("null")) {
                operator = "/";
                try {
                    a = Double.parseDouble(textField.getText());
                } catch (NumberFormatException q) {
                    System.out.print(".");
                }
                noEntered.add(a);
                textField.setText("");
                if (noEntered.size() < 2) {
                    noEntered.add(1.0);
                }
                Calculate(noEntered);
            }
            else if (!operator.equalsIgnoreCase("/")){
                a = Double.parseDouble(textField.getText());
                noEntered.add(a);
                textField.setText("");
                Calculate(noEntered);
            }
            operator = "/";
        }

        else if (e.getSource() == equalTo) {
            try {
                a = Double.parseDouble(textField.getText());
            } catch (NumberFormatException q){
                System.out.print("");
            }
            noEntered.add(a);
            textField.setText("");
            if (noEntered.size() < 2) {
                noEntered.add(0.0);
            }
            Calculate(noEntered);
            noEntered.clear();
            add.setEnabled(false);
            subtract.setEnabled(false);
            divide.setEnabled(false);
            multiply.setEnabled(false);
            operator = "null";
        } else {
            //System.out.println(e.getSource());
        }
    }



    private void appendToOutput (String text){

        String current = textField.getText();
        String result = current + text;

        textField.setText(result);
    }


    private void Calculate (ArrayList<Double> arrayList){

        if (operator.equalsIgnoreCase("add")) {
            double c = arrayList.get(0);
            //System.out.println(c);
            double d = arrayList.get(1);

            double e = c + d;
            arrayList.set(0, e);
            arrayList.remove(1);

            double y = arrayList.get(0);
            theResult = Double.toString(y);

            // textField.setText(theResult);

            answer.setText(process(theResult));
            // System.out.println(theResult);
        } else if (operator.equalsIgnoreCase("-")) {
            double c = arrayList.get(0);
            double d = arrayList.get(1);

            double e = c - d;
            arrayList.set(0, e);
            arrayList.remove(1);

            double y = arrayList.get(0);
            theResult = Double.toString(y);

            // textField.setText(theResult);

            answer.setText(process(theResult));
            // System.out.println(theResult);
        } else if (operator.equalsIgnoreCase("*")) {
            double c = arrayList.get(0);
            double d = arrayList.get(1);

            double e = c * d;
            arrayList.set(0, e);
            arrayList.remove(1);

            double y = arrayList.get(0);
            theResult = Double.toString(y);

            // textField.setText(theResult);

            answer.setText(process(theResult));
            // System.out.println(theResult);
        } else if (operator.equalsIgnoreCase("/")) {
            double c = arrayList.get(0);
            double d = arrayList.get(1);

            double e = c / d;
            arrayList.set(0, e);
            arrayList.remove(1);

            double y = arrayList.get(0);
            theResult = Double.toString(y);

            // textField.setText(theResult);

            answer.setText(process(theResult));
            // System.out.println(theResult);
        }
        else {
            System.out.println("unexpected error");
        }

    }


    public String process (String theResult){
        if (theResult.length() > 0) {
            String integerPart = theResult.split("\\.")[0];
            String decimalPart = theResult.split("\\.")[1];
            if (decimalPart.equals("0")) {
                theResult = integerPart;

            }
        }
        return theResult;
    }


    }
