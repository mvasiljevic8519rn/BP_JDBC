package Rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import database.DatabaseImplementation;
import database.MYSQLrepository;
import gui.MainFrame;

public class RuleColumnsAndTableInDB extends absRule{

	public RuleColumnsAndTableInDB() {
		
	}
	
	String a=this.getName();
	@Override
	public String check(String str) {
		Map<String,ArrayList<String>> tables=((MYSQLrepository)((DatabaseImplementation)MainFrame.getInstance().getAppCore().getDatabase()).getRepository()).getDatabaseTables();

		int []helperMap = null;
		int tableFlag=0;
		int coulumbFlag=1;
		str=str.replaceAll("\\s+", " ");
		str=str.toLowerCase();
		System.out.println(" ULAZNI STRING "+str);
		String in[]=str.split(" ");
	    
		
		List<String> pom=Arrays.asList(in);
		
	    if(pom.contains("from")) {
	    	int start=pom.indexOf("from");
	    	
	    	if(tables.containsKey(pom.get(start+1))) {
	    		tableFlag=1;
	    		if(pom.get(start-1).contains("(")) {
		    		
		    		String a=pom.get(start-1);
		    		System.out.println(a);
		    		String pom1[]=a.split("\\(");
		    		String trn=pom1[1];
		    		trn=trn.replaceAll("\\)", "");
		    		System.out.println("posle remove"+trn);
		    		String lista[]=trn.split(",");
		    		helperMap=new int[lista.length];
		    		Arrays.fill(helperMap, 0);
	    			
		    		ArrayList<String>pomlist=tables.get(pom.get(start+1));
		    		
		    		for(int i=0;i<lista.length;i++) {
		    			if(pomlist.contains(lista[i])) {
		    				helperMap[i]=1;
		    			}
		    		}
		    	}
		    	else {
		    		String lista[]=pom.get(start-1).split(",");
		    		helperMap=new int[lista.length];
		    		Arrays.fill(helperMap, 0);
	    			
		    		ArrayList<String>pomlist=tables.get(pom.get(start+1));
		    		System.out.println("pom:LIsta "+pomlist);
		    		for(int i=0;i<lista.length;i++) {
		    			if(pomlist.contains(lista[i])) {
		    				helperMap[i]=1;
		    			}
		    		}
		    	
		    	}
		    }
	    	}
	    	
	    if(tableFlag==1) {
	    	 for(int i=0;i<helperMap.length;i++)
	     		if(helperMap[i]!=1)coulumbFlag=0;
	    }
		if(coulumbFlag==1 && tableFlag==1)
			return "";
		
		
		return "";
	}
	
}
