import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame(){
        super("asta e");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        designPanel=new DesignPanel(this);
        controlPanel=new ControlPanel(this,this.designPanel);

        this.add(designPanel, BorderLayout.CENTER);
        this.add(controlPanel,BorderLayout.NORTH);

    }

    public static void main(String[] args){
        MainFrame mainFrame=new MainFrame();
        mainFrame.setVisible(true);

    }
}
