package Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rules.InporteRule;
import Rules.ManagerRules;
import gui.MainFrame;

public class RuleSetter {
	List<InporteRule>inporteRules=null;
	public RuleSetter() {
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			inporteRules=Arrays.asList(mapper.readValue(Paths.get("rules.json").toFile(), InporteRule[].class));
			inporteRules.forEach(System.out::println);
			this.setInformation();
		
		
		
		
		
		
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setInformation() {
		ManagerRules meRules=MainFrame.getInstance().getManagerRules();
		for(int i=0;i<inporteRules.size();i++) {
			if(i==0) {
				MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().setSol(inporteRules.get(i).getSol());
				System.out.println("#####proverica"+MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().getId()+MainFrame.getInstance().getManagerRules().getRuleColumnsAndTableInDB().getSol());
			}
			if(i==1) {
				MainFrame.getInstance().getManagerRules().getRuleOrientation().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleOrientation().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleOrientation().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleOrientation().setSol(inporteRules.get(i).getSol());
			}
			if(i==2) {
				MainFrame.getInstance().getManagerRules().getRuleAlliesHole().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleAlliesHole().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleAlliesHole().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleAlliesHole().setSol(inporteRules.get(i).getSol());
			}
			if(i==3) {
				MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().setSol(inporteRules.get(i).getSol());
			}
			if(i==4){
				MainFrame.getInstance().getManagerRules().getRuleWhereAgregation().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleWhereAgregation().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleWhereAgregation().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleWhereAgregation().setSol(inporteRules.get(i).getSol());
			}
			if(i==5){
				MainFrame.getInstance().getManagerRules().getRuleAgregationGroupBy().setId(inporteRules.get(i).getId());
				MainFrame.getInstance().getManagerRules().getRuleAgregationGroupBy().setName(inporteRules.get(i).getName());
				MainFrame.getInstance().getManagerRules().getRuleAgregationGroupBy().setDes(inporteRules.get(i).getDes());
				MainFrame.getInstance().getManagerRules().getRuleAgregationGroupBy().setSol(inporteRules.get(i).getSol());
			}
		}
	}
	
}
