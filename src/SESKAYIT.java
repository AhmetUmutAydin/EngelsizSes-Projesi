import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class SESKAYIT extends JFrame {

	private JPanel contentPane;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SESKAYIT frame = new SESKAYIT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel kaydediliyor;
	private JLabel back;
	
	public SESKAYIT() {
		Initialize();
	}
	
	public SESKAYIT(Object[] resultP, speechrec.slient slient, speechrec.train train, speechrec.train_all train_all,
			testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc, MWCharArray folder,
			MWCharArray filename, String pcs) {
		
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
		
		Initialize();
	}
	
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSesKayt = new JLabel("SES KAYIT");
		lblSesKayt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSesKayt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesKayt.setBounds(268, 103, 369, 35);
		contentPane.add(lblSesKayt);
		
		kaydediliyor = new JLabel("Ses Kaydediliyor...");
		kaydediliyor.setHorizontalAlignment(SwingConstants.CENTER);
		kaydediliyor.setBounds(250, 195, 406, 14);
		contentPane.add(kaydediliyor);
		
		back = new JLabel("");
		back.setBounds(32, 55, 268, 197);
		contentPane.add(back);
		
		

		Image img = new ImageIcon(this.getClass().getResource("seskayit.jpg")).getImage();
		back.setIcon(new ImageIcon(img));
	}
	
	
	
	public void startrecord() throws InterruptedException{
		try {

			
			kayit.Untitled(pc, folder, filename);
			kaydediliyor.setText("Kaydedildi.");
			
			dispose();
			yapabileceklerim yapabileceklerim = new yapabileceklerim();
			yapabileceklerim.setVisible(true);
			
			
		} catch (MWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
