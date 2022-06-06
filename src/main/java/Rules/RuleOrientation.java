package Rules;

import java.util.ArrayList;

public class RuleOrientation extends absRule{

	@Override
	public String check(String str) {
		str=str.toLowerCase();
		
		ArrayList<String>orintationMap=new ArrayList<>();
		
		orintationMap.add("select");
		orintationMap.add("from");
		orintationMap.add("where");
		orintationMap.add("and");
		orintationMap.add("or");
		orintationMap.add("group");
		orintationMap.add("having");
		orintationMap.add("order");
		orintationMap.add("limit");
		
		String pom[]=str.split(" ");
		ArrayList<String>strMap=new ArrayList<>();
		for(int i=0;i<pom.length;i++) {
			if(orintationMap.contains(pom[i]))
			strMap.add(pom[i]);
		}
		System.out.println("STR MAP FROM "+strMap);
		int intmap[]=new int[strMap.size()];
		for(int i=0;i<strMap.size();i++) {
			intmap[i]=orintationMap.indexOf(strMap.get(i));
		}
		ArrayList<String>orinetationRule=new ArrayList<>();
		int max=-1;
		for(int i=0;i<intmap.length;i++) {
		System.out.println("roijentaciona mapa from orientation rule "+intmap[i]);
			if(intmap[i]>max) {
				max=intmap[i];
			}
			else {
				orinetationRule.add(orintationMap.get(intmap[i]));
			}
		}
		String returnSTring="";

		
		for(int i=0;i<orinetationRule.size();i++) {
			returnSTring=returnSTring+orinetationRule.get(i)+",";
		}
		System.out.println("kranja mapa ako ima greske "+returnSTring);
		if(returnSTring!="")
		return  "\nsol::"+this.getSol().replaceAll("?", returnSTring)+"\ndes::"+this.getDes().replaceAll("?", returnSTring);
		return returnSTring;
	}

}