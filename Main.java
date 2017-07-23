package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main implements ActionListener{
JLabel i;
JButton Gallery,book;
JMenuItem about;
JFrame frm;
JMenuBar menu;
JMenu bookr,acc,ab,gal;
JMenuItem bookroom,bookhall,abou,gallery,change,mybook;

Main(){
	frm=new JFrame("WELCOME TO HOTEL TRANSYLVANIA");
	frm.setSize(1218,724);
	frm.setLocation(250, 200);
	frm.setLayout(null);
	Font font=new Font("Mistral",Font.ITALIC,20);
	
	frm.setAlwaysOnTop(false);
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    int framewidth=frm.getSize().width;//get the width of the frame
    int frameheigth=frm.getSize().height; //get the heigth of the frame
    int framelocationX=(dim.width-framewidth)/2; 
    int framelocationY=(dim.height-frameheigth)/2;
	frm.setLocation(framelocationX,framelocationY);
	Image img=new ImageIcon(this.getClass().getResource("/lob.jpg")).getImage();
	i=new JLabel("");
	i.setBounds(0,0, 1218, 724);
	i.setIcon(new ImageIcon(img));
	frm.add(i);
	menu=new JMenuBar();
	frm.setJMenuBar(menu);
	bookr=new JMenu("BOOK");
	bookr.setBounds(0,0,200,30);
	bookroom=new JMenuItem("book a room");
	//bookhall=new JMenuItem("book hall");
	bookr.add(bookroom);
	//bookr.add(bookhall);
	
	acc=new JMenu("MY ACCOUNT");
	change=new JMenuItem("change my password");
	mybook=new JMenuItem("my bookings");
	acc.add(change);
	acc.add(mybook);
	menu.add(acc);
	acc.setBounds(200,0,200,30);
	gal=new JMenu("GALLERY");
	gallery=new JMenuItem("go to gallery");
	gal.add(gallery);
	ab=new JMenu("ABOUT");
	about=new JMenuItem("about");
	ab.add(about);
	menu.add(ab);
	menu.add(gal);
	menu.add(bookr);
	
	bookroom.addActionListener(this);
	gallery.addActionListener(this);
    change.addActionListener(this);
	mybook.addActionListener(this);
	about.addActionListener(this);
	
	frm.setVisible(true);
}
public static void main(String[] args) {
	new Main();
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==bookroom){
		new List();
		
	}
	else if(e.getSource()==gallery){
		new gal1();
		frm.dispose();
	}
	else if(e.getSource()==about){
		new About();
	}
	else if(e.getSource()==change){
		new Change();
	}
	else if(e.getSource()==mybook){
		new Mybooking();
	}
}
}
