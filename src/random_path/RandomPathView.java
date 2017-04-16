package random_path;

import javax.swing.*;

import java.awt.*;

public class RandomPathView extends JFrame {

    private RandomPathPanel pathPanel;
    private ButtonsPanel controls;

    public RandomPathPanel getPathPanel() {
        return pathPanel;
    }

    public ButtonsPanel getControls() {
        return controls;
    }

    public RandomPathView(PathModel model) {
        setLayout(new BorderLayout());
        setTitle("CAMINO ALEATORIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
                
        pathPanel = new RandomPathPanel(model);
        add(pathPanel, BorderLayout.CENTER);
        
        Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(fullScreen);
        
        controls = new ButtonsPanel(getWidth(), getHeight());
        add(controls, BorderLayout.EAST);
        //System.out.println("Dimensiones ventana: " + getWidth() + "x" + getHeight());
        //System.out.println("Dimensiones controles: " + controls.getWidth() + "x" + controls.getHeight());
        
        setVisible(true);
    }
}