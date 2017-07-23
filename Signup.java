package hotel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Signup implements ActionListener{
JFrame fr;
JLabel lblname,lblpass,lblemail;
JTextField txtname,txtpass,txtemail;
JButton submit,cancel,back;
int c=0;
Signup(){
	fr=new JFrame("Signup Form");
	
	//	fr.setVisible(true);
		fr.setSize(400,300);
		fr.setLocation(420,200);
		fr.setLayout(null);
		lblname=new JLabel("Enter Name");
		lblname.setBounds(30,20,100,30);
		lblname.setVisible(true);
		
		txtname=new JTextField();
		txtname.setBounds(170,20,100,30);
		txtname.setVisible(true);
		
		lblpass=new JLabel("Enter password");
		lblpass.setBounds(30,70,100,30);
		lblpass.setVisible(true);
		
		txtpass=new JTextField();
		txtpass.setBounds(170,70,100,30);
		txtpass.setVisible(true);
		
		lblemail=new JLabel("Enter email");
		lblemail.setBounds(30,120,100,30);
		lblemail.setVisible(true);
		fr.add(lblemail);
		
		txtemail=new JTextField();
		txtemail.setBounds(170,120,100,30);
		txtemail.setVisible(true);
		
		back=new JButton("BACK");
		back.setBounds(30, 180, 100, 30);
		back.setVisible(true);
		fr.add(back);
		cancel=new JButton("CANCEL");
		cancel.setBounds(150, 180, 100, 30);
		cancel.setVisible(true);
		fr.add(cancel);
		submit=new JButton("SUBMIT");
		submit.setBounds(270, 180, 100, 30);
		submit.setVisible(true);
		fr.add(submit);
		
		fr.add(lblname);
		fr.add(lblpass);
		fr.add(lblemail);
		fr.add(txtname);
		fr.add(txtpass);
		fr.add(txtemail);
		fr.setVisible(true);
		back.addActionListener(this);
		cancel.addActionListener(this);
		submit.addActionListener(this);
		
		
	    
}
public static void main(String[] args) {
	new Signup();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String s=e.getActionCommand();
	if (s.equalsIgnoreCase("submit")){
		
		String name=txtname.getText();
		String email=txtemail.getText();
		String pass=txtpass.getText();
		if(name.equals("")|| email.equals("")|| pass.equals("")){
			JOptionPane.showMessageDialog(null, "FILL ALL");
		}
		else{
		Connection conn=DBUtility.getConnections();
		String sql1="SELECT * FROM login where name=?";
				try {
					PreparedStatement p=conn.prepareStatement(sql1);
					p.setString(1, name);
					ResultSet r=p.executeQuery();
					while(r.next()){
						c=1;
						JOptionPane.showMessageDialog(null, "USER ALREADY EXISTS");
						txtname.setText("");
						txtpass.setText("");
						txtemail.setText("");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		if(c==0){
		String sql="INSERT INTO login VALUES(?,?,?)";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println("ki");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			int r=ps.executeUpdate();
			System.out.println("updated");
			new Login();
			fr.dispose();
		}
		catch(Exception e1){
			System.out.println(e1);
		}}
		}}//if
	else if(s.equalsIgnoreCase("cancel")){
		txtname.setText("");
		txtemail.setText("");
		txtpass.setText("");
	}
	else if(s.equalsIgnoreCase("back")){
		fr.dispose();
		new Login();
		
	}
}

}
