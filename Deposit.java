package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit, back;
    JLabel text, l3;
    String pinnumber;

    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 700, 700);
        add(l3);

        text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));

        setLayout(null);

        text.setBounds(125, 250, 300, 20);
        l3.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Ralewat", Font.BOLD, 25));
        amount.setBounds(145, 280, 250, 20);
        l3.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(300, 380, 100, 20);
        deposit.addActionListener(this);

        l3.add(deposit);

        back = new JButton("Back");
        back.setBounds(300, 410, 100, 20);
        back.addActionListener(this);
        l3.add(back);

        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(" ")){
      JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
      

        }
            
                else{
                try{
                Conn c1 = new Conn();
                    String query ="insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
                
            }
                
            }
            
            // Add logic for deposit button click
            
        } else if (ae.getSource() == back) {
            setVisible(false);
            // Create a new instance of Transactions instead of Deposit
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit(" ");
    }
}
