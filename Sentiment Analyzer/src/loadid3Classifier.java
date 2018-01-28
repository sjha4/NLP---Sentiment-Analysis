import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

public class loadid3Classifier {
	public static void loadmodel() throws FileNotFoundException{
		FileInputStream fs = new FileInputStream("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\id3.model");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Classifier cls = (Classifier)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Evaluation eTest = new Evaluation(newData1);
		//eTest.evaluateModel(cModel, newData1);
		//String strSummary = eTest.toSummaryString();
		//System.out.println(strSummary);

	}
	public static void main(String[] args) {
		try {
			loadid3Classifier.loadmodel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
