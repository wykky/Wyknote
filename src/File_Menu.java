import java.awt.FileDialog;

public class File_Menu {
    
    GUI gui;

    public File_Menu(GUI gui){
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
    }
}
