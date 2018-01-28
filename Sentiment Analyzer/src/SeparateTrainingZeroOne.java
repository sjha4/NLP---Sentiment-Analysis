import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SeparateTrainingZeroOne {

	public static void main(String[] args) {
		List<String> one = new ArrayList<String>();
		List<String> zero = new ArrayList<String>();
		Pattern p = Pattern.compile("\t1$");
		//Matcher matcher = regexp.matcher("");
		Charset charset = Charset.forName("US-ASCII");
		Path path = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Train.txt");
		try (BufferedReader reader = Files.newBufferedReader(path)) {
		    int count =0;
			String line = null;
		    while ((line = reader.readLine()) != null) {
		    	//System.out.println(line);
		    	Matcher matcher = p.matcher(line);
		    	while (matcher.find()) {
		            //System.out.print("found!");
		    		count++;
		    		try{
		    		    PrintWriter writer = new PrintWriter("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Training\\one\\File"+count+".txt", "UTF-8");
		    		    writer.println(line.substring(0,line.length()-2));
		    		    //writer.println("The second line");
		    		    writer.close();
		    		} catch (IOException e) {
		    		   // do something
		    		}
		    		//one.add(line);
		        }
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		Pattern p0 = Pattern.compile("\t0$");
		//Matcher matcher = regexp.matcher("");
		//Charset charset = Charset.forName("US-ASCII");
		Path path0 = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Train.txt");
		try (BufferedReader reader = Files.newBufferedReader(path0)) {
			int count =0;
			String line = null;
		    while ((line = reader.readLine()) != null) {
		    	//System.out.println(line);
		    	Matcher matcher = p0.matcher(line);
		    	while (matcher.find()) {
		    		count++;
		    		try{
		    		    PrintWriter writer = new PrintWriter("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Training\\zero\\File"+count+".txt", "UTF-8");
		    		    writer.println(line.substring(0,line.length()-2));
		    		    //writer.println("The second line");
		    		    writer.close();
		    		} catch (IOException e) {
		    		   // do something
		    		}
		        }
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		//Path fileone = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Validation\\1\\data.txt");
		//Path filezero = Paths.get("C:\\Users\\samir\\Desktop\\2nd Semester\\AI\\HW5\\Dataset\\Validation\\0\\data.txt");
		/*
		try {
			Files.write(fileone, one, Charset.forName("UTF-8"));
			Files.write(filezero, zero, Charset.forName("UTF-8"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

	}

}
