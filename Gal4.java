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

public class Gal4 implements ActionListener{
	JLabel l2;
	JButton next;
	JFrame f2;
	Gal4(){
		f2=new JFrame();
		f2.setSize(1000,700);
		f2.setLocation(250, 200);
		f2.setLayout(null);
		//f1.setUndecorated(true);
		f2.setAlwaysOnTop(false);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	    int framewidth=f2.getSize().width;//get the width of the frame
	    int frameheigth=f2.getSize().height; //get the heigth of the frame
	    int framelocationX=(dim.width-framewidth)/2; 
	    int framelocationY=(dim.height-frameheigth)/2;
		f2.setLocation(framelocationX,framelocationY);
		
		Image img=new ImageIcon(this.getClass().getResource("/gal4.jpg")).getImage();
		l2=new JLabel("");
		l2.setBounds(0,0, 1000, 600);
		l2.setIcon(new ImageIcon(img));
		l2.setBackground(Color.BLACK);
		f2.add(l2);
		
		next=new JButton("NEXT");
		next.setBounds(800, 620, 100, 30);
		next.addActionListener(this);
		f2.add(next);
		f2.setVisible(true);
	}
	public static void main(String[] args) {
		new Gal4();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next){
			new Main();
			f2.dispose();
		}
		
	}

}
