import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Robot;

import javax.swing.ImageIcon;
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
import javax.swing.SwingConstants;
import java.awt.Font;

public class BILGISAYAR extends JFrame {

	private JPanel contentPane;

	slient slient = null;
	train train = null;
	train_all train_all = null;
	testword test = null;
	kayit kayit = null;
	noise noise = null;
	MWCharArray pc;
	MWCharArray folder;
	MWCharArray filename;
	MWCharArray foldranme;
	String notSes = "ses bulunamadi";
	Object[] resultPt = null;
	

	Image kapali;
	Image acik;
	JLabel mic;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BILGISAYAR frame = new BILGISAYAR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BILGISAYAR() {
		Initialize();
	}
	
	public BILGISAYAR(Object[] resultPt, speechrec.slient slient, speechrec.train train,
			speechrec.train_all train_all, testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc,
			MWCharArray folder, MWCharArray filename,MWCharArray foldranme) {
		
		super();
		this.resultPt = resultPt;
		this.slient = slient;
		this.train = train;
		this.train_all = train_all;
		this.test = test;
		this.kayit = kayit;
		this.noise = noise;
		this.pc = pc;
		this.folder = folder;
		this.filename = filename;
		this.foldranme=foldranme;
		
		Initialize();
	}
	
	
	
	
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAG");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(263, 50, 84, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblSol = new JLabel("SOL");
		lblSol.setHorizontalAlignment(SwingConstants.CENTER);
		lblSol.setBounds(263, 78, 84, 28);
		contentPane.add(lblSol);
		
		JLabel lblYukar = new JLabel("YUKARI");
		lblYukar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYukar.setBounds(263, 109, 84, 28);
		contentPane.add(lblYukar);
		
		JLabel lblAsag = new JLabel("ASAGI");
		lblAsag.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsag.setBounds(263, 139, 84, 28);
		contentPane.add(lblAsag);
		
		JLabel lblTkla = new JLabel("TIKLA");
		lblTkla.setHorizontalAlignment(SwingConstants.CENTER);
		lblTkla.setBounds(263, 167, 84, 28);
		contentPane.add(lblTkla);
		
		JLabel lblBosluk = new JLabel("BOSLUK");
		lblBosluk.setHorizontalAlignment(SwingConstants.CENTER);
		lblBosluk.setBounds(263, 195, 84, 28);
		contentPane.add(lblBosluk);
		
		JLabel lblKlavye = new JLabel("KLAVYE");
		lblKlavye.setHorizontalAlignment(SwingConstants.CENTER);
		lblKlavye.setBounds(263, 223, 84, 28);
		contentPane.add(lblKlavye);
		
		JLabel lblEnter = new JLabel("ENTER");
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setBounds(263, 251, 84, 28);
		contentPane.add(lblEnter);
		
		JLabel lblYaplablecekIslemler = new JLabel("YAPILABILECEK ISLEMLER");
		lblYaplablecekIslemler.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYaplablecekIslemler.setHorizontalAlignment(SwingConstants.CENTER);
		lblYaplablecekIslemler.setBounds(122, 11, 366, 28);
		contentPane.add(lblYaplablecekIslemler);
		
		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(523, 236, 120, 114);
		contentPane.add(mic);

		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		
		
		JLabel BACK = new JLabel("");
		BACK.setBounds(0, 0, 684, 361);
		contentPane.add(BACK);
		
		Image img = new ImageIcon(this.getClass().getResource("robot.png")).getImage();
		BACK.setIcon(new ImageIcon(img));
	}
	
	
	
	
	
	
	
	
	
	
	
	public void kontrol() throws Exception {
		
		bilgisayarkontrol g = new bilgisayarkontrol();
		Robot ro = new Robot();
		boolean ter = true;

		{

			do {
				
				mic.setIcon(new ImageIcon(acik));
				kayit.Untitled(pc, folder, filename);
				mic.setIcon(new ImageIcon(kapali));
				
				
				//noise.Un2(pc, folder, filename);
				slient.recs(pc, folder, filename);
				resultPt = test.test_word(1, pc, filename,foldranme);
				String controlIt = resultPt[0].toString();
				controlIt = controlIt.replaceAll("[0-9]", "").toLowerCase();
				
				
				if (controlIt.equals("sag")) {
					int x = MouseInfo.getPointerInfo().getLocation().x;
					int y = MouseInfo.getPointerInfo().getLocation().y;
					int a = 100;
					int b = 0;
					g.movemodify(ro, a, b, x, y);
				} else if (controlIt.equals("asagi")) {
					int x = MouseInfo.getPointerInfo().getLocation().x;
					int y = MouseInfo.getPointerInfo().getLocation().y;
					int c = 0;
					int d = 100;
					g.movemodify(ro, c, d, x, y);

				} else if (controlIt.equals("sol")) {
					int x = MouseInfo.getPointerInfo().getLocation().x;
					int y = MouseInfo.getPointerInfo().getLocation().y;
					int e = -100;
					int f = 0;
					g.movemodify(ro, e, f, x, y);
				} else if (controlIt.equals("yukari")) {
					int x = MouseInfo.getPointerInfo().getLocation().x;
					int y = MouseInfo.getPointerInfo().getLocation().y;
					int e = 0;
					int f = -100;
					g.movemodify(ro, e, f, x, y);
				} else if (controlIt.equals("tikla")) {
					g.doubleClickMouse(ro);

				} else if (controlIt.equals("bosluk")) {
					g.pressspace(ro);
				} else if (controlIt.equals("enter")) {
					g.pressEnter(ro);
				} else if (controlIt.equals("klavye")) {

					boolean ter2 = true;
					do {
						
						kayit.Untitled(pc, folder, filename);
					//noise.Un2(pc, folder, filename);
					slient.recs(pc, folder, filename);
					resultPt = test.test_word(1, pc, filename,foldranme);
					
					controlIt = resultPt[0].toString();
					controlIt = controlIt.replaceAll("[0-9]", "").toLowerCase();
					
					
				

						if (!controlIt.equals("dur") && !controlIt.equals(notSes)) {
							
							g.type(ro, controlIt);
							
							
						} else if (controlIt.equals("dur")) {
							ter2 = false;

						}

					} while (ter2);

				} else if (controlIt.equals("bitir")) {
					dispose();
					yapabileceklerim yapabileceklerim = new yapabileceklerim();
					yapabileceklerim.setVisible(true);
					ter = false;
					
				}
			} while (ter);

		}

	}
}
