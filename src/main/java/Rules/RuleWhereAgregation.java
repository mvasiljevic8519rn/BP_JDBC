package Rules;

import java.util.ArrayList;

public class RuleWhereAgregation extends absRule{

	@Override
	public String check(String str) {
		str=str.toLowerCase();
		System.out.println("FROM WHERE AGREGATION RULE"+str);
		
		ArrayList<String>foa=new ArrayList<>();
		ArrayList<String>toCheck=new ArrayList<>();
		
		foa.add("count");
		foa.add("sum");
		foa.add("min");
		foa.add("max");
		foa.add("avg");
		
		int flag =0;
		String returnString="";
		if(str.contains("where")) {
			String pom[]=str.split("where");
			String trn=pom[1];
			String use = null;
			
			
			if(pom[1].contains("group by")) {
				String pom1[]=trn.split("group by");
				use=pom1[0];
			}
			else if(pom[1].contains("having")) {
				String pom1[]=trn.split("having");
				use=pom1[0];

			}
			else if(pom[1].contains("order by")) {
				String pom1[]=trn.split("order by");
				use=pom1[0];

			}
			else if(pom[1].contains("limit")) {
				String pom1[]=trn.split("limit");
				use=pom1[0];
			}
			else {
				use=pom[1];
			}
			for(int i=0;i<foa.size();i++) {
				if(use.contains(foa.get(i))) {
					flag = 1;
					returnString=returnString+" "+foa.get(i);
				}
			}
			
			
			System.out.println("usseeeee="+returnString+"  flag "+flag);
		}
		if(returnString!="")
			return  "\nsol::"+this.getSol().replaceAll("?", returnString)+"\ndes::"+this.getDes().replaceAll("?", returnString);
			return returnString;
	}
}
