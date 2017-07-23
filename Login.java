package hotel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class Login implements ActionListener {
JFrame f;
JButton login,signup;
JTextField name,password;
JLabel lblname,lblpass;
int c=0;
Login(){
	f=new JFrame("LOGIN TO YOUR ACCOUNT");
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	 int framewidth=f.getSize().width;//get the width of the frame
	    int frameheigth=f.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		f.setLocation(framelocationX,framelocationY);
		//Image img=new ImageIcon(this.getClass().getResource("/splash1.jpg")).getImage();
		f.setSize(400,300);
		f.setLayout(null);
		Font font=new Font("Arial",Font.ITALIC,14);
		lblname=new JLabel("Enter Username");
		lblname.setBounds(50,20,120,30);
		lblname.setVisible(true);
		lblname.setFont(font);
		f.add(lblname);
		
		
		name=new JTextField("");
		name.setBounds(200,20,120,30);
		name.setVisible(true);
		f.add(name);
		
		lblpass=new JLabel("enter password");
		lblpass.setBounds(50, 70, 120, 30);
		lblpass.setVisible(true);
		lblpass.setFont(font);
	
		f.add(lblpass);
		
		password=new JTextField("");
		password.setBounds(200,70,120,30);
		password.setVisible(true);
		f.add(password);
		
		login=new JButton("LOGIN");
		login.setBounds(70,120,100,30);
		f.add(login);
		login.setVisible(true);
		signup=new JButton("SIGN UP");
		signup.setBounds(200, 120, 100, 30);
		f.add(signup);
		
		signup.setVisible(true);
		
		f.setLayout(null);
		f.setVisible(true);
		
		login.addActionListener(this);
		signup.addActionListener(this);
	
}
public static void main(String[] args) {
	new Login();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String str=e.getActionCommand();
	if(str.equalsIgnoreCase("login")){
		//System.out.println("login");
		String e1=name.getText();
		String e2=password.getText();
		Connection conn=DBUtility.getConnections();
		String sql="SELECT * FROM login where name=? and password=?";
		System.out.println("ju");
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,e1);
			ps.setString(2, e2);
			System.out.println("n");
			ResultSet rs=ps.executeQuery();
			System.out.println("jhj");
			//int i=rs.getRow();
			while(rs.next()){
			JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFUL!");
			c=1;	
				new Main();
			    f.dispose();
			}
			if(c==0){
				JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD");}//try
			}
		catch(Exception e11){
			
		}
		finally{
			try{
				conn.close();
			}
		
			catch(Exception e21){
			
		}
		
	}}
	
		else if(str.equalsIgnoreCase("sign up")){
		new Signup();
		f.dispose();
	}}}
	



