
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceEnquiry,Exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text =new JLabel("Please select your Transaction");
        text.setBounds(150,250,700,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        
        image.add(text);
        
         deposit =new JButton("Deposit");
       deposit.setBounds(150, 320, 100, 20);
       deposit.addActionListener(this);
       image.add(deposit);
       
        
      withdrawl =new JButton("Cash Withdrawl");
       withdrawl.setBounds(280, 320, 130, 20);
        withdrawl.addActionListener(this);

       image.add(withdrawl);
       
        fastcash =new JButton("Fast Cash");
       fastcash.setBounds(150, 350, 100, 20);
        fastcash.addActionListener(this);

       image.add(fastcash);
       
        ministatement =new JButton("Mini Statement");
       ministatement.setBounds(275, 350, 130, 20);
        ministatement.addActionListener(this);

       image.add(ministatement);
       
       pinchange =new JButton("Pin Change");
     pinchange.setBounds(150, 380, 115, 20);
     pinchange.addActionListener(this);

   image.add(pinchange);
      
      
       balanceEnquiry =new JButton("Balance Enquiry");
      balanceEnquiry.setBounds(280, 380, 130, 20);
        balanceEnquiry.addActionListener(this);
       image.add( balanceEnquiry);
   
    Exit =new JButton("Exit");
    Exit.setBounds(280, 410, 115, 20);
     Exit.addActionListener(this);  
   image.add(Exit);
    
        
        
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        
        
    }

  
    
    public void actionPerformed(ActionEvent ae){
        Object balanceenquiry = null;
        if(ae.getSource()==Exit){
            System.exit(0);
            
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
            
            
        }else if(ae.getSource()==ministatement){
           // setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
            
        }
        
    }

   
    public static void main(String args[]) {
        new Transactions("").setVisible(true);
        
    }

   
}

    

