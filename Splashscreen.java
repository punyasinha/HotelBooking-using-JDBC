package hotel;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;




public class Splashscreen {
	JFrame frm;
	JLabel lblsplash;
	JProgressBar jb;
	int i=0,num=0;
	 Splashscreen(){
		
	frm=new JFrame("HOTEL MANAGEMENT SYSTEM");
	frm.setSize(750,530);
	frm.setLocation(250, 200);
	frm.setLayout(null);
	frm.setUndecorated(true);
	frm.setAlwaysOnTop(false);
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    int framewidth=frm.getSize().width;//get the width of the frame
    int frameheigth=frm.getSize().height; //get the heigth of the frame
    int framelocationX=(dim.width-framewidth)/2; 
    int framelocationY=(dim.height-frameheigth)/2;
	frm.setLocation(framelocationX,framelocationY);
	
	Image img=new ImageIcon(this.getClass().getResource("/splash1.jpg")).getImage();
	lblsplash=new JLabel("");
	lblsplash.setBounds(0,0, 800, 500);
	lblsplash.setIcon(new ImageIcon(img));
	frm.add(lblsplash);

	jb=new JProgressBar(0,2000);  
	jb.setBounds(0,500,800,30); 
	frm.add(jb);
	
	jb.setValue(0);  
	jb.setStringPainted(true);  
	
	frm.setVisible(true);
	}
	public void iterate(){  
		while(i<=2000){  
		  jb.setValue(i);  
		  i=i+20;  
		  try{Thread.sleep(50);
		  }catch(Exception e){
		 }  
	}  
		if(i==2020)
		{
			
			frm.dispose();
		}
	}  
	public static void main(String[] args) {  
	    Splashscreen m=new Splashscreen();    
	    m.iterate(); 
	 new Login();
	 
	}  
	public static BufferedImage resize( Image image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}
	
	
	

}

