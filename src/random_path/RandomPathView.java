package random_path;

import javax.swing.*;
import java.awt.*;

/**
 * Este panel permite mostrar tanto el tablero sobre el que se va generando el camino aleatorio como los controles para modificar los parámetros de éste.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
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

        setLayout(new FlowLayout());

        controls = new ButtonsPanel(getWidth() / CONTROL_PANEL_PROPORTION, getHeight());
        pathPanel = new RandomPathPanel(model, getWidth() - controls.getWidth(), getHeight());

        add(pathPanel);
        add(controls);

        pack();
        System.out.println();
    }
}
