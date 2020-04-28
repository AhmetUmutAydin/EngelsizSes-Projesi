import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.awt.event.ActionEvent;

public class RESIM extends JFrame {

	private JPanel contentPane;
	private boolean isfotoshowed = false;
	
	String bitir = "bitir";

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RESIM frame = new RESIM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RESIM() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel resimlabel = new JLabel();
		resimlabel.setHorizontalAlignment(SwingConstants.CENTER);
		resimlabel.setBounds(79, 58, 528, 231);
		contentPane.add(resimlabel);
		
		
		
		Initialize();
		
	}
	public RESIM(BufferedImage bi) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel resimlabel = new JLabel();
		resimlabel.setHorizontalAlignment(SwingConstants.CENTER);
		resimlabel.setBounds(79, 58, 528, 231);
		contentPane.add(resimlabel);
		
		
		//Image img1 = new ImageIcon(this.getClass().getResource("tas.png")).getImage();
		resimlabel.setIcon(new ImageIcon(bi));
		
		
		Initialize();
		
		
		
		
		
		
		
	}
	
	
	public void Initialize() {
		
		JLabel lblResm = new JLabel("RESIM");
		lblResm.setHorizontalAlignment(SwingConstants.CENTER);
		lblResm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResm.setBounds(195, 11, 271, 29);
		contentPane.add(lblResm);
		
		
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					isfotoshowed = true ;
	
					if(isfotoshowed == true) {
						
						
						try {
							Thread.sleep(10000);
							dispose();


							yapabileceklerim yapabileceklerim = new yapabileceklerim();
							yapabileceklerim.setVisible(true);
							
						}catch(Exception ee) {
							System.out.println(ee);
						}
						
						
					}
					
					
					
				
			}
		});
		btnNewButton.setBounds(460, 327, 214, 23);
		contentPane.add(btnNewButton);
		
	}
	
	
	public void kapat() throws InterruptedException {
		
		dispose();
		yapabileceklerim yapabileceklerim = new yapabileceklerim();
		yapabileceklerim.setVisible(true);
		
		
	}
	
	
	
	
	
	

}
