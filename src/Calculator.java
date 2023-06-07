
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] numbtn = new JButton[10];
    JButton[] funcbtn = new JButton[10];
    JButton addbtn, mulbtn, divbtn, subbtn;
    JButton equbtn, decbtn, delbtn, clrbtn, sqrtbtn, minbtn;
    JPanel panel;

    Font myfont = new Font("Helvectica",Font.BOLD, 20);
    double num1 = 0, num2 = 0, result = 0;
    char operation;

    Calculator(){
     frame = new JFrame("Calculator");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(475,550);
     frame.setLayout(null);

     textfield = new JTextField();
     textfield.setBounds(25,25,400,50);
     textfield.setFont(myfont);
     textfield.setEditable(false);
     
     addbtn = new JButton("+");
     subbtn = new JButton("-");
     mulbtn = new JButton("*");
     divbtn = new JButton("/");
     sqrtbtn = new JButton("SQR");
     minbtn = new JButton("~");
     equbtn = new JButton("=");
     decbtn = new JButton(".");
     delbtn = new JButton("<-");
     clrbtn = new JButton("AC");

     funcbtn[0] = addbtn;
     funcbtn[1] = subbtn;
     funcbtn[2] = mulbtn;
     funcbtn[3] = divbtn;
     funcbtn[4] = equbtn;
     funcbtn[5] = sqrtbtn;
     funcbtn[6] = minbtn;
     funcbtn[7] = decbtn;
     funcbtn[8] = delbtn;
     funcbtn[9] = clrbtn;
     
     for(int i=0;i<10;i++){
        funcbtn[i].addActionListener(this);
        funcbtn[i].setFont(myfont);
        //funcbtn[i].setBackground(Color.);
        funcbtn[i].setFocusable(false);
     }

     for(int i=0;i<10;i++){
        numbtn[i] = new JButton(String.valueOf(i));
        numbtn[i].addActionListener(this);
        numbtn[i].setFont(myfont);
        numbtn[i].setFocusable(false);
     }


     panel = new JPanel();
     panel.setBounds(25,100,400,350);
     panel.setLayout(new GridLayout(5,4,5,5));
     panel.setBackground(Color.GRAY);

     panel.add(numbtn[1]);
     panel.add(numbtn[2]);
     panel.add(numbtn[3]);
     panel.add(addbtn);
     panel.add(numbtn[4]);
     panel.add(numbtn[5]);
     panel.add(numbtn[6]);
     panel.add(subbtn);
     panel.add(numbtn[7]);
     panel.add(numbtn[8]);
     panel.add(numbtn[9]);
     panel.add(mulbtn);
     panel.add(numbtn[0]);
     panel.add(decbtn);
     panel.add(sqrtbtn);
     panel.add(divbtn);
     panel.add(minbtn);
     panel.add(delbtn);
     panel.add(clrbtn);
     panel.add(equbtn);
     
     

     
     frame.add(panel);
     frame.add(textfield);
     frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
      for(int i=0;i<10;i++){
        if(e.getSource() == numbtn[i]){
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
      }
      
      if(e.getSource() == decbtn){
        textfield.setText(textfield.getText().concat("."));
      }

       if(e.getSource() == addbtn){
        num1 = Double.parseDouble(textfield.getText());
        operation = '+';
        textfield.setText("");
      }

      if(e.getSource() == subbtn){
        num1 = Double.parseDouble(textfield.getText());
        operation = '-';
        textfield.setText("");
      }

      if(e.getSource() == mulbtn){
        num1 = Double.parseDouble(textfield.getText());
        operation = '*';
        textfield.setText("");
      }
      
      if(e.getSource() == divbtn){
        num1 = Double.parseDouble(textfield.getText());
        operation = '/';
        textfield.setText("");
      }

      if(e.getSource() == sqrtbtn){
        num1 = Double.parseDouble(textfield.getText());
        result = Math.sqrt(num1);
      }

      if(e.getSource() == minbtn){
        num1 = Double.parseDouble(textfield.getText());
        result = -num1;
      }
      
      
      if(e.getSource() == equbtn){
        num2 = Double.parseDouble(textfield.getText());
             switch(operation){
                case'+':
                result = num1 + num2;
                break;
                case'-':
                result = num1 - num2;
                break;
                case'*':
                result = num1 * num2;
                break;
                case'/':
                result = num1 / num2;
                break;

             }

             textfield.setText(String.valueOf(result));
             num1 = result;
      }

      if(e.getSource() == clrbtn){
        textfield.setText("");
      }
      
      if(e.getSource() ==  delbtn){
        String str = textfield.getText();
        textfield.setText("");

        for(int i=0;i<str.length()-1;i++){
            textfield.setText(textfield.getText()+ str.charAt(i));
        }
      }


    }
}
