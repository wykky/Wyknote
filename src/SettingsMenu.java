public class SettingsMenu {
    
    GUI gui;

    public SettingsMenu(GUI gui){
        this.gui = gui;
    }

    // word wrap method
    public void wordWrap(){
        if(gui.wordWrapOn==false){
            gui.wordWrapOn=true;
            gui.textArea.setLineWrap(true); // line wrap function
            gui.textArea.setWrapStyleWord(true); //to ensure that line break doesnt happen in middle of words
            gui.iWordWrap.setText("Word Wrap: On");
        } else if (gui.wordWrapOn==true){
            gui.wordWrapOn=false;
            gui.textArea.setLineWrap(false); // line wrap function
            gui.textArea.setWrapStyleWord(false); //to ensure that line break doesnt happen in middle of words
            gui.iWordWrap.setText("Word Wrap: Off");
        }
    }
}
