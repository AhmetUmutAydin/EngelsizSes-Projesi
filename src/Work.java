

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Work {
	
	ArrayList <String> isler =new ArrayList<String>();
	boolean flagforthesame = true;
	
	
	public ArrayList<String> AddWork(String str ,String pc) {
		String adres="C:\\Users\\"+ pc +"\\Desktop\\sesler\\ToDoList.txt";
		
		ArrayList<String> dondurelecek = new ArrayList<String>();
		try {		
			//dosyadakileri okuyup listeye atacaz ve yeni geleni o listenin sonuna ekleyecez
			FileReader newfile = new FileReader(adres);
			BufferedReader br = new BufferedReader(newfile);
			
			String sira = br.readLine();
			
			while(sira!=null) {
				
				isler.add(sira);
				
				if(sira.equalsIgnoreCase(str)) {
					flagforthesame = false;
				}
				
				
				sira = br.readLine();
				
			}
			if(flagforthesame == true) {
				isler.add(str);					// yeni geleni listeye ekledik. Ayný degilse
			}
			        
			
			
			br.close();
			
			
		}catch(Exception e) {
			
		}
		
		try { //arraylisti dosyaya yaz
			
			FileWriter newfile = new FileWriter(adres);
			BufferedWriter br = new BufferedWriter(newfile);
			
			for(int i=0;i<isler.size();i++) {
				br.append(isler.get(i) + " ");
			}
			
			
			br.close();
			
			
		}catch(Exception e) {
			
		}

		//dosyayý tekrar okudum dondurmek icin
		try {		
			FileReader newfile = new FileReader(adres);
			BufferedReader br = new BufferedReader(newfile);
			
			String line = br.readLine();
			String[]dizi = line.split(" ");
			
			for(int i = 0;i<dizi.length;i++) {
				
				dondurelecek.add(dizi[i]);
				
			}
			
			br.close();
			
			
		}catch(Exception e) {
			
		}
		
		
		
		
		isler.clear();
		return dondurelecek;
		
	}
	
	public void DeleteWork(String str,String pc) {
		  String adres="C:\\Users\\"+ pc +"\\Desktop\\sesler\\ToDoList.txt";
		try {		
			//dosyadakileri okuyup listeye atacaz ve yeni geleni o listede arayýp silecez
			FileReader newfile = new FileReader(adres);
			BufferedReader br = new BufferedReader(newfile);
			
			String sira = br.readLine();
			String []dizi = sira.split(" ");
			
			
			for(int i=0;i<dizi.length;i++) {
				isler.add(dizi[i]);
			}
			for(int i=0;i<isler.size();i++) {
				
				if(isler.get(i).equals(str)) {
					isler.remove(i);
				}
				
			}
			br.close();
			
			
		}catch(Exception e) {
			
		}
		
		
		try { //arraylisti dosyaya yaz
			
			FileWriter newfile = new FileWriter(adres);
			BufferedWriter br = new BufferedWriter(newfile);
			
			for(int i=0;i<isler.size();i++) {
				br.append(isler.get(i) + " ");
			}
			
			
			br.close();
			
			
		}catch(Exception e) {
			
		}
		
		
		isler.clear();
	}
	
	
	

	public ArrayList<String> ShowWork(String pc) {
		
		String adres="C:\\Users\\"+ pc +"\\Desktop\\sesler\\ToDoList.txt";
		ArrayList<String> dondurelecek = new ArrayList<String>();
		
		try {		
			//dosyadakileri okuyup listeye atacaz ve yeni geleni o listede arayýp silecez
			FileReader newfile = new FileReader(adres);
			BufferedReader br = new BufferedReader(newfile);
			
			String sira = br.readLine();
			String []dizi = sira.split(" ");
			
			
			for(int i = 0;i<dizi.length;i++) {
				
				dondurelecek.add(dizi[i]);
				
			}
			
			br.close();
			
			
			
		}catch(Exception e) {
			
		}
		
		
		
		isler.clear();
		return dondurelecek;
		
		
		
	}
	

}
