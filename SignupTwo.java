
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField aadhar,pan;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,category,Occupation,education,income;  
    String formno;
    
     SignupTwo(String formno){
         this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
       JLabel additionaldetails =new JLabel("Page 2: Additional Details.");
      additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
      additionaldetails.setBounds(290,80,400,30);
      add(additionaldetails);
      
       JLabel name =new JLabel("Religion:");
      name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100,140,200,30);
      add(name);
      
      String valReligion[]={"Hindu","Muslim","Sikh","Christan","Other"};
       religion =new JComboBox(valReligion);
       religion.setBounds(300,140,400,30);
       religion.setBackground(Color.WHITE);
      add(religion);
    
      
      
       JLabel fname =new JLabel("Category:");
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);
      add(fname);
      
      
      String valCategory[]={"General","OBC","SC","ST","Other"};
      category =new JComboBox(valCategory);
      category.setBounds(300,190,400,30);
      add(category);
      
      
       String incomeCategory[]={"null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
      income =new JComboBox(incomeCategory);
      income.setBounds(300,240,400,30);
      add(income);
  
     
       JLabel Gender =new JLabel("Educational");
      Gender.setFont(new Font("Raleway",Font.BOLD,20));
      Gender.setBounds(100,290,200,30);
      add(Gender);
      
       
       JLabel email =new JLabel("Qualification:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100,315,200,30);
      add(email);
      
       String educationalValues[]={"Non Graduate","Graduate","Post-graduate","Doctorate","Other"};
       education =new JComboBox(educationalValues);
      education.setBounds(300,315,400,30);
      add(education);
      
 
       JLabel occupation =new JLabel("Occupation:");
     occupation.setFont(new Font("Raleway",Font.BOLD,20));
      occupation.setBounds(100,390,200,30);
      add(occupation);
      
        String OccupationalValues[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
      Occupation =new JComboBox( OccupationalValues);
      Occupation.setBounds(300,390,400,30);
      add(Occupation);
      
 
      
       JLabel address =new JLabel("Pan no:");
      address.setFont(new Font("Raleway",Font.BOLD,20));
      address.setBounds(100,440,200,30);
      add(address);
      
        pan = new JTextField();
      pan.setFont(new Font("Raleway",Font.BOLD,20));
      pan.setBounds(300,440,400,30);
      add(pan);
      
       JLabel aadharno =new JLabel("adhar no:");
      aadharno.setFont(new Font("Raleway",Font.BOLD,20));
      aadharno.setBounds(100,490,200,30);
      add(aadharno);
      
       aadhar = new JTextField();
      aadhar.setFont(new Font("Raleway",Font.BOLD,20));
      aadhar.setBounds(300,490,400,30);
      add(aadhar);
      
      
      JLabel seniorcitizen =new JLabel("Senior citizen:");
      seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
      seniorcitizen.setBounds(100,540,200,30);
      add(seniorcitizen);
      
        syes =new JRadioButton("Yes");
     syes.setBounds(300,540,100,30);
      syes.setBackground(Color.WHITE);
      add(syes);
      
        sno =new JRadioButton("No");
      sno.setBounds(450,540,500,30);
      sno.setBackground(Color.WHITE);
      add(sno);
      
        ButtonGroup seniorcitizengroup = new ButtonGroup();
        seniorcitizengroup .add(syes);
        seniorcitizengroup .add(sno);
        
      
       JLabel pincode =new JLabel("Existing Account:");
   pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100,590,300,30);
      add(pincode);
      
      
       eyes =new JRadioButton("Yes");
     eyes.setBounds(300,590,100,30);
      eyes.setBackground(Color.WHITE);
      add(eyes);
      
        eno =new JRadioButton("No");
      eno.setBounds(450,590,100,30);
      eno.setBackground(Color.WHITE);
      add(eno);
      
        ButtonGroup existingaccountgroup = new ButtonGroup();
         existingaccountgroup.add(syes);
        existingaccountgroup.add(sno);
        
      
   
      
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
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();
        String sincome =(String)income.getSelectedItem();
        String seducation =(String)education.getSelectedItem();
        String selectedOccupation =(String)Occupation.getSelectedItem();
        
       
        String seniorcitizen =null;
        if(syes.isSelected()){
            seniorcitizen ="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
                
    }
        String existingaccount = null;
        if(eyes.isSelected()){
           existingaccount ="Yes";
        }
        else if(eno.isSelected()){
            existingaccount="No";
        }
        
        String span=pan.getText();
        String sadhar =aadhar.getText();
       
        try{
            
                Conn c=new Conn();
          String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+selectedOccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";

                c.s.executeUpdate(query);
                //signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
               
           
        } catch(Exception e){
            System.out.println(e);
        }
        
}
    
    public static void main(String args[]) {
        new SignupTwo("");
        
    }
}
