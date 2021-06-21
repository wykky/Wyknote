import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI {
    JFrame window; //class 1
    JTextArea textArea; //class 2
    JScrollPane scrollPane; // class 3
    JMenuBar menuBar; //class 4
    JMenu menuFile, menuEdit, menuSettings, menuHelp; //Class 5
    JMenuItem iNew, iNewWindow, iOpen, iSave, iSaveAs, iExit; //class 6

    public static void main(String[] args){
        new GUI();
    }
  
    //constructor
    public GUI(){
    createWindow();
    createTextArea();
    createMenuBar();
    createFileMenu();
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
        menuFile.add(iNew);
        iNewWindow =new JMenuItem("New WIndow");
        menuFile.add(iNewWindow);
        iOpen =new JMenuItem("Open...");
        menuFile.add(iOpen);
        iSave =new JMenuItem("Save");
        menuFile.add(iSave);
        iSaveAs =new JMenuItem("Save As...");
        menuFile.add(iSaveAs);
        iExit =new JMenuItem("Exit");
        menuFile.add(iExit);
    }

}


