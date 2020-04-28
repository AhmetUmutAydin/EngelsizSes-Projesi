import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mathworks.toolbox.javabuilder.MWCharArray;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TheMain {

	private JFrame frame;
	private JTextField bigisayarismi;
	private JTextField textField_3;
	private JLabel Kullanici_name;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheMain window = new TheMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TheMain() {
		initialize();
		
		
		
		
		
		
		
		
		
		
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		bigisayarismi = new JTextField();
		bigisayarismi.setBounds(315, 49, 207, 20);
		frame.getContentPane().add(bigisayarismi);
		bigisayarismi.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(315, 90, 207, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblBilgisayarIsmi = new JLabel("Kullanici Adi");
		lblBilgisayarIsmi.setForeground(new Color(46, 139, 87));
		lblBilgisayarIsmi.setBounds(49, 52, 86, 14);
		frame.getContentPane().add(lblBilgisayarIsmi);
		

		JLabel lblGnderilecekMail = new JLabel("G\u00F6nderilecek Mail");
		lblGnderilecekMail.setForeground(new Color(46, 139, 87));
		lblGnderilecekMail.setBounds(49, 93, 86, 14);
		frame.getContentPane().add(lblGnderilecekMail);
		
		String gon_mail = lblGnderilecekMail.getText();
		
		
		JButton giris = new JButton("Giri\u015F");
		giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				frame.dispose();
				yapabileceklerim yapabileceklerim = new yapabileceklerim(gon_mail);
				yapabileceklerim.setVisible(true);
				
				
			}
		});
		giris.setBounds(433, 206, 89, 23);
		frame.getContentPane().add(giris);
		
		
		Kullanici_name = new JLabel("");
		Kullanici_name.setBounds(0, 0, 684, 361);
		frame.getContentPane().add(Kullanici_name);
		
		Image img = new ImageIcon(this.getClass().getResource("back.jpg")).getImage();
		Kullanici_name.setIcon(new ImageIcon(img));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
