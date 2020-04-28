import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mathworks.toolbox.javabuilder.MWCharArray;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MAIL extends JFrame {

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
	MWCharArray kyt;
	MWCharArray Kayitsesi;
	MWCharArray foldrname;
	JLabel resimicintik;
	JLabel sesicintik;
	

	Image kapali;
	Image acik;
	JLabel mic;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIL frame = new MAIL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public MAIL() {
		Initialize();
	}

	public MAIL(Object[] resultP, speechrec.slient slient, speechrec.train train, speechrec.train_all train_all,
			testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc, MWCharArray folder,
			MWCharArray filename, MWCharArray Kayitsesi, MWCharArray kyt,MWCharArray foldrname) {
		
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
		this.Kayitsesi = Kayitsesi;
		this.kyt = kyt;
		this.foldrname=foldrname;
		Initialize();
	}
	
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("FOTO GONDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Image img = new ImageIcon(this.getClass().getResource("tik.jpg")).getImage();
				resimicintik.setIcon(new ImageIcon(img));
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(0, 0, 343, 135);
		contentPane.add(btnNewButton);
		
		JButton btnSesGonder = new JButton("SESKAYIT GONDER");
		btnSesGonder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Image img = new ImageIcon(this.getClass().getResource("tik.jpg")).getImage();
				sesicintik.setIcon(new ImageIcon(img));
				
			}
		});
		btnSesGonder.setBackground(SystemColor.activeCaption);
		btnSesGonder.setBounds(341, 0, 343, 135);
		contentPane.add(btnSesGonder);
		
		resimicintik = new JLabel("");
		resimicintik.setHorizontalAlignment(SwingConstants.CENTER);
		resimicintik.setBounds(0, 134, 343, 177);
		contentPane.add(resimicintik);
		
		sesicintik = new JLabel("");
		sesicintik.setHorizontalAlignment(SwingConstants.CENTER);
		sesicintik.setBounds(341, 134, 343, 177);
		contentPane.add(sesicintik);

		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(282, 247, 120, 114);
		contentPane.add(mic);

		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		
		
	}
	
	String seskayit = "seskayit";
	String foto = "foto";

	public void sendmail(String tomail, String frommail, String frompass, String pcs) throws Exception {
		boolean bol = true;

		do {
			
			mic.setIcon(new ImageIcon(acik));
			kayit.Untitled(pc, folder, filename);
			mic.setIcon(new ImageIcon(kapali));
			
			//noise.Un2(pc, folder, filename);
			 slient.recs(pc, folder, filename);
			 resultP = test.test_word(1, pc, filename,foldrname);
			 String choice = resultP[0].toString();
			 choice = choice.replaceAll("[0-9]", "").toLowerCase();
			String adres = "";
			if (choice.equals(seskayit)) {
				
				Image img = new ImageIcon(this.getClass().getResource("tik.jpg")).getImage();
				sesicintik.setIcon(new ImageIcon(img));
				
				kayit.Untitled(pc, kyt, Kayitsesi);
				adres = "C://Users//" + pcs + "//Desktop//sesler//java_ses//Kayitsesi.wav";////////
				SendAttachmentInEmail sendMail = new SendAttachmentInEmail();
				System.out.println(tomail + "---" + frommail + "----" + frompass + "----" + adres);
				sendMail.mailat(tomail, frommail, frompass, adres);
				choice = "bitir";
			} else if (choice.equals(foto)) {
				
				Image img = new ImageIcon(this.getClass().getResource("tik.jpg")).getImage();
				resimicintik.setIcon(new ImageIcon(img));
				
				post_image obj = new post_image();
				BufferedImage bi = obj.Mat2BufferedImage(obj.take_p());
				File outputfile = new File("C:\\Users\\" + pcs + "\\Desktop\\sesler\\image\\saved.jpg");
				ImageIO.write(bi, "jpg", outputfile);
				adres = "C://Users//" + pcs + "//Desktop//sesler//image//saved.jpg";
				choice = "bitir";
			}
			
			if (choice.equals("bitir")) {
				bol = false;
			}
			
		} while (bol);
		
		dispose();
		yapabileceklerim yap = new yapabileceklerim();
		yap.setVisible(true);
		
		

	}
}
