package random_path;

import javax.swing.*;
import java.awt.*;

public class RandomPathView extends JFrame {
    private static final int CONTROL_PANEL_PROPORTION = 6;

    private RandomPathPanel pathPanel;
    private ButtonsPanel controls;

    public RandomPathPanel getPathPanel() {
        return pathPanel;
    }

    public ButtonsPanel getControls() {
        return controls;
    }

    public RandomPathView(PathModel model, int width, int height) {
        super();
        setLayout(new BorderLayout());
        setSize(width, height);
        setTitle("CAMINO ALEATORIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        controls = new ButtonsPanel(width / CONTROL_PANEL_PROPORTION, height);
        pathPanel = new RandomPathPanel(model, width - controls.getWidth(), height);

        add(pathPanel);
        add(controls);
    }
}