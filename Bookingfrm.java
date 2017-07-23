package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

public class Bookingfrm implements ActionListener{
JFrame book;

JPanel jp;
JTextField bname,badd,bstate,bcount,bphn,bidp,bidno,bnod,btax,broom,bbed,bdatein,bdateout,btarrif,btotal,bno;
JLabel bna,bad,bst,bco,bph,bid,bta,bro,bbe,bdin,bdout,btar,btot,bnodays,bino;
int t,d,tot;
Double f;

JButton b;
Bookingfrm(){
	book=new JFrame();
	book.setSize(900,500);
		book.setLocation(250, 200);
		book.setLayout(null);
		Font font=new Font("Mistral",Font.ITALIC,20);
		 book.setBackground(Color.red);
		book.setAlwaysOnTop(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=book.getSize().width;//get the width of the frame
	    int frameheigth=book.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		book.setLocation(framelocationX,framelocationY);
		
		bro=new JLabel("Room no.");
		bro.setBounds(20,20,80,20);
		book.add(bro);
		
		
		broom=new JTextField();
		broom.setBounds(100, 20, 100, 20);
		broom.setText(List.room);
		broom.setEditable(false);
		
		bbe=new JLabel("Room Type");
		bbe.setBounds(220, 20, 100, 20);
		book.add(bbe);
		
		bbed=new JTextField();
		bbed.setBounds(300,20,100,20);
		bbed.setText(List.bedtype);
		bbed.setEditable(false);
		
		btar=new JLabel("Tarriff");
		btar.setBounds(420, 20, 100, 20);
		book.add(btar);
		
		btarrif=new JTextField();
		btarrif.setBounds(490,20,100,20);
		btarrif.setText(List.tarrif);
		btarrif.setEditable(false);
		
		bdin=new JLabel("Arrival date");
		bdin.setBounds(100, 50, 100, 20);
		book.add(bdin);
		
		bdatein=new JTextField();
		bdatein.setBounds(180,50,100,20);
		bdatein.setText(List.dayarr);
		bdatein.setEditable(false);
		bdateout=new JTextField();
		bdateout.setBounds(250,50,100,20);
		bdateout.setText(List.dayarr);
		bdateout.setEditable(false);
		
		bna=new JLabel("Name:");
		bna.setBounds(100, 100, 70, 20);
		book.add(bna);
		
		bname=new JTextField();
		bname.setBounds(180,100,100,20);
		book.add(bname);
		
		bad=new JLabel("Address:");
		bad.setBounds(100, 140, 70, 20);
		book.add(bad);
		
		badd=new JTextField();
		badd.setBounds(180,140,100,20);
		book.add(badd);
		
		bst=new JLabel("State:");
		bst.setBounds(100, 180, 70, 20);
		book.add(bst);
		
		bstate=new JTextField();
		bstate.setBounds(180,180,100,20);
		book.add(bstate);
		bstate.setVisible(true);
		
		bco=new JLabel("Country:");
		bco.setBounds(100, 220, 70, 20);
		book.add(bco);
		
		bcount=new JTextField();
		bcount.setBounds(180,220,100,20);
		book.add(bcount);
		bph=new JLabel("Phone No.:");
		bph.setBounds(380, 100, 70, 20);
		book.add(bph);
		
		bphn=new JTextField();
		bphn.setBounds(480,100,100,20);
		book.add(bphn);
		bid=new JLabel("ID Proof:");
		bid.setBounds(380, 140, 70, 20);
		book.add(bid);
		
		bino=new JLabel("ID No.:");
		bino.setBounds(380, 180, 70, 20);
		book.add(bino);
		
		bidno=new JTextField();
		bidno.setBounds(480,180,100,20);
		book.add(bidno);
		
		bidp=new JTextField();
		bidp.setBounds(480,140,100,20);
		book.add(bidp);
		
		bta=new JLabel("Tax:");
		bta.setBounds(380, 260, 70, 20);
		book.add(bta);
		
		bno=new JTextField();
		bno.setBounds(480, 220, 100, 20);
		book.add(bno);
		bno.setText(List.days);
		bno.setEditable(false);
		
		bnodays=new JLabel("NO of Days");
		bnodays.setBounds(380, 220, 70, 20);
		book.add(bnodays);
		
		btax=new JTextField();
		btax.setBounds(480,260,100,20);
		book.add(btax);
		
		btax.setEditable(false);
		
		btotal=new JTextField();
		btotal.setBounds(480,350,100,20);
		book.add(btotal);
		btotal.setEditable(false);
		
		btot=new JLabel("TOTAL AMOUNT");
		btot.setBounds(380,350,100,20);
		book.add(btot);
		
		b=new JButton("BOOK");
		b.setBounds(480,410,100,30);
		book.add(b);
		
		
		 t=Integer.parseInt(List.tarrif);
		 d=Integer.parseInt(bno.getText());
		
		 tot=t*d;
		 Double tax1=0.13*tot;
		Double f=tot+ tax1;
		btotal.setText(f.toString());
		btax.setText(tax1.toString());
		b.addActionListener(this);
		book.add(bdatein);
		book.add(btar);
		book.add(btarrif);
		book.add(bbe);
		book.add(bbed);
		book.add(bro);
		book.add(broom);
		book.setVisible(true);
}
public static void main(String[] args) {
	new Bookingfrm();
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getActionCommand().equals("BOOK")){
	if(bname.getText().equals("")||badd.getText().equals("")||bstate.getText().equals("")||
				bcount.getText().equals("") || bphn.getText().equals("")||bidp.getText().equals("")||
				bidno.getText().equals("")){
		JOptionPane.showMessageDialog(null, "FILL ALL");
	}else{
		 t=Integer.parseInt(List.tarrif);
		 d=Integer.parseInt(bno.getText());
		
		 tot=t*d;
		Double f=tot+ 0.13*tot;
		
		Connection co=(Connection) DBUtility.getConnections();
		try{
		//Connection co=(Connection) DBUtility.getConnections();
		String query="INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String query1="INSERT INTO booked values(?,?)";
		PreparedStatement ps=co.prepareStatement(query);
		PreparedStatement ps1=co.prepareStatement(query1);
		ps.setString(1, broom.getText());
		ps.setString(2, bbed.getText());
		ps.setDate(3,  java.sql.Date.valueOf(List.dayarr));
		ps.setString(4, bno.getText());
		ps.setString(5, bname.getText());
		ps.setString(6, badd.getText());
		ps.setString(7, bstate.getText());
		ps.setString(8, bcount.getText());
		ps.setString(9, bphn.getText());
		ps.setString(10, bidp.getText());
		ps.setString(11, bidno.getText());
		ps.setString(12, f.toString());
		int r=ps.executeUpdate();
		/*String query2="UPDATE hotel set status='BOOKED' where room=?";
		PreparedStatement ps2=co.prepareStatement(query2);
		ps2.setString(1, broom.getText());
		int re=ps2.executeUpdate();*/
		JOptionPane.showMessageDialog(null, "YOUR ROOM IS BOOKED!");
		
		
		
	}
		catch(SQLException e){
			e.printStackTrace();}
		
	finally{
		try{
			co.close();
		
		}catch(SQLException er){
			er.printStackTrace();
		}
	}
	}
	
}
}}
