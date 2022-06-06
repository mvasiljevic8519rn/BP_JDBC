package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import com.mysql.cj.PreparedQuery;
import database.DatabaseImplementation;
import database.MYSQLrepository;
import gui.MainFrame;
import resource.data.Row;
import tree.TreeItem;

public class CSFInport extends JButton implements ActionListener{

	ArrayList<ArrayList<String>> row;
	ArrayList<String>columnNames;
	ArrayList<ArrayList<String>>data;
	
	public CSFInport() {
		this.setText("CSFInport");	
		this.addActionListener(this);
		row=new ArrayList<>();
		columnNames=new ArrayList<>();
		data=new ArrayList<>();
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser jfc=new JFileChooser();
		
		int responce=jfc.showOpenDialog(null);
		
		if(responce==JFileChooser.APPROVE_OPTION) {
		File file=new File(jfc.getSelectedFile().getAbsolutePath());
		try {
			Scanner fileIn=new Scanner(file);
			while(fileIn.hasNextLine()) {
				String []red=fileIn.nextLine().split(",");
				ArrayList<String>pom=new ArrayList<>();
				for(int i=0;i<red.length;i++) {
					pom.add(red[i]);
				}
				row.add(pom);	
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		}
		 
		String query="";
		String tableName=((TreeItem)MainFrame.getInstance().getJTree().getLastSelectedPathComponent()).getName();
		System.out.println(row.get(0).toString());
		System.out.println("FRom csvImport"+MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().check(tableName+"#"+row.get(0).toString()) +"");
		if(MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().check(tableName+"#"+row.get(0).toString()).equalsIgnoreCase("") ) {
			for(int i=1;i<row.size();i++) {
				query="insert into "+tableName+" (";
				ArrayList<String> rowCur=row.get(i);
				for(int j=0;j<rowCur.size();j++) {
					query=query+row.get(0).get(j);
					if(j<rowCur.size()-1) {
						query=query+",";
					}
				}
				query=query+") values (";
				for(int j=0;j<rowCur.size();j++) {
					query=query+"'"+rowCur.get(j)+"'";
					if(j<rowCur.size()-1) {
						query=query+",";
					}
				}
				query=query+")";
				MainFrame.getInstance().getAppCore().updateDataToTable(query);
			}}
			else {
				MainFrame.getInstance().getMyPanel().getTxtPane().setText(MainFrame.getInstance().getManagerRules().getRuleCSVMachTable().check(tableName+"#"+row.get(0).toString()));
			}
		
	
			//System.out.println(query);
			MainFrame.getInstance().getAppCore().updateDataToTable(query);		
			}
//		System.out.println(row);
	}
	
	
	
	

