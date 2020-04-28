import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;
import speechrec.*;

public class OYUN extends JFrame {

	private JPanel contentPane;

	Object[] resultP = null;
	slient slient = null;
	train train = null;
	train_all train_all = null;
	testword test = null;
	kayit kayit = null;
	noise noise = null;
	MWCharArray pc;
	MWCharArray folder;
	MWCharArray filename;
	MWCharArray foldrname;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OYUN frame = new OYUN();
					frame.setVisible(true);
					frame.setTitle("OYUN");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel benimtahminim;
	JLabel bilgisayarintahmini;
	JLabel sonuc;
	
	Image kapali;
	Image acik;
	JLabel mic;

	
	public OYUN(Object[] resultP, speechrec.slient slient, speechrec.train train, speechrec.train_all train_all,
			testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc, MWCharArray folder,
			MWCharArray filename,MWCharArray foldrname) {
		super();
		this.resultP = resultP;
		this.slient = slient;
		this.train = train;
		this.train_all = train_all;
		this.test = test;
		this.kayit = kayit;
		this.noise = noise;
		this.pc = pc;
		this.folder = folder;
		this.filename = filename;
		this.foldrname=foldrname;
		Initialize();
	}
	
	
	
	public OYUN() {
		
		Initialize();
		
	}
	
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		benimtahminim = new JLabel("");
		benimtahminim.setBounds(10, 68, 278, 185);
		contentPane.add(benimtahminim);
		
		bilgisayarintahmini = new JLabel("");
		bilgisayarintahmini.setBounds(348, 68, 259, 185);
		contentPane.add(bilgisayarintahmini);
		
		sonuc = new JLabel("Kazand\u0131n\u0131z yada Kaybettiniz.");
		sonuc.setHorizontalAlignment(SwingConstants.CENTER);
		sonuc.setBounds(10, 336, 209, 14);
		contentPane.add(sonuc);
	
		
		
		
		JLabel lblNewLabel = new JLabel("Senin Tahminin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 48, 285, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblBilgisayarnTahmini = new JLabel("Bilgisayar\u0131n Tahmini");
		lblBilgisayarnTahmini.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgisayarnTahmini.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBilgisayarnTahmini.setBounds(329, 48, 278, 26);
		contentPane.add(lblBilgisayarnTahmini);
		
		JButton btnMenuYeDn = new JButton("menu ye don");
		btnMenuYeDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				yapabileceklerim yapabileceklerim = new yapabileceklerim();
				yapabileceklerim.setVisible(true);
				
				
				
				
			}
		});
		btnMenuYeDn.setBounds(538, 327, 136, 23);
		contentPane.add(btnMenuYeDn);
		
		JLabel lblTakagtmakas = new JLabel("TA\u015E-KAGIT-MAKAS");
		lblTakagtmakas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTakagtmakas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTakagtmakas.setBounds(145, 11, 339, 26);
		contentPane.add(lblTakagtmakas);
		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(255, 247, 120, 114);
		contentPane.add(mic);
		
		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		
	}
	
	
	public void oyna() throws MWException {
		boolean x = true;
		do {

			System.out.println("Please select one of [R/P/S]: ");
			mic.setIcon(new ImageIcon(acik));
			kayit.Untitled(pc, folder, filename);
			mic.setIcon(new ImageIcon(kapali));
			//noise.Un2(pc, folder, filename);
			slient.recs(pc, folder, filename);
			resultP = test.test_word(1, pc, filename,foldrname);
			String user = resultP[0].toString();
			user = user.replaceAll("[0-9]", "").toLowerCase();//user Stringi user ýn seçtiði
			
			

			int comt = (int) (3 * Math.random()) + 1;
			String comp = "";
			
			if (user.equals("tas")) {
				user = "Rock";
				Image img1 = new ImageIcon(this.getClass().getResource("tas.png")).getImage();
				benimtahminim.setIcon(new ImageIcon(img1));
				

				if (comt == 1) {
					comp = "Rock";
					Image img2 = new ImageIcon(this.getClass().getResource("tas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 2) {
					comp = "Paper";
					Image img2 = new ImageIcon(this.getClass().getResource("kagit.jpg")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 3) {
					comp = "Scissors";
					Image img2 = new ImageIcon(this.getClass().getResource("makas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				}//comp stringi pc nin seçtiði

				
				
			} else if (user.equals("makas")) {
				user = "Scissors";
				Image img1 = new ImageIcon(this.getClass().getResource("nakas.png")).getImage();
				benimtahminim.setIcon(new ImageIcon(img1));
				

				if (comt == 1) {
					comp = "Rock";
					Image img2 = new ImageIcon(this.getClass().getResource("tas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 2) {
					comp = "Paper";
					Image img2 = new ImageIcon(this.getClass().getResource("kagit.jpg")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 3) {
					comp = "Scissors";
					Image img2 = new ImageIcon(this.getClass().getResource("makas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				}//comp stringi pc nin seçtiði

			} else if (user.equals("kagit")) {
				user = "Paper";
				Image img1 = new ImageIcon(this.getClass().getResource("kagit.jpg")).getImage();
				benimtahminim.setIcon(new ImageIcon(img1));
				

				if (comt == 1) {
					comp = "Rock";
					Image img2 = new ImageIcon(this.getClass().getResource("tas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 2) {
					comp = "Paper";
					Image img2 = new ImageIcon(this.getClass().getResource("kagit.jpg")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				} else if (comt == 3) {
					comp = "Scissors";
					Image img2 = new ImageIcon(this.getClass().getResource("makas.png")).getImage();
					bilgisayarintahmini.setIcon(new ImageIcon(img2));
				}//comp stringi pc nin seçtiði

			}

			if (user.equals(comp)) {
				System.out.println("A tie!");// Berabere
				sonuc.setText("A tie!");
			} else if (user.equals("Rock") && comp.equals("Scissors")) {
				System.out.println("Rock beats scissor - you win!");// tas ve makas resmi user kazandý
				sonuc.setText("Rock beats scissor - you win!");
			} else if (user.equals("Rock") && comp.equals("Paper")) {
				System.out.println("Paper beats rock - you lose");// tas ve kagýt resmi user kaybetti
				sonuc.setText("Paper beats rock - you lose");
			} else if (user.equals("Paper") && comp.equals("Scissors")) {
				System.out.println("Scissors beats paper- you lose");
				sonuc.setText("Scissors beats paper- you lose");
			} // kagýt ve makas resmi user kaybetti
			else if (user.equals("Paper") && comp.equals("Rock")) {
				System.out.println("Paper beats rock - you win");// tas ve makas resmi user kazandý
				sonuc.setText("Paper beats rock - you win");
			} else if (user.equals("Scissors") && comp.equals("Rock")) {
				System.out.println("Rock beats scissors - you lose!");// makas ve tas resmi user kazandý
				sonuc.setText("Rock beats scissors - you lose!");
			} else if (user.equals("Scissors") && comp.equals("Paper")) {
				System.out.println("Scissors beats paper - you win!");// makas ve kagýt resmi user kazandý
				sonuc.setText("Scissors beats paper - you win!");
			}

			if (user.equals("bitir")) {
				x = false;
			}
		} while (x);

		
		dispose();
		yapabileceklerim yapabileceklerim = new yapabileceklerim();
		yapabileceklerim.setVisible(true);

		
		
	}
}
