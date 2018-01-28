import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.Id3;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.core.DenseInstance;
 
public class id3Trigram {
 
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(
                new FileReader("Training.arff"));
    	Instances data = new Instances(reader);
    	reader.close();
    	/*BufferedReader readerVal = new BufferedReader(
                new FileReader("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Validation.arff"));
    	Instances valdata = new Instances(readerVal);
    	readerVal.close();*/
    	
    	// setting class attribute
    	data.setClassIndex(data.numAttributes() - 1); 
    	StringToWordVector filter = new StringToWordVector();
    	NGramTokenizer tokenizer=new NGramTokenizer();
    	  tokenizer.setNGramMinSize(3);
    	  tokenizer.setNGramMaxSize(3);
    	  filter.setTokenizer(tokenizer);
    	  filter.setInputFormat(data);
    	  Instances newData = Filter.useFilter(data, filter);
    	  NumericToNominal nm = new NumericToNominal();
      	nm.setInputFormat(newData);
      	Instances newData1=Filter.useFilter(newData, nm);
      	newData1.randomize(new java.util.Random(0));
    	int trainSize = (int) Math.round(newData1.numInstances() * 0.7);
    	int testSize = newData1.numInstances() - trainSize;
    	Instances train = new Instances(newData1, 0, trainSize);
    	Instances test = new Instances(newData1, trainSize, testSize);
    	Classifier cModel = (Classifier)new Id3();
    	cModel.buildClassifier(train);
    	//ObjectOutputStream oos = new ObjectOutputStream(
        //new FileOutputStream("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\id3Bigram.model"));
    	//oos.writeObject(cModel);
    	//oos.flush();
    	//oos.close();
    	//weka.core.SerializationHelper.write("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\id3.model", cModel);
    	//ObjectInputStream ois = new ObjectInputStream(
          //      new FileInputStream("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\id3.model"));
    	//Classifier cls = (Classifier) ois.readObject();
    	Evaluation eTest = new Evaluation(test);
    	eTest.evaluateModel(cModel, test);
    	String strSummary = eTest.toSummaryString();
    	System.out.println(strSummary);
    	System.out.println(eTest.toMatrixString());
   
    }
}