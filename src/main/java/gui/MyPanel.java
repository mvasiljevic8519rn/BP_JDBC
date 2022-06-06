package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  lombok.Data;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import Actions.SendQuery;
@Data
public class MyPanel extends JPanel{
	private JTextField field;
	private JTextField field2;
	private JButton button;
	private JTextArea txtArea;
	private JTextPane txtPane;
	private JScrollPane jsp;
	private SendQuery sendQuery;
	
	
	MyPanel(){
	txtPane=new JTextPane();
	jsp=new JScrollPane(txtPane);
	jsp.setPreferredSize(new Dimension(400,300));
	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	sendQuery=new SendQuery();
	this.add(jsp);
	this.add(sendQuery);
	this.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	
}