import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TRANSLATEE extends JFrame {
	
	String bitir = "bitir";
	
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
	String notSes = "ses bulunamadi";
	Object[] resultPt = null;


	private JPanel contentPane;
	private JTextField textField;
	JLabel sonucc;
	private JLabel back;
	private JLabel mic;


	Image kapali;
	Image acik;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TRANSLATEE frame = new TRANSLATEE();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TRANSLATEE(Object[] resultPt, speechrec.slient slient, speechrec.train train,
			speechrec.train_all train_all, testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc,
			MWCharArray folder, MWCharArray filename,MWCharArray foldrname) {
		
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
		this.foldrname=foldrname;
		
		Initialize();
	}
	
	
	
	public TRANSLATEE() {
		Initialize();
	}
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00C7evirmek istedi\u011Fniz kelimeyi konusunuz : ");
		lblNewLabel.setBounds(410, 14, 241, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(478, 39, 163, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbleviriSonucu = new JLabel("\u00C7eviri Sonucu :");
		lbleviriSonucu.setBounds(548, 120, 93, 14);
		contentPane.add(lbleviriSonucu);
		
		sonucc = new JLabel("");
		sonucc.setHorizontalAlignment(SwingConstants.CENTER);
		sonucc.setForeground(Color.GREEN);
		sonucc.setBounds(541, 144, 110, 14);
		contentPane.add(sonucc);
		

		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(521, 214, 120, 114);
		contentPane.add(mic);
		

		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		
		back = new JLabel("");
		back.setForeground(new Color(173, 255, 47));
		back.setBounds(0, 0, 684, 361);
		contentPane.add(back);
		

		Image img = new ImageIcon(this.getClass().getResource("translator.jpg")).getImage();
		back.setIcon(new ImageIcon(img));
		
	}
	
	
	
	public void cevir() throws MWException {
		
		String translatit;
		do{
		
		Translate tanslate = new Translate();

		mic.setIcon(new ImageIcon(acik));
		kayit.Untitled(pc, folder, filename);
		mic.setIcon(new ImageIcon(kapali));

		
		//noise.Un2(pc, folder, filename);
		slient.recs(pc, folder, filename);
		resultPt = test.test_word(1, pc, filename,foldrname);
		translatit = resultPt[0].toString();
		translatit = translatit.replaceAll("[0-9]", "").toLowerCase();
		String ouput = "";
		
		
			
			if (!translatit.equals(notSes)) {
				try {
					ouput = tanslate.translate("tr", "en", translatit);
					textField.setText(translatit);
				} catch (Exception e) {
					e.printStackTrace();;
					
				}


				System.out.println(ouput);
				sonucc.setText(ouput);
			} else {
				System.out.println("tekrar ses kaydedin");
				while (translatit.equals(notSes)) {
					
					mic.setIcon(new ImageIcon(acik));
					kayit.Untitled(pc, folder, filename);
					mic.setIcon(new ImageIcon(kapali));
					
					//noise.Un2(pc, folder, filename);
					slient.recs(pc, folder, filename);
					resultPt = test.test_word(1, pc, filename,foldrname);
					translatit = resultPt[0].toString();
					translatit = translatit.replaceAll("[0-9]", "").toLowerCase();
				}
				try {
					ouput = tanslate.translate("tr", "en", translatit);
					textField.setText(translatit);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				System.out.println(ouput);
				sonucc.setText(ouput);
			}
			
			
		}while(!translatit.equals(bitir));
			
			
			

		dispose();
		yapabileceklerim yapabileceklerim = new yapabileceklerim();
		yapabileceklerim.setVisible(true);
			

			
		
		
	}
	
	
}
