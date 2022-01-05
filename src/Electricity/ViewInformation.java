/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Random;

public class ViewInformation extends JFrame implements ActionListener{
    JButton b1;
    ViewInformation(String meter){
        super("View Your Info");

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173,216,230));

        JLabel title = new JLabel("View Personal Details");
        title.setBounds(150, 10, 500, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        //Name
        JLabel l1 = new JLabel("Customer Name");
        l1.setBounds(50, 80, 150, 20);
        JLabel l11 = new JLabel("");
        l11.setBounds(250, 80, 300, 20);
        p.add(l1);
        p.add(l11);

        //Meter No
        JLabel l2 = new JLabel("Meter No");
        l2.setBounds(50, 120, 100, 20);
        JLabel l12 = new JLabel();
        l12.setBounds(250, 120, 250, 20);
        p.add(l2);
        p.add(l12);
        JLabel l3 = new JLabel("Address");
        l3.setBounds(50, 160, 100, 20);
        JLabel l13 = new JLabel();
        l13.setBounds(250, 160, 250, 20);
        p.add(l3);
        p.add(l13);

        //City
        JLabel l5 = new JLabel("City");
        l5.setBounds(50, 200, 100, 20);
        JLabel l15 = new JLabel();
        l15.setBounds(250, 200, 250, 20);
        p.add(l5);
        p.add(l15);

        //State
        JLabel l4 = new JLabel("State");
        l4.setBounds(50, 240, 100, 20);
       JLabel l14 = new JLabel();
        l14.setBounds(250, 240, 250, 20);
        p.add(l4);
        p.add(l14);

        JLabel l6 = new JLabel("Email");
        l6.setBounds(50, 280, 100, 20);
        JLabel l16 = new JLabel();
        l16.setBounds(250, 280, 250, 20);
        p.add(l6);
        p.add(l16);

        //phone
        JLabel l7 = new JLabel("Phone Number");
        l7.setBounds(50, 320, 100, 20);
        JLabel l17 = new JLabel();
        l17.setBounds(250, 320, 350, 20);
        p.add(l7);
        p.add(l17);

        b1 = new JButton("Close");
        b1.setBounds(120, 390, 100, 25);


        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);



        p.add(b1);
        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        JLabel l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);

        Font f = new Font("Calibri",Font.BOLD,18);
        l1.setFont(f);
        l11.setFont(f);
        l2.setFont(f);
        l12.setFont(f);
        l3.setFont(f);
        l13.setFont(f);
        l4.setFont(f);
        l14.setFont(f);
        l5.setFont(f);
        l15.setFont(f);
        l6.setFont(f);
        l16.setFont(f);
        l7.setFont(f);
        l17.setFont(f);


        setSize(1100,600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the frame
        int x = (dim.width-1100)/2;
        int y = (dim.height-600)/2;
        setLocation(x,y);

        setResizable(false);
        setVisible(true);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l15.setText(rs.getString(4));
                l14.setText(rs.getString(5));
                l16.setText(rs.getString(6));
                l17.setText(rs.getString(7));

            }
        }catch(Exception e){}

    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewInformation("").setVisible(true);
    }
}
