import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    MainFrame mainFrame;
    public DesignPanel(MainFrame mainFrame){
        this.setVisible(true);
        this.mainFrame=mainFrame;
        this.setLayout(new FlowLayout());

    }


}
