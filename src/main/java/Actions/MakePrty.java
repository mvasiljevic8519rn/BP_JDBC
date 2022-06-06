package Actions;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import gui.MainFrame;

public class MakePrty extends JButton implements ActionListener {
	
	prtyTXT prtyTXT=new PrtyTXTMYSQL();
	
	public MakePrty() {
		this.setText("make prty");
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("aaaaaaaa");
		String str=MainFrame.getInstance().getMyPanel().getTxtPane().getText();
		str=str.replaceAll("\\s+", " ");
		System.out.println("text from pane "+MainFrame.getInstance().getMyPanel().getTxtPane().getText());
		ArrayList<String> font=prtyTXT.getFont("setReciMSQL.txt");
		ArrayList<String> words=prtyTXT.getWords(str);
		int []map=new int[words.size()];
		Arrays.fill(map, 0);
		for(int i=0;i<words.size();i++) {
			for(int j=0;j<font.size();j++) {
				if(font.get(j).contains(" ")) {
					String []pom=font.get(j).split(" ");
					if(words.get(i).equalsIgnoreCase(pom[0]) && words.get(i+1).equalsIgnoreCase(pom[1])) {
						map[i]=1;
						map[i+1]=1;
						if(i!=0) {
							words.set(i,"\n"+words.get(i));
						}
						
						words.set(i, words.get(i).toUpperCase());
						words.set(i+1, words.get(i+1).toUpperCase());
					}
				}
				if(words.get(i).equalsIgnoreCase(font.get(j))) {
					map[i]=1;
					if(i!=0) {
						words.set(i,"\n"+words.get(i));
					}
					words.set(i, words.get(i).toUpperCase());
				}
			}
		}
		
		for(int i=0;i<map.length;i++)
		System.out.println(map[i]);
		MainFrame.getInstance().getMyPanel().getTxtPane().setText("");
		for(int i=0;i<words.size();i++) {
			if(map[i]==1) {
				appendToPane(MainFrame.getInstance().getMyPanel().getTxtPane(), words.get(i), Color.BLUE);
			}
			else {
				appendToPane(MainFrame.getInstance().getMyPanel().getTxtPane(), words.get(i), Color.BLACK);
			}
			appendToPane(MainFrame.getInstance().getMyPanel().getTxtPane(), " ", Color.BLACK);

		}
		
		
		appendToPane(MainFrame.getInstance().getMyPanel().getTxtPane(), "", Color.BLACK);
	}
	
	
	 private void appendToPane(JTextPane tp, String msg, Color c)
	    {
	        StyleContext sc = StyleContext.getDefaultStyleContext();
	        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

	        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
	        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

	        int len = tp.getDocument().getLength();
	        tp.setCaretPosition(len);
	        tp.setCharacterAttributes(aset, false);
	        tp.replaceSelection(msg);
	     
	        tp.replaceSelection("");
	    }
	
	
	
	

}
