package Actions;

import lombok.Data;

@Data
public class ActionManager{
	
	private SendQuery sendQuery;
	private MakePrty makePrty;
	private CSFInport csfInport;
	private CSFExport csfExport;
	
	public ActionManager() {
		sendQuery=new SendQuery();
		makePrty=new MakePrty();
		csfInport=new CSFInport();
		csfExport=new CSFExport();
	}


	
}
