package Rules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;

import database.DatabaseImplementation;
import database.MYSQLrepository;
import gui.MainFrame;
import tree.TreeItem;

public class RuleCSVMachTable extends absRule{

	ArrayList<ArrayList<String>> row;
	ArrayList<String>columnNames;
	ArrayList<ArrayList<String>>data;
	
	public RuleCSVMachTable() {
		row=new ArrayList<>();
		columnNames=new ArrayList<>();
		data=new ArrayList<>();
	}
	
	
	@Override
	public String check(String str) {
		Map<String,ArrayList<String>> tables=((MYSQLrepository)((DatabaseImplementation)MainFrame.getInstance().getAppCore().getDatabase()).getRepository()).getDatabaseTables();
		String []pom=str.split("#");
		String tableName=pom[0];
		String returnString="";
		int flag=0;
		
		pom[1]=pom[1].replaceAll("\\[", "");
		pom[1]=pom[1].replaceAll("\\]", "");
		pom[1]=pom[1].replaceAll(" ", "");
		List<String>columns=Arrays.asList(pom[1].split(","));
		//System.out.println("FROM CSV tableName"+tableName);
		//System.out.println("FROM CSV columns="+columns.get(0)+columns.get(1));
		//System.out.println("mapica "+tables.get(tableName).get(0)+tables.get(tableName).get(1));
		int []map=new int[columns.size()];
		Arrays.fill(map, 0);
		
		for(int i=0;i<columns.size();i++) {
			if(tables.get(tableName).contains(columns.get(i))) {
				map[i]=1;
				flag=1;
			}else {
				returnString=returnString+columns.get(i)+",";
				if(i<columns.size()-1)
				returnString=returnString+" ";
			}
		}
		for(int i=0;i<map.length;i++)
		System.out.println(map[i]);
		System.out.println("RE"+returnString);
		if(returnString!="")
			return  "\nsol::"+this.getSol().replaceAll("\\?", returnString)+"\ndes::"+this.getDes().replaceAll("\\?", returnString);
			return returnString;
	}

}
