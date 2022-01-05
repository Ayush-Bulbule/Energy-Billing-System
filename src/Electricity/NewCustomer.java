
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class NewCustomer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8, l11;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    NewCustomer(){
        super("New Customer");
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173,216,230));
        
        JLabel title = new JLabel("New Customer");
        title.setBounds(150, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        l1 = new JLabel("Customer Name");
        l1.setBounds(50, 80, 100, 20);
        
        t1 = new JTextField();
        t1.setBounds(200, 80, 200, 20);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Meter No");
        l2.setBounds(50, 120, 100, 20);
        l11 = new JLabel();
        l11.setBounds(200, 120, 200, 20);
        p.add(l2);
        p.add(l11);
        l3 = new JLabel("Address");
        l3.setBounds(50, 160, 100, 20);
        t3 = new JTextField();
        t3.setBounds(200, 160, 200, 20);
        p.add(l3);
        p.add(t3);
        l5 = new JLabel("City");
        l5.setBounds(50, 200, 100, 20);
        t5 = new JTextField();
        t5.setBounds(200, 200, 200, 20);
        p.add(l5);
        p.add(t5);
        l4 = new JLabel("State");
        l4.setBounds(50, 240, 100, 20);
        t4 = new JTextField();
        t4.setBounds(200, 240, 200, 20);
        p.add(l4);
        p.add(t4);
        
        l6 = new JLabel("Email");
        l6.setBounds(50, 280, 100, 20);
        t6 = new JTextField();
        t6.setBounds(200, 280, 200, 20);
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        l7.setBounds(50, 320, 100, 20);
        t7 = new JTextField();
        t7.setBounds(200, 320, 200, 20);
        p.add(l7);
        p.add(t7);
        
        b1 = new JButton("Cancel");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Next");
        b2.setBounds(250, 390, 100, 25);
        
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.GREEN);
        b2.setForeground(Color.BLACK);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/adduser.png"));
        Image i3 = ic1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l11.setText(""+Math.abs(first));


        setSize(700,500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the frame
        int x = (dim.width-700)/2;
        int y = (dim.height-500)/2;
        setLocation(x,y);

        setResizable(false);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b2){
            String name = t1.getText();
            String meter = l11.getText();
            String address = t3.getText();
            String state = t4.getText();
            String city = t5.getText();
            String email = t6.getText();
            String phone = t7.getText();

            String q1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String q2 = "insert into login values('"+meter+"', '', '', '', '')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                new MeterInfo(meter).setVisible(true);
                this.setVisible(false);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() ==b1){
                this.setVisible(false);
                }
    }
    
    
    public static void main(String[] args){
        new NewCustomer().setVisible(true);
    }
}
