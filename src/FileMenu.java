import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
        fileName = null;
        fileAddress = null;
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
        catch(Exception e)
        { System.out.println("FILE NOT OPENED!");
    }
    }

    public void save(){
        if(fileName==null){
            saveAs();
        }else{
            try{ FileWriter fw = new FileWriter( fileAddress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName); // set the file name
                fw.close();

            } catch(Exception e)
            { System.out.println("SOMETHING IS WRONG BUDDY");}


        }
    }




    public void saveAs(){
        FileDialog fd =new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try{
            FileWriter fw = new FileWriter( fileAddress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch(Exception e)
        { System.out.println("SOMETHING IS WRONG BUDDY");}
    }

    public void exit(){
        System.exit(0);
    }
}
/// 6/8