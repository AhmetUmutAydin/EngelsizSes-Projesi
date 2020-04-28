import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cambodia.raven.DateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TAKVIM extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TAKVIM frame = new TAKVIM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TAKVIM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DateChooser dc = new DateChooser();
		dc.setSize(260, 225);
		dc.setLocation(0, 0);
		dc.setVisible(true);
		contentPane.add(dc);
		
		JButton btnMenuYeDon = new JButton("menu ye don");
		btnMenuYeDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				yapabileceklerim yapabileceklerim = new yapabileceklerim();
				yapabileceklerim.setVisible(true);
				
				
			}
		});
		btnMenuYeDon.setBounds(142, 236, 118, 23);
		contentPane.add(btnMenuYeDon);
		
		
		
	}
	
	
	
	
	
	
}
