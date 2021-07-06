import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GUI implements ActionListener{
    JFrame window; //class 1
    JTextArea textArea; //class 2
    JScrollPane scrollPane; // class 3
    JMenuBar menuBar; //class 4
    JMenu menuFile, menuEdit, menuSettings, menuHelp; // Class 5
    JMenuItem iNew, iNewWindow, iOpen, iSave, iSaveAs, iExit; // class 6
    JMenuItem iUndo, iCut, iCopy, iPaste, iDelete, iSelectAll, iSearch; // class 7
    JMenuItem iZoom, iFont, iColors, iWordWrap; // class 8
    JMenuItem iSendFeedback, iAboutWyknote; // class 9


    FileMenu file = new FileMenu(this);

    public static void main(String[] args){
        new GUI();
    }
  
    //constructor
    public GUI(){
    createWindow();
    createTextArea();
    createMenuBar();
    createFileMenu();
    createEditMenu();
    createSettingsMenu();
    createHelpMenu();
    window.setVisible(true);
    }
    //method #1 WINDOW
    public void createWindow(){
        window = new JFrame("Wyknote");
        window.setSize(600,600);
        window.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }

    // method #2 - TEXT AREA
    public void createTextArea(){
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// create scroll bar
       scrollPane.setBorder(BorderFactory.createEmptyBorder()); //eliminate border line
        window.add(scrollPane);
    }

    // method #3 - menu bar
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile =new JMenu("File");
        menuBar.add(menuFile);
        menuEdit =new JMenu("Edit");
        menuBar.add(menuEdit);
        menuSettings =new JMenu("Settings");
        menuBar.add(menuSettings);
        menuHelp =new JMenu("Help");
        menuBar.add(menuHelp);

    }
    //method #4 - file sub item menu
    public void createFileMenu(){
        iNew =new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        
        iNewWindow =new JMenuItem("New WIndow");
        menuFile.add(iNewWindow);
        
        iOpen =new JMenuItem("Open...");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);
        
        
        iSave =new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);
        
        iSaveAs =new JMenuItem("Save As...");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);
        
        iExit =new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    //method #5 - edit sub item menu
    public void createEditMenu(){
        iUndo =new JMenuItem("Undo");
        menuEdit.add(iUndo);
        iCut =new JMenuItem("Cut");
        menuEdit.add(iCut);
        iCopy =new JMenuItem("Copy");
        menuEdit.add(iCopy);
        iPaste =new JMenuItem("Paste");
        menuEdit.add(iPaste);
        iDelete =new JMenuItem("Delete");
        menuEdit.add(iDelete);
        menuEdit.addSeparator(); // add a separator
        iSelectAll =new JMenuItem("Select All");
        menuEdit.add(iSelectAll);
        iSearch =new JMenuItem("Search");
        menuEdit.add(iSearch);
    }

    //method #6 - settings sub item menu
    public void createSettingsMenu(){
        iZoom =new JMenuItem("Zoom");
        menuSettings.add(iZoom);
        iFont =new JMenuItem("Font");
        menuSettings.add(iFont);
        iColors =new JMenuItem("Colors");
        menuSettings.add(iColors);
        iWordWrap =new JMenuItem("Word Warp");
        menuSettings.add(iWordWrap);
        
    }
    //method #7 - help sub item menu
    public void createHelpMenu(){
        iSendFeedback =new JMenuItem("Send Feedback");
        menuHelp.add(iSendFeedback);
        iAboutWyknote =new JMenuItem("About Wyknote");
        menuHelp.add(iAboutWyknote);
    }

    //action performed method
    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command){
            case "New": file.newFile();break;
            case "Open": file.open();break;
            case "Save": file.save();break;
            case "SaveAs": file.saveAs();break;
            case "Exit": file.exit();break;
        }
    }
}



