package hotel;

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

public class Mybooking implements ActionListener{
JFrame f;
JLabel room,date,cost,name;
JTextField troom,tdate,tcost,tname;
JButton ok;
int c=0;
Mybooking(){
	f=new JFrame("YOUR BOOKINGS");
    f.setLocation(350,200);
    f.setSize(450,250);
    f.setLayout(null);
    
    name=new JLabel("Enter your name");
    name.setBounds(30, 40, 100, 20);
    f.add(name);
    tname=new JTextField();
    tname.setBounds(150, 40, 100, 20);
    f.add(tname);
    
    room=new JLabel("Room No.");
    room.setBounds(30, 80, 100, 20);
    f.add(room);
    
    
    troom=new JTextField();
    troom.setBounds(150, 80, 100, 20);
    f.add(troom);
    troom.setEditable(false);
    
    date=new JLabel("Date of Arrival");
    date.setBounds(30, 120, 100, 20);
    f.add(date);
    tdate=new JTextField();
    tdate.setBounds(150, 120, 100, 20);
    f.add(tdate);
    tdate.setEditable(false);
    cost=new JLabel("Booking Cost");
    cost.setBounds(30, 160, 100, 20);
    f.add(cost);
    tcost=new JTextField();
    tcost.setBounds(150, 160, 100, 20);
    f.add(tcost);
    tcost.setEditable(false);
    ok=new JButton("CHECK");
    ok.setBounds(300, 90, 100, 30);
    f.add(ok);

ok.addActionListener(this);
f.setVisible(true);
}
public static void main(String[] args) {
	new Mybooking();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==ok){
		Connection conn=(Connection) DBUtility.getConnections();
		String sql="Select * From book WHERE name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, tname.getText());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				c=1;
				troom.setText(rs.getString(1));
				tdate.setText(rs.getDate(3).toString());
				tcost.setText(rs.getString(11));
				
			}
			if(c==0){
				JOptionPane.showMessageDialog(null, "YOU HAVE NOT BOOKED ANY ROOM");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
}
