package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3, l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2, b3;
    JPanel p1,p2,p3,p4;
    Choice c1;
    Login() throws IOException {
        super("Login Page");
        setLayout(null);

        Font f = new Font("Calibri", Font.PLAIN, 18);

        //ImagesICon
        ImageIcon img = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("./icon/userlogin.png")).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        l1 = new JLabel(img);
        l1.setBounds(175, 10, 150, 150);
        add(l1);


        //Label 1
        l2 = new JLabel("Username: ");
        l2.setFont(f);
        l2.setBounds(50, 170, 400, 20);
        add(l2);

        //TextField1
        tf1 = new JTextField();
        tf1.setBounds(50, 200, 400, 30);
        add(tf1);

        //Label 1
        l3 = new JLabel("Password:");
        l3.setFont(f);
        l3.setBounds(50, 240, 400, 20);
        add(l3);

        //TextField1
        pf2 = new JPasswordField();
        pf2.setBounds(50, 270, 400, 30);
        add(pf2);

        l4 = new JLabel("Login As:");
        l4.setFont(f);
        l4.setBounds(50, 310, 400, 20);
        add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setFont(new Font("Calibri",Font.BOLD,15));
        c1.setBounds(50,340,400,30);
        add(c1);


        //Buttoon1
        ImageIcon img1 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("./icon/ic_login.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        b1 = new JButton("Login",img1);
        b1.setBounds(50, 450, 120, 30);
        b1.addActionListener(this);
        add(b1);


//        ImageIcon img2 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("./icon/ic_cancel.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        b2 = new JButton("Cancel");
        b2.setBounds(200, 450, 120, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon img3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("./icon/ic_signup.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        b3 = new JButton("SignUp",img3);
        b3.setBounds(350, 450, 120, 30);
        b3.addActionListener(this);
        add(b3);


        setSize(500, 550);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the frame
        int x = (dim.width-500)/2;
        int y = (dim.height-550)/2;
        setLocation(x,y);
        setResizable(false);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                Conn c = new Conn();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String user = c1.getSelectedItem().toLowerCase();
                String q  = "select * from login where username = '"+a+"' and pass = '"+b+"' and usr = '"+user+"'";
                System.out.println("Query : "+q);
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            this.setVisible(false);
            new Signup().setVisible(true);
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        new Login().setVisible(true);
    }

    
}



