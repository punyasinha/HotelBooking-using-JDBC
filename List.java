
package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableCell;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.Statement;

import java.util.Calendar;;
public class List implements ActionListener,MouseListener{
	JFrame f;
	JLabel t1,t2,t3,n,d;
	JButton book;
	public static String room,tar,bedtype,tarrif,dayarr,days;
	JTable list_table;
	JTextField sel,nod;
	UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    
    
	List(){
		f=new JFrame();
	f.setSize(900,500);
		f.setLocation(250, 200);
		f.setLayout(null);
		Font font=new Font("Mistral",Font.ITALIC,20);
		 f.setBackground(Color.red);
		f.setAlwaysOnTop(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=f.getSize().width;//get the width of the frame
	    int frameheigth=f.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		f.setLocation(framelocationX,framelocationY);
		String column[]={"ROOM","TARRIFF","Bed","STATUS"};
		
		list_table=new JTable();
		try{
			Connection conn=DBUtility.getConnections();
			String sql="SELECT room,tarrif,bed FROM hotel";
			PreparedStatement pr=conn.prepareStatement(sql);
			ResultSet rs=pr.executeQuery();
			list_table.setModel(DbUtils.resultSetToTableModel(rs));
			list_table.getColumnModel().getColumn(0).setPreferredWidth(15);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		list_table.setBounds(30,40,200,300);
		JScrollPane sp=new JScrollPane(list_table);
		list_table.setBounds(30, 100, 500, 290);
	
		f.add(list_table);
		list_table.add(sp);
		sp.setVisible(true);
		t1=new JLabel("ROOM NO.");
		t1.setBounds(50, 70, 100, 20);
		f.add(t1);
		t2=new JLabel("TARIFF");
		t2.setBounds(220, 70, 100, 20);
		f.add(t2);
		t3=new JLabel("TYPE");
		t3.setBounds(400, 70, 100, 20);
		f.add(t3);
		
		book=new JButton("BOOK");
		book.setBounds(550, 150, 100, 30);
		f.add(book);
		
		sel=new JTextField();
		sel.setBounds(550, 100, 100, 30);
		sel.setEditable(false);
		
		
		d=new JLabel("Choose arrival Date");
		d.setBounds(560, 280, 200, 20);
		f.add(d);
		model=new UtilDateModel();
		Properties p=new Properties();
		p.put("text.today", "Today");
		p.put("text.Month", "Month");
		p.put("text.year", "Year");
		datePanel=new JDatePanelImpl(model, p);
		datePicker=new JDatePickerImpl(datePanel, new DateLabelFormatter());
		f.add(datePicker);
		datePicker.setBounds(550, 300, 200, 200);
		
		
		n=new JLabel("No of days");
		n.setBounds(560, 230, 100, 20);
		f.add(n);
		nod=new JTextField();
		nod.setBounds(550, 260, 100, 20);
		f.add(nod);
		
	    
		f.add(sel);
		book.addActionListener(this);
		list_table.addMouseListener(this);
		//f.setSize(500,500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new List();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().toString().equalsIgnoreCase("book")){
			if(nod.getText().equals("") || sel.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Fill all fields");
			}
			else{
				System.out.println("booked");
				Connection con=DBUtility.getConnections();
				String sql1="SELECT * FROM hotel WHERE room=?";
				try{
				PreparedStatement p=con.prepareStatement(sql1);
				p.setString(1, sel.getText().toString());
				ResultSet r=p.executeQuery();
				while(r.next()){
					if(r.getString(4).equals("BOOKED")){
						JOptionPane.showMessageDialog(null, "already booked");
					}
					else{
						dayarr=datePicker.getJFormattedTextField().getText();
						JOptionPane.showMessageDialog(null,"BOOK YOR ROOM NOW");
						days=nod.getText();
						new Bookingfrm();
						f.dispose();
						
						
					}
				}
				
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
				//String sq="UPDATE hotel SET status="booked" where room=? "
			
			
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=list_table.getSelectedRow();
		String table_click=(list_table.getModel().getValueAt(row, 0).toString());
		//System.out.println(table_click);
		room=table_click;
		bedtype=(list_table).getModel().getValueAt(row, 2).toString();
		tarrif=(list_table).getModel().getValueAt(row, 1).toString();
		sel.setText(table_click);
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
