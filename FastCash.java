
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,ministatement,pinchange,fastcash,balanceEnquiry,Exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text =new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(150,250,700,25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        
        image.add(text);
        
         deposit =new JButton("Rs 100");
       deposit.setBounds(150, 320, 100, 20);
       deposit.addActionListener(this);
       image.add(deposit);
       
        
      withdrawl =new JButton("Rs 500");
       withdrawl.setBounds(280, 320, 130, 20);
        withdrawl.addActionListener(this);

       image.add(withdrawl);
       
        fastcash =new JButton("Rs 1000");
       fastcash.setBounds(150, 350, 100, 20);
        fastcash.addActionListener(this);

       image.add(fastcash);
       
        ministatement =new JButton("Rs 2000");
       ministatement.setBounds(275, 350, 130, 20);
        ministatement.addActionListener(this);

       image.add(ministatement);
       
       pinchange =new JButton("Rs 5000");
     pinchange.setBounds(150, 380, 115, 20);
     pinchange.addActionListener(this);

   image.add(pinchange);
      
      
       balanceEnquiry =new JButton("Rs 10000");
      balanceEnquiry.setBounds(280, 380, 130, 20);
        balanceEnquiry.addActionListener(this);
       image.add( balanceEnquiry);
   
    Exit =new JButton("BACK");
    Exit.setBounds(280, 410, 115, 20);
     Exit.addActionListener(this);  
   image.add(Exit);
    
        
        
        setSize(700,700);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        
        
    }

  
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Exit){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
         
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                
                ResultSet rs =  c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt((String) rs.getString("amount"));
                        
                        
                    
            }
                    else{
                        balance-=Integer.parseInt((String) rs.getString("amount"));
                    }
            }
                if(ae.getSource()!=Exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance ");
                    return;
                    
                }
               Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs "+amount +"Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }   
        
        
    }
   
    public static void main(String args[]) {
        new FastCash("");
    }

   
}

    

