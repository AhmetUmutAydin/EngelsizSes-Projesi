import com.mathworks.toolbox.javabuilder.MWCharArray;
import com.mathworks.toolbox.javabuilder.MWException;

import speechrec.kayit;
import speechrec.noise;
import speechrec.slient;
import speechrec.testword;
import speechrec.train;
import speechrec.train_all;

public class TranslateMain {
	slient slient = null;
	train train = null;
	train_all train_all = null;
	testword test = null;
	kayit kayit = null;
	noise noise = null;
	MWCharArray pc;
	MWCharArray folder;
	MWCharArray filename;
	String notSes = "ses bulunamadi";
	Object[] resultPt = null;

	public TranslateMain(Object[] resultPt, speechrec.slient slient, speechrec.train train,
			speechrec.train_all train_all, testword test, speechrec.kayit kayit, speechrec.noise noise, MWCharArray pc,
			MWCharArray folder, MWCharArray filename) {
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
	}

	public String cevir() throws MWException {
		Translate tanslate = new Translate();
		kayit.Untitled(pc, folder, filename);
		//noise.Un2(pc, folder, filename);
		slient.recs(pc, folder, filename);
		resultPt = test.test_word(1, pc, filename);
		String translatit = resultPt[0].toString();
		translatit = translatit.replaceAll("[0-9]", "").toLowerCase();
		String ouput = "";
		
		if (!translatit.equals(notSes)) {
			try {
				ouput = tanslate.translate("en", "tr", translatit);
				System.out.println(ouput);
			} catch (Exception e) {
				e.printStackTrace();;
			}
		} else {
			System.out.println("tekrar ses kaydedin");
			while (!translatit.equals(notSes)) {
				kayit.Untitled(pc, folder, filename);
				//noise.Un2(pc, folder, filename);
				slient.recs(pc, folder, filename);
				resultPt = test.test_word(1, pc, filename);
				translatit = resultPt[0].toString();
				translatit = translatit.replaceAll("[0-9]", "").toLowerCase();
			}
			try {
				ouput = tanslate.translate("en", "tr", translatit);
				System.out.println(ouput);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ouput;
	}
}
