package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import app.AppCore;
import gui.MainFrame;
import resource.data.Row;
import tree.TreeItem;


public class CSFExport extends JButton implements ActionListener{

	ArrayList<ArrayList<String>> row;
	ArrayList<ArrayList<String>>data;
	ArrayList<String>columnNames;
	public CSFExport() {
		this.setText("CSFExport");
		this.addActionListener(this);
		row=new ArrayList<>();
		data=new ArrayList<>();
		columnNames=new ArrayList<>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=((TreeItem)MainFrame.getInstance().getJTree().getLastSelectedPathComponent()).getName();
		List<Row>rows =MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(name);
		
		for(int i=0;i<rows.size();i++) {
		String pom1=rows.get(i).getFields().toString();
		pom1=pom1.replace("{", "");
		pom1=pom1.replace("}", "");
		pom1=pom1.replace(" ", "");
		System.out.println(pom1);
		String pom2[]=pom1.split(",");
		
		ArrayList<String>pom4=new ArrayList<>();
		for(int j=0;j<pom2.length;j++) {
			String pom3[]=pom2[j].split("=");
			pom4.add(pom3[1]);
			if(i==0) {
			columnNames.add(pom3[0]);
			}
		}
		data.add(pom4);
		System.out.println(columnNames);
		}
		
		System.out.println(data);
		
		
		JFileChooser jfc=new JFileChooser();
		
		int responce=jfc.showSaveDialog(null);
		
		if(responce==JFileChooser.APPROVE_OPTION) {
			System.out.println("asda");
			String path=jfc.getSelectedFile().getAbsolutePath();
			System.out.println(path);
			try {
				FileWriter writer=new FileWriter(path);
				for(int i=0;i<columnNames.size();i++) {
					writer.write(columnNames.get(i));
					if(i<columnNames.size()-1)
					writer.write(",");
				}
					writer.write("\n");
				for(int i=0;i<data.size();i++) {
					ArrayList<String>pom=data.get(i);
					for(int j=0;j<pom.size();j++) {
						writer.write(pom.get(j));
						if(j<pom.size()-1) {
							writer.write(",");
						}
					}
					writer.write("\n");
				}
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		
		}
	}

}
