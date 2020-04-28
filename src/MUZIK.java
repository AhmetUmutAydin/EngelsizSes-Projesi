import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.mathworks.toolbox.javabuilder.MWCharArray;
import speechrec.*;

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

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MUZIK extends JFrame {
	
	
	String devam = "devam";
	String bitir = "bitir";
	String dur = "dur";
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
	private JPanel contentPane;
	JProgressBar progressBar;
	
	Image kapali;
	Image acik;
	JLabel mic;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MUZIK frame = new MUZIK();
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
	
	public MUZIK() {
		Initialize();
		
		
	}
	
	
	public MUZIK(Object[] resultP, speechrec.slient slient, speechrec.train train, speechrec.train_all train_all,
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
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMuzk = new JLabel("MUZIK");
		lblMuzk.setHorizontalAlignment(SwingConstants.CENTER);
		lblMuzk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMuzk.setBounds(73, 63, 183, 35);
		contentPane.add(lblMuzk);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(24, 109, 292, 14);
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		contentPane.add(progressBar);
		
		JLabel lblDur = new JLabel("1 : DUR");
		lblDur.setBounds(24, 134, 100, 14);
		contentPane.add(lblDur);
		
		JLabel lblDevam = new JLabel("2 : DEVAM");
		lblDevam.setBounds(24, 159, 100, 14);
		contentPane.add(lblDevam);
		
		JLabel lblBtr = new JLabel("3 : BITIR");
		lblBtr.setBounds(24, 184, 46, 14);
		contentPane.add(lblBtr);
		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(82, 236, 120, 114);
		contentPane.add(mic);
		
		
		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		
		JLabel back = new JLabel("");
		back.setBounds(0, 0, 684, 361);
		contentPane.add(back);
		
		Image img = new ImageIcon(this.getClass().getResource("music.jpg")).getImage();
		back.setIcon(new ImageIcon(img));
		
	}
	
	
	public void start(String inp) {
		CustomPlayer player = new CustomPlayer();
		boolean x = true;
		player.setPath(inp);
		player.play(-1);
		
		int sayac = 0;
		int sondurum = 2;		// 1 : dur , 2 : devam , 3 : bitir
			
		while (x) {
			
			try {

				mic.setIcon(new ImageIcon(acik));
				kayit.Untitled(pc, folder, filename);
				mic.setIcon(new ImageIcon(kapali));
				
				//noise.Un2(pc, folder, filename);
				slient.recs(pc, folder, filename);
				resultP = test.test_word(1, pc, filename,foldrname);
				String s = resultP[0].toString();
				s = s.replaceAll("[0-9]", "").toLowerCase();
			
				if (dur.equals(s)) {
					player.pause();
					sondurum = 1;
				} else if (devam.equals(s)) {
					player.resume();
					sondurum = 2;
				} else if (bitir.equals(s)) {
					player.pause();
					x = false;
					sondurum = 3;
					
					
					dispose();
					yapabileceklerim yapabileceklerim = new yapabileceklerim();
					yapabileceklerim.setVisible(true);
					
					
				} else {
					
					if(sondurum == 2) {
						progressBar.setValue(sayac);
						sayac = sayac + 2;
					}
					
				}

			} catch (Exception e) {
				System.out.println("Exception: " + e.toString());
			}
			
			
		}
	}
	
	
	
	
}
