package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BillPaymentOnline extends JFrame implements ActionListener{
    String meter;
    JButton b1;
    BillPaymentOnline(String meter){
        super("PayBill: wss.mahadiscom.in");
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   
        
        b1 = new JButton("CANCEL");
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.setBounds(10, 20, 120, 30);
        b1.addActionListener(this);
        j.add(b1);

        try {
            j.setPage("https://wss.mahadiscom.in/wss/wss_view_pay_bill.aspx");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
    public static void main(String[] args){
        new BillPaymentOnline("").setVisible(true);
    }
}
