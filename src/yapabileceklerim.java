import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.awt.event.ActionEvent;

public class yapabileceklerim extends JFrame {

	private JPanel contentPane;
	private boolean isFindedAnyWork = false;
	private boolean flag = false;
	
	String oyun = "oyun";
	String kapat = "bitir";
	String cevir = "ingilizce";
	String posta = "email";
	String foto = "foto";
	String muzik = "muzik";
	String seskayitt = "seskayit";
	String yapilacaklar = "yapilacaklar";
	String bilgisayar = "bilgisayar";
	String takvim="takvim";
	
	
	Image kapali;
	Image acik;
	JLabel mic;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yapabileceklerim frame = new yapabileceklerim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	@SuppressWarnings("deprecation")
	public yapabileceklerim() {
		
		initialize();
		
		
		
		
		
	}
	
	String gon_mail;
	
	@SuppressWarnings("deprecation")
	public yapabileceklerim(String gonmail) {
		
		
		gon_mail = gonmail;
		
		
		initialize();
		
		
		
		
		
	}
	
	
	
	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYaplabileceklerListesi = new JLabel("YAPILAB\u0130LECEKLER L\u0130STES\u0130");
		lblYaplabileceklerListesi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYaplabileceklerListesi.setBounds(200, 11, 306, 29);
		contentPane.add(lblYaplabileceklerListesi);
		
