package gui;

import app.AppCore;
import app.Main;
import lombok.Data;
import observer.Notification;
import observer.Subscriber;
import observer.enums.NotificationCode;
import resource.implementation.InformationResource;
import tree.implementation.SelectionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultTreeModel;

import Actions.ActionManager;
import Actions.MakePrty;
import Actions.RuleSetter;
import Rules.ManagerRules;

import java.awt.*;
import java.util.Vector;

@Data
public class MainFrame extends JFrame implements Subscriber {

    private static MainFrame instance = null;

    private AppCore appCore;
    private JTable jTable;
    private JScrollPane jsp;
    private JTree jTree;
    private JPanel left;
    private JPanel leftLeft;
    private JPanel leftTop;
    private MyPanel myPanel;
    private ActionManager actionManager;
    private ManagerRules managerRules;
    private RuleSetter ruleSetter;
    
    private MainFrame() {

    }

    public static MainFrame getInstance(){
        if (instance==null){
            instance=new MainFrame();
            instance.initialise();
        }
        return instance;
    }


    private void initialise() {
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        myPanel=new MyPanel();
        jTable = new JTable();
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 400));
        jTable.setFillsViewportHeight(true);
        
        actionManager=new ActionManager();
        managerRules=new ManagerRules();
        ruleSetter=new RuleSetter();
        ruleSetter.setInformation();
        this.add(new JScrollPane(jTable));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

    public void setAppCore(AppCore appCore) {
        this.appCore = appCore;
        this.appCore.addSubscriber(this);
        this.jTable.setModel(appCore.getTableModel());
        initialiseTree();
    }

    private void initialiseTree() {
        DefaultTreeModel defaultTreeModel = appCore.loadResource();
        
        jTree = new JTree(defaultTreeModel);
        jTree.addTreeSelectionListener(new SelectionListener());
        jsp = new JScrollPane(jTree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        left = new JPanel(new BorderLayout());
        MakePrty mp=new MakePrty();
        
        leftLeft=new JPanel();
        BoxLayout bl=new BoxLayout(leftLeft,BoxLayout.Y_AXIS);
        
        leftLeft.setLayout (bl); 
        leftTop=new JPanel();
        leftTop.setLayout(new FlowLayout());
        leftTop.add(actionManager.getMakePrty());
        leftTop.add(actionManager.getCsfInport());
        leftTop.add(actionManager.getCsfExport());
        leftLeft.add(leftTop);
        leftLeft.add(myPanel);
        left.add(jsp, BorderLayout.CENTER);
        left.add(leftLeft,BorderLayout.WEST);
        
        add(left, BorderLayout.WEST);
        pack();
    }


    @Override
    public void update(Notification notification) {


    }
}
