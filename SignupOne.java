
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;




public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nametextfield,fnametextfield,dobtextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pincodetextfield,pintextfield;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser datechooser;
    
    
    
     SignupOne(){
        setLayout(null);
    
      Random ran=new Random();
      random = Math.abs((ran.nextLong() % 9000L)+1000L);
      
      JLabel formno =new JLabel("Application Form No."+random);
      formno.setFont(new Font("Raleway",Font.BOLD,38));
      formno.setBounds(140,20,600,40);
      add(formno);
      
       JLabel personaldetails =new JLabel("Page 1: Personal Details.");
      personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
      personaldetails.setBounds(290,80,400,30);
      add(personaldetails);
      
       JLabel name =new JLabel("Name:");
      name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100,140,200,30);
      add(name);
      
       nametextfield = new JTextField();
      nametextfield.setFont(new Font("Raleway",Font.BOLD,20));
      nametextfield.setBounds(300,140,400,30);
      add(nametextfield);
      
      
       JLabel fname =new JLabel("Father's Name:");
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);
      add(fname);
      
        fnametextfield = new JTextField();
      fnametextfield.setFont(new Font("Raleway",Font.BOLD,20));
      fnametextfield.setBounds(300,190,400,30);
      add(fnametextfield);
      
      
       JLabel dob  =new JLabel("Date Of Birth:");
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100,240,200,30);
      add(dob);
      
       datechooser =new JDateChooser();
      datechooser.setBounds(300,240,400,30);
      datechooser.setForeground(Color.BLACK);
      add(datechooser);
     
       JLabel Gender =new JLabel("Gender:");
      Gender.setFont(new Font("Raleway",Font.BOLD,20));
      Gender.setBounds(100,290,200,30);
      add(Gender);
      
       male =new JRadioButton("Male");
      male.setBounds(300,290,60,30);
      male.setBackground(Color.WHITE);
      add(male);
      
        female =new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup =new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
      
       JLabel email =new JLabel("Email Address:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100,340,200,30);
      add(email);
      
        emailtextfield = new JTextField();
      emailtextfield.setFont(new Font("Raleway",Font.BOLD,20));
      emailtextfield.setBounds(300,340,400,30);
      add(emailtextfield);
      
       JLabel marital =new JLabel("Marital Status:");
      marital.setFont(new Font("Raleway",Font.BOLD,20));
      marital.setBounds(100,390,200,30);
      add(marital);
      
       married =new JRadioButton("Married");
      married.setBounds(300,390,100,30);
      married.setBackground(Color.WHITE);
      add(married);
      
       unmarried =new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
          other =new JRadioButton("other");
        other.setBounds(630,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(other);
         
        ButtonGroup maritalgroup = new ButtonGroup();
        gendergroup.add(married);
        gendergroup.add(unmarried);
        maritalgroup.add(other);
        
      
       JLabel address =new JLabel("Address:");
      address.setFont(new Font("Raleway",Font.BOLD,20));
      address.setBounds(100,440,200,30);
      add(address);
      
        addresstextfield = new JTextField();
      addresstextfield.setFont(new Font("Raleway",Font.BOLD,20));
      addresstextfield.setBounds(300,440,400,30);
      add(addresstextfield);
      
       JLabel city =new JLabel("City:");
      city.setFont(new Font("Raleway",Font.BOLD,20));
      city.setBounds(100,490,200,30);
      add(city);
      
       citytextfield = new JTextField();
      citytextfield.setFont(new Font("Raleway",Font.BOLD,20));
      citytextfield.setBounds(300,490,400,30);
      add(citytextfield);
      
      
      JLabel state =new JLabel("State:");
      state.setFont(new Font("Raleway",Font.BOLD,20));
      state.setBounds(100,540,200,30);
      add(state);
      
       statetextfield = new JTextField();
      statetextfield.setFont(new Font("Raleway",Font.BOLD,20));
      statetextfield.setBounds(300,540,400,30);
      add(statetextfield);
      
       JLabel pincode =new JLabel("Pin Code:");
   pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100,590,200,30);
      add(pincode);
      
       pintextfield = new JTextField();
      pintextfield.setFont(new Font("Raleway",Font.BOLD,20));
      pintextfield.setBounds(300,590,400,30);
      add(pintextfield);
      
       next=new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway",Font.BOLD,10));
      next.setBounds(700,600,80,30);
      next.addActionListener(this);
      add(next);
      
 
      getContentPane().setBackground(Color.WHITE);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }
    
    public void actionPerformed(ActionEvent ae){
        String formno="" + random;
        String name =nametextfield.getText();
        String fname =fnametextfield.getText();
        String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender =null;
        if(male.isSelected()){
            gender ="male";
        }else if(female.isSelected()){
            gender="female";
                
    }
        String email=emailtextfield.getText();
        String marital = null;
        if(married.isSelected()){
            marital="Married";
        }
        else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addresstextfield.getText();
        String city =citytextfield.getText();
        String state = statetextfield.getText();
        String pin=pintextfield.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
//            if(gender==null||dob.equals("")||fname.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||t6.getText().equals("")||t7.getText().equals("")){
//                JOptionPane.showMessageDialog(null, "Fill all the required fields");
//            }

            else if(!email.contains("@")||!email.contains(".")||email.indexOf('@')>email.indexOf('.')){
                 JOptionPane.showMessageDialog(null,"Invalid email");
                
                
            }
            
            
        
            else{
                Conn c=new Conn();
                String query = "insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                 setVisible(false);
                new SignupTwo(formno).setVisible(true);
                        
                        
                
            }
        }
            
        catch(Exception e){
            System.out.println(e);
        }
        
}
    

    
    public static void main(String args[]) {
        new SignupOne();
        
    }
}
