package hotel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class About {
JFrame f;
JLabel i;
JTextArea a;

About(){
	f=new JFrame("ABOUT HOTEL TRANSYLVANIA");
	f.setLocation(200,50);
	f.setSize(1000,650);
	f.setLayout(null);
	
	Image img=new ImageIcon(this.getClass().getResource("/chinatown-hotel.jpg")).getImage();
	i=new JLabel("");
	i.setBounds(0,0, 1000, 650);
	i.setIcon(new ImageIcon(img));
	f.add(i);
	
	
	
	
	
	
	
	
	
	
	
	f.setVisible(true);
}
public static void main(String[] args) {
	new About();
}
}