		JLabel lblNewLabel = new JLabel("E-MAIL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(267, 50, 120, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("OYUN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(267, 70, 120, 14);
		contentPane.add(label);
		
		JLabel lblInglzce = new JLabel("INGILIZCE");
		lblInglzce.setHorizontalAlignment(SwingConstants.CENTER);
		lblInglzce.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInglzce.setBounds(267, 90, 120, 14);
		contentPane.add(lblInglzce);
		
		JLabel label_2 = new JLabel("FOTO");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(267, 110, 120, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("MÜZÝK");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(267, 130, 120, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("BÝLGÝSAYAR");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(267, 150, 120, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("SES KAYIT");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(267, 170, 120, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("BÝTÝR");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(267, 230, 120, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("TAKVÝM");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(267, 190, 120, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("YAPILACAKLAR");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(267, 210, 120, 14);
		contentPane.add(label_8);
		
		mic = new JLabel("");
		mic.setHorizontalAlignment(SwingConstants.CENTER);
		mic.setBounds(267, 247, 120, 114);
		contentPane.add(mic);
		
		kapali = new ImageIcon(this.getClass().getResource("kapali.png")).getImage();
		acik = new ImageIcon(this.getClass().getResource("acik.png")).getImage();
		mic.setIcon(new ImageIcon(kapali));
		
		JButton btnBasla = new JButton("basla");
		btnBasla.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try {
					Object[] result = null;
					slient slient = new slient();
					train train = new train();
					train_all train_all = new train_all();
					testword test = new testword();
					kayit kayit = new kayit();
					noise noise = new noise();
					String folders = "testing_words";
					String filenames = "denemeses";
					String pcs = "umut";//////////////////////////
					String tomail = gon_mail;
		            String frommail = "bitirmedeneme147369@gmail.com";
		            String frompass = "147369Mus";
					String inp = "C:\\Users\\umut\\Desktop\\sesler\\music\\music.mp3";
					MWCharArray pc = new MWCharArray(pcs);// pc adi alýncak
					MWCharArray folder = new MWCharArray(folders);// training_words mü testing_wordsü mü
					MWCharArray filename = new MWCharArray(filenames);// dosya adý
					MWCharArray oyunfolder = new MWCharArray("oyun");//
					MWCharArray ingilizcefolder = new MWCharArray("ingilizce");//
					MWCharArray muzikfolder = new MWCharArray("muzik");//
					MWCharArray bilgisayarfolder = new MWCharArray("bilgisayar");//
					MWCharArray emailfolder = new MWCharArray("email");//
					MWCharArray yapýlacaklarfolder = new MWCharArray("yapilacaklar");//
					MWCharArray mainfolder = new MWCharArray("main");//
					//
					MWCharArray fotofolder = new MWCharArray("foto");//
					MWCharArray takvimfolder = new MWCharArray("takvim");//
					MUZIK musicccc = new MUZIK(result, slient, train, train_all, test, kayit, noise, pc, folder, filename,muzikfolder);
					
					
					MWCharArray seskayityeri = new MWCharArray("java_ses");
					MWCharArray seskayitismi = new MWCharArray("yenises");
					SESKAYIT seskayit = new SESKAYIT(result, slient, train, train_all, test, kayit, noise, pc, seskayityeri, seskayitismi,
							pcs);
					
					OYUN oyna = new OYUN(result, slient, train, train_all, test, kayit, noise, pc, folder, filename,oyunfolder);
					
					TODOLIST list = new TODOLIST(result, slient, train, train_all, test, kayit, noise, pc, folder, filename, pcs,yapýlacaklarfolder);
		
					TRANSLATEE translate = new TRANSLATEE(result, slient, train, train_all, test, kayit, noise, pc, folder, filename,ingilizcefolder);
		            
		            BILGISAYAR cont=new BILGISAYAR(result, slient, train, train_all, test, kayit, noise, pc, folder, filename,bilgisayarfolder);
		                    

					MWCharArray kyt=new MWCharArray("java_ses");
					MWCharArray Kayitsesi=new MWCharArray("Kayitsesi");
		            MAIL eposta = new MAIL(result, slient, train, train_all, test, kayit, noise, pc, folder, filename,kyt,Kayitsesi,emailfolder);
		            
		            RESIM newresim;
		            
		            
		       //  	train_all.train_all_words(pc);
					
		       /*   kayit.Untitled(pc, folder, filename);/////////////////
					noise.Un2(pc, folder, filename);////////////////////
					slient.recs(pc, folder, filename);/////////////////////
		       */     

					boolean x = true;
					while (x) {
						
						mic.setIcon(new ImageIcon(acik));
						kayit.Untitled(pc, folder, filename);
						mic.setIcon(new ImageIcon(kapali));
						//noise.Un2(pc, folder, filename);
						slient.recs(pc, folder, filename);
						result = test.test_word(1, pc, filename,mainfolder);
						String s = result[0].toString();
						s = s.replaceAll("[0-9]", "").toLowerCase();
						if (s.equals(oyun)) {
							dispose();
							oyna.setVisible(true);
							oyna.oyna();
							
						} else if (s.equals(muzik)) {	
							dispose();
							musicccc.setVisible(true);
							musicccc.start(inp);
							
						} 
						else if (s.equals(foto)) {  
							
							post_image obj = new post_image();
							BufferedImage bi = obj.Mat2BufferedImage(obj.take_p());
							File outputfile = new File("C:\\Users\\" + pcs + "\\Desktop\\sesler\\image\\saved.jpg");
							ImageIO.write(bi, "jpg", outputfile);
							
							//dispose();
							newresim = new RESIM(bi);
							newresim.setVisible(true);
							
							boolean bb = true;
							do {
							     kayit.Untitled(pc, folder, filename);
							     //noise.Un2(pc, folder, filename);
							     slient.recs(pc, folder, filename);
							     result = test.test_word(1, pc, filename,fotofolder);
							     String as = result[0].toString();
							     as = as.replaceAll("[0-9]", "").toLowerCase();
							     if(as.equals("bitir")) {
							    	 bb=false;
							      
							     }
							    }while(bb);
								newresim.setVisible(false);
							
							

							

						} else if (s.equals(seskayitt)) {    
							
							dispose();
							seskayit.setVisible(true);
							seskayit.startrecord();
							
						} else if (s.equals(cevir)) {			
							dispose();
							translate.setVisible(true);
							translate.cevir();
							
						} else if (s.equals(posta)) {  
							dispose();
							eposta.setVisible(true);
				            eposta.sendmail(tomail, frommail, frompass,pcs);
							System.out.println("Mail atildi");

						
							
						} else if (s.equals(yapilacaklar) ) { 
							dispose();
							list.setVisible(true);
							list.workStart();

							
						} else if (s.equals(bilgisayar)) { 
							dispose();
							cont.setVisible(true);
							cont.kontrol();

							
						} 
						else if(s.equals(takvim)) { 
							System.out.println("Takvim goruntuleniyor");
							TAKVIM takvim = new TAKVIM();
							takvim.setVisible(true);
							
							
							 boolean ytr=true;
							    
							 
						     do {
						     kayit.Untitled(pc, folder, filename);
						    // noise.Un2(pc, folder, filename);
						     slient.recs(pc, folder, filename);
						     result = test.test_word(1, pc, filename,takvimfolder);
						     String as = result[0].toString();
						     as = as.replaceAll("[0-9]", "").toLowerCase();
						     if(as.equals("bitir")) {
						      ytr=false;
						      
						     }
						    }while(ytr);
							takvim.setVisible(false);

							
						}
						else if (s.equals("bitir")) {
							x = false;
						}
						

					}
					
				} catch (Exception ee) {
					System.out.println("Hata");
					System.out.println("Exception: " + ee.toString());
				}
				
				
				
				
				
			}
		});
		btnBasla.setBounds(585, 327, 89, 23);
		contentPane.add(btnBasla);
		

		
		
		
	
		
	}
}
