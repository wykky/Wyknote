import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileMenu {
    
    GUI gui;
    String fileName;
    String fileAddress;

    public FileMenu(GUI gui){
        this.gui = gui;
    }
    //Method to create a new file
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    //Method to open a file
    public void open(){

        FileDialog fd =new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile()!=null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
// to load containt of loaded file
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText(""); // to clearn text area
            String line = null;
            
            while ((line = br.readLine())!=null){
                gui.textArea.append(line + "\n");
            }
            br.close();
        }
        catch(Exception e){ System.out.println("FILE NOT OPENED!");}
    }
}

// 5/8 work on saving files