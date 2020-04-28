import java.awt.EventQueue;

import javax.swing.DefaultListModel;
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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;
import java.awt.Color;
import java.awt.SystemColor;

public class TODOLIST extends JFrame {

	private JPanel contentPane;
	
	String ekle = "ekle";
	
	String göster = "göster";
	String bitir = "bitir";
	String notSes = "ses bulunamadi";
	String sil = "sil";
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
	String pcs;
	JList jlist;
	Work work = new Work();
	

	Image kapali;
	Image acik;
	JLabel mic;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TODOLIST frame = new TODOLIST();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TODOLIST(Object[] resultP, speechrec.slient slient, speechrec.train train, speechrec.train_all train_all,
			testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc, MWCharArray folder,
			MWCharArray filename, String pcs,MWCharArray foldrname) {
		
		super();
		this.resultP = resultP;
		this.slient = slient;
		this.train = train;
		this.train_all = train_all;
		this.test = test;
		this.kayit = kayit;
		this.pcs = pcs;
		this.noise = noise;
		this.pc = pc;
		this.folder = folder;
		this.filename = filename;
		this.foldrname=foldrname;
		
		
		Initialize();
	}
	public TODOLIST() {
		
		Initialize();
		
	}
	
	
	
	public void Initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel yapýlacaklar = new JLabel("YAPILACAKLAR");
		yapýlacaklar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yapýlacaklar.setHorizontalAlignment(SwingConstants.CENTER);
		yapýlacaklar.setBounds(10, 11, 524, 34);
		contentPane.add(yapýlacaklar);
		
		jlist = new JList();
		jlist.setBounds(10, 56, 532, 294);
		contentPane.add(jlist);
		
		JLabel lblEklemekIin = new JLabel("Eklemek i\u00E7in :");
		lblEklemekIin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEklemekIin.setForeground(Color.BLACK);
		lblEklemekIin.setBounds(552, 57, 122, 14);
		contentPane.add(lblEklemekIin);
		
		JLabel lblEkle = new JLabel("Ekle");
		lblEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblEkle.setForeground(SystemColor.activeCaption);
		lblEkle.setBounds(552, 71, 122, 14);
		contentPane.add(lblEkle);
		
		JLabel lblSilmekIin = new JLabel("Silmek i\u00E7in :");
		lblSilmekIin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSilmekIin.setBounds(552, 100, 122, 14);
		contentPane.add(lblSilmekIin);
		
		JLabel lblSil = new JLabel("Sil");
		lblSil.setHorizontalAlignment(SwingConstants.CENTER);
		lblSil.setForeground(SystemColor.activeCaption);
		lblSil.setBounds(552, 117, 122, 14);
		contentPane.add(lblSil);
		
		JLabel lblCkmakIcin = new JLabel("C\u0131kmak icin");
		lblCkmakIcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCkmakIcin.setBounds(552, 139, 122, 14);
		contentPane.add(lblCkmakIcin);
		
		JLabel lblBitir = new JLabel("Bitir");
		lblBitir.setHorizontalAlignment(SwingConstants.CENTER);
		lblBitir.setForeground(SystemColor.activeCaption);
		lblBitir.setBounds(552, 156, 122, 14);
		contentPane.add(lblBitir);
		
		
		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(554, 236, 120, 114);
		contentPane.add(mic);
		

		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
			
		JLabel back = new JLabel("");
		back.setBounds(0, 0, 684, 361);
		contentPane.add(back);
		
		Image img1 = new ImageIcon(this.getClass().getResource("note.jpg")).getImage();
		back.setIcon(new ImageIcon(img1));
		
		
	}
	
	
	public void workStart() throws MWException, IOException {

		String todoL = "";
		String notSes = "ses bulunamadi";
		boolean flag = false;
		ArrayList<String> list = new ArrayList<String>();
		
		int counter = 5;
		int num = 5;
		
		do {
			
			list = work.ShowWork(pcs);
			
			
			String[] dizim = new String[list.size()];
			
			for(int i=0;i<list.size();i++) {
				dizim[i] = list.get(i);
			}
			
			DefaultListModel<String> DLMM = new DefaultListModel<String>();
			
			for(int i=0;i<dizim.length;i++) {
				DLMM.addElement(dizim[i]);
			}
			
			jlist.setModel(DLMM);
			
			
			mic.setIcon(new ImageIcon(acik));
			kayit.Untitled(pc, folder, filename);
			mic.setIcon(new ImageIcon(kapali));
			
			
			
			//noise.Un2(pc, folder, filename);
			slient.recs(pc, folder, filename);
			resultP = test.test_word(1, pc, filename,foldrname);
			todoL = resultP[0].toString();
			todoL = todoL.replaceAll("[0-9]", "").toLowerCase();
			
			if (todoL.equals(ekle)) {			
				
				do {
				kayit.Untitled(pc, folder, filename);
				//noise.Un2(pc, folder, filename);
				slient.recs(pc, folder, filename);
				resultP = test.test_word(1, pc, filename,foldrname);
				todoL = resultP[0].toString();
				todoL = todoL.replaceAll("[0-9]", "").toLowerCase();
			//	todoL = "baris" ;
				if(!todoL.equals(notSes)) {
					
			/*		String str = "s";
					while(counter>0) {
						todoL +=str;

						counter--;
					}
					num = num-1;
					counter=num;
				*/	
					list = work.AddWork(todoL, pcs);
					
					System.out.println("Eklendi");
					
					String[] dizi = new String[list.size()];
					
					for(int i=0;i<list.size();i++) {
						dizi[i] = list.get(i);
					}
					
					
					
					DefaultListModel<String> DLM = new DefaultListModel<String>();
					
					for(int i=0;i<dizi.length;i++) {
						DLM.addElement(dizi[i]);
					}
					
					jlist.setModel(DLM);
					
					
					flag = false;
				}
				else {
					System.out.println("ses algilanamadi tekrar deneyiniz");
					flag = true;
				}
				}while(flag==true);
				

			} else if (todoL.equals(sil)) {		
				
				do {
				kayit.Untitled(pc, folder, filename);
				//noise.Un2(pc, folder, filename);
				slient.recs(pc, folder, filename);
				resultP = test.test_word(1, pc, filename,foldrname);
				todoL = resultP[0].toString();
				todoL = todoL.replaceAll("[0-9]", "").toLowerCase();
			//	todoL = "barisssss";
				if(!todoL.equals(notSes)) {
					work.DeleteWork(todoL, pcs);
					System.out.println("Silindi");
					flag = false;
				}
				else {
					System.out.println("ses algilanamadi tekrar deneyiniz");
					flag = true;
				}
				}while(flag==true);

			} else if (todoL.equals(göster)) {

				work.ShowWork(pcs);

			} else {
				System.out.println("Boyle bir islem yok! Tekrar deneyin!");
			}
			
		} while (!todoL.equals("bitir"));
		
		
		
		
		dispose();
		yapabileceklerim yapabileceklerim = new yapabileceklerim();
		yapabileceklerim.setVisible(true);

	}
}
