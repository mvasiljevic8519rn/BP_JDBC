package Rules;
import java.util.ArrayList;

import gui.MainFrame;
import lombok.Data;

@Data
public class ManagerRules {
	
	private RuleColumnsAndTableInDB ruleColumnsAndTableInDB;
	private RuleOrientation ruleOrientation;
	private RuleAgregationGroupBy ruleAgregationGroupBy;
	
	private RuleAlliesHole ruleAlliesHole;
	private RuleCSVMachTable ruleCSVMachTable;
	private RuleForenKey ruleForenKey;
	
	private RuleWhereAgregation ruleWhereAgregation;
	
	private ArrayList<Rule>rules;
	
	public ManagerRules() {
		rules=new ArrayList<>();
		
		ruleWhereAgregation=new RuleWhereAgregation();
		rules.add(ruleWhereAgregation);
		
		ruleForenKey=new RuleForenKey();
		rules.add(ruleForenKey);
		
		ruleCSVMachTable=new RuleCSVMachTable();
//		rules.add(ruleCSVMachTable);
		
		ruleAgregationGroupBy=new RuleAgregationGroupBy();
		rules.add(ruleAgregationGroupBy);
		
		ruleColumnsAndTableInDB=new RuleColumnsAndTableInDB();
		rules.add(ruleColumnsAndTableInDB);
		
		ruleAlliesHole=new RuleAlliesHole();
		rules.add(ruleAlliesHole);
		
		ruleOrientation=new RuleOrientation();
		rules.add(ruleOrientation);
		
	}
	
	public ArrayList<String> checkALLRules(String str){
		ArrayList<String>pom=new ArrayList<>();
		for(int i=0;i<rules.size();i++) {
			pom.add(rules.get(i).check(str));
		}
		return pom;
	}
	
	
	
}
