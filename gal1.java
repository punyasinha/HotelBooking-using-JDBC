package hotel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gal1 implements ActionListener {
JLabel l1;
JButton next;
JFrame f1;
gal1(){
	f1=new JFrame();
	f1.setSize(1000,700);
	f1.setLocation(250, 200);
	f1.setLayout(null);
	//f1.setUndecorated(true);
	f1.setAlwaysOnTop(false);
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    int framewidth=f1.getSize().width;//get the width of the frame
    int frameheigth=f1.getSize().height; //get the heigth of the frame
    int framelocationX=(dim.width-framewidth)/2; 
    int framelocationY=(dim.height-frameheigth)/2;
	f1.setLocation(framelocationX,framelocationY);
	
	Image img=new ImageIcon(this.getClass().getResource("/gal1.jpg")).getImage();
	l1=new JLabel("");
	l1.setBounds(0,0, 1000, 600);
	l1.setIcon(new ImageIcon(img));
	l1.setBackground(Color.BLACK);
	f1.add(l1);
	
	next=new JButton("NEXT");
	next.setBounds(800, 620, 100, 30);
	next.addActionListener(this);
	f1.add(next);
	f1.setVisible(true);
}
public static void main(String[] args) {
	new gal1();
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==next){
		new Gal2();
		f1.dispose();
	}
	
}
}
