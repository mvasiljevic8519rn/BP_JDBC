package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

import database.DatabaseImplementation;
import database.MYSQLrepository;
import gui.MainFrame;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

public class SendQuery extends JButton implements ActionListener{

	public SendQuery() {
		this.setText("SendQuery");
		this.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=MainFrame.getInstance().getMyPanel().getTxtPane().getText();
		str=str.replaceAll("\\s+", " ");
		ArrayList<String>proverenaPravila= MainFrame.getInstance().getManagerRules().checkALLRules(str);
		System.out.println("--provera pravila"+proverenaPravila);
		int corectFlag=0;
		for(int i=0;i<proverenaPravila.size();i++) {
			String pom=MainFrame.getInstance().getMyPanel().getTxtPane().getText();
			pom=pom+" "+proverenaPravila.get(i);
			MainFrame.getInstance().getMyPanel().getTxtPane().setText(pom);
		}
		for(int i=0;i<proverenaPravila.size();i++) {
			if(!proverenaPravila.get(i).equalsIgnoreCase("")) {
				corectFlag=1;
			}
		}
		System.out.println(")))FLAG"+corectFlag);
		System.out.println("++provera pravila"+proverenaPravila);
		if(corectFlag==0) {
			//String pom=MainFrame.getInstance().getMyPanel().getTxtPane().getText().toLowerCase();
			MainFrame.getInstance().getAppCore().setDataToTable(str);
			System.out.println(str);
		}
		//Map<String,ArrayList<String>> pom=((MYSQLrepository)((DatabaseImplementation)MainFrame.getInstance().getAppCore().getDatabase()).getRepository()).getDatabaseTables();
		//System.out.println(pom);
		//System.out.println(pom.size());
		//System.out.println(pom.get(pom.size()-1));
//		//String in=MainFrame.getInstance().getMyPanel().getTxtPane().getText();
//		MainFrame.getInstance().getAppCore().setDataToTable(in);
//		MainFrame.getInstance().getAppCore().loadResource();
	}

}
