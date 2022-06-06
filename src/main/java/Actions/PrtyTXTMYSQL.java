package Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrtyTXTMYSQL implements prtyTXT{

	@Override
	public ArrayList<String> getFont(String path) {
		ArrayList<String>words=new ArrayList<>();
		try {
			File file=new File(path);
			Scanner rd=new Scanner(file);
			while(rd.hasNextLine()) {
		        String line = rd.nextLine();
		        words.add(line);
			}
			rd.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return words;
	}

	@Override
	public ArrayList<String> getWords(String str) {
		ArrayList<String>reci=new ArrayList<>();
		String []pom=str.split(" ");
		for(int i=0;i<pom.length;i++) {
			reci.add(pom[i]);
			}
		return reci;
	}

}
