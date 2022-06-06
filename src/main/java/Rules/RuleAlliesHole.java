package Rules;

import java.util.ArrayList;

import Actions.PrtyTXTMYSQL;
import Actions.prtyTXT;

public class RuleAlliesHole extends absRule{

	@Override
	public String check(String str) {
		//str=str.toLowerCase();
		System.out.println("FROM  ALLIES RULE"+str);
		prtyTXT prtyTXT=new PrtyTXTMYSQL();
		ArrayList<String> reci=prtyTXT.getFont("setReciMSQL.txt");

		ArrayList<String>foa=new ArrayList<>();
		ArrayList<String>toCheck=new ArrayList<>();
		//System.out.println("FROM ALLIES skup reci="+font);
		if(str.contains("as")) {
			String pom[]=str.split("AS");
			System.out.println("dasdasdasds"+pom[1]);
			ArrayList<String>endReci=new ArrayList<>();
			String pom2="";
			
			
			for(int i=0;i<reci.size();i++) {
				if(pom[1].contains(reci.get(i))) {
					endReci.add(reci.get(i));
				}
			}
			
			if(endReci.size()!=0) {
			int min=2000000000;
			
			for(int i=0;i<endReci.size();i++) {
				if(pom[1].indexOf(endReci.get(i))<min ) {
					min=pom[1].indexOf(endReci.get(i));
				}
			}
			pom2=pom[1].substring(0, min);
			}
			else {
			pom2=pom[1];
			}
			System.out.println("END R"+endReci+" ociscen ako bog postoji "+pom2);
			String []wordsAs=pom2.split(" ");
			for(int i=0;i<wordsAs.length;i++) {
				System.out.println("nizic nizic="+wordsAs[i]);
			}
			if(wordsAs.length>2) {
				System.out.println("dve reci");
				if(wordsAs[1].charAt(0)!='\'' || wordsAs[wordsAs.length-1].charAt(wordsAs[wordsAs.length-1].length()-1)!='\'') {
						return  "\nsol::"+this.getSol().replaceAll("\\?", pom2)+"\ndes::"+this.getDes().replaceAll("\\?", pom2);
				}
				else return "";
			}
			else {
				return "";
			}
		}
		
		
		
		return "";
	}

}
