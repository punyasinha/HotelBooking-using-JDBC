package hotel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Change implements ActionListener {
JFrame f;
JLabel name,oldpass,newpass;
JTextField txtname,txtoldpass,txtnewpass;
JButton submit,cancel,back;
int c=0;
Change(){
	f=new JFrame("CHANGE PASSWORD");
	f.setLocation(400,240);
	f.setSize(400,300);
	f.setLayout(null);
	name=new JLabel("Enter name");
	name.setBounds(20, 20, 80, 20);
	f.add(name);
	txtname=new JTextField();
	txtname.setBounds(120,20,100,20);
	f.add(txtname);
	
	oldpass=new JLabel("Enter old password");
	oldpass.setBounds(20, 50, 150, 20);
	f.add(oldpass);
	txtoldpass=new JTextField();
	txtoldpass.setBounds(170,50,80,20);
	f.add(txtoldpass);
	
	newpass=new JLabel("Enter new Password");
	newpass.setBounds(20, 80, 150, 20);
	f.add(newpass);
	txtnewpass=new JTextField();
	txtnewpass.setBounds(170,80,80,20);
	f.add(txtnewpass);
	
	submit=new JButton("SUBMIT");
	submit.setBounds(30, 120, 100, 30);
	f.add(submit);
	cancel=new JButton("CANCEL");
	cancel.setBounds(150, 120, 100, 30);
	f.add(cancel);
	back=new JButton("BACK");
	back.setBounds(270, 120, 100, 30);
	f.add(back);
	
	
	back.addActionListener(this);
	submit.addActionListener(this);
	cancel.addActionListener(this);
	f.setVisible(true);
}
public static void main(String[] args) {
	new Change();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==back){
		new Main();
	}
	else if(e.getSource()==cancel){
		txtname.setText("");
		txtoldpass.setText("");
		txtnewpass.setText("");
	}
	
	else if(e.getSource()==submit){
		if(txtname.getText().equals("")|| txtoldpass.getText().equals("")||
				txtnewpass.getText().equals("")){
			JOptionPane.showMessageDialog(null, "FILL ALL");
		}
		else{
		Connection conn= (Connection) DBUtility.getConnections();
		String sql="SELECT * FROM login WHERE name=?";
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, txtname.getText().toString());
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next()){
				if(rs.getString(3).equals(txtoldpass.getText())){
				String sql1="UPDATE login set password=? where name=?";
				PreparedStatement ps1=conn.prepareStatement(sql1);
				
				ps1.setString(1, txtnewpass.getText());
				ps1.setString(2,txtname.getText());
				ps1.executeUpdate();
				JOptionPane.showMessageDialog(null, "Password Updated");
				c=1;
				txtname.setText("");
				txtoldpass.setText("");
				txtnewpass.setText("");
			
			}
				else{
					JOptionPane.showMessageDialog(null, "Wrong  password");}
				}
			if(c==0){
				JOptionPane.showMessageDialog(null, "Wrong username");
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		finally{
			return;
		}
		}}
	
	}
	
}

