
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Split7030 {
	/*List<String> lines = Arrays.asList("The first line", "The second line");
	Path file = Paths.get("the-file-name.txt");
	Files.write(file, lines, Charset.forName("UTF-8"));
	*/
	public static void main(String[] args) {
		List<String> training = new ArrayList<String>();
		List<String> validation = new ArrayList<String>();
		int train =0, test=0, total=0;
		Charset charset = Charset.forName("US-ASCII");
		Path path = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\sentiment labelled sentences\\sentiment labelled sentences\\Training.txt");
		try (BufferedReader reader = Files.newBufferedReader(path)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	total++;
		    	if(Math.random()<0.7) {
		    		train++;
		    		training.add(line);
		    	}
		    	else{
		    			test++;
		    			validation.add(line);
		    	}
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		System.out.println("Total: "+ total + "train: " + train + "test: " + test );
		System.out.println(train/total);
		Path filetrain = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Train.txt");
		try {
			Files.write(filetrain, training, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Path filevalid = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Validation.txt");
		try {
			Files.write(filevalid, validation, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
