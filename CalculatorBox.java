import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorBox extends JFrame implements ActionListener {

    JPanel control;
    JPanel row1;
    JPanel row2;
    JPanel row3;
    JPanel row4;
    JPanel row5;

    JPanel showInput;
    JTextField textField;

    JButton add = new JButton("+");
    JButton clear = new JButton("AC");
    JButton delete = new JButton("D");
    JButton subtract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton egualTo = new JButton("=");
    JButton dot = new JButton(".");


    JButton[] numbers = new JButton[10];
    String[] name = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    CalculatorBox(){
        clear.setFocusable(false);
        clear.setFont(new Font("serif",Font.ITALIC,30));
        clear.setBackground(Color.black);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.setForeground(Color.orange);

        delete.setFocusable(false);
        delete.setFont(new Font("serif",Font.PLAIN,30));

        add.setFocusable(false);
        add.setFont(new Font("serif",Font.PLAIN,30));

        subtract.setFocusable(false);
        subtract.setFont(new Font("serif",Font.PLAIN,30));

        multiply.setFocusable(false);
        multiply.setFont(new Font("serif",Font.PLAIN,30));

        divide.setFocusable(false);
        divide.setFont(new Font("serif",Font.PLAIN,30));

        dot.setFocusable(false);
        dot.setFont(new Font("serif",Font.PLAIN,30));

        egualTo.setFocusable(false);
        egualTo.setFont(new Font("serif",Font.PLAIN,30));


        control = new JPanel();
        control.setPreferredSize(new Dimension(600,480));
        control.setBackground(Color.darkGray);
        control.setLayout(new GridLayout(5,1,0,0));

        row1 = new JPanel();
        row1.setLayout(new GridLayout(1,4));
        row1.setBackground(Color.gray);

        row2 = new JPanel();
        row2.setLayout(new GridLayout(1,4));
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
            numbers[i].setFont(new Font("serif",Font.PLAIN,30));
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
        row5.add(dot);
        row5.add(numbers[0]);
        row5.add(egualTo);
        row5.add(divide);

        control.add(row1);
        control.add(row2);
        control.add(row3);
        control.add(row4);
        control.add(row5);

        showInput = new JPanel();
        showInput.setPreferredSize(new Dimension(650,120));
        showInput.setBackground(new Color(190,150,0));
        showInput.setLayout(new GridLayout(1,1));

        textField = new JTextField(1);
        textField.setFont(new Font("serif",Font.PLAIN,35));
        textField.setForeground(Color.black);
        showInput.add(textField);


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
    public void actionPerformed(ActionEvent e) {

    }
}
