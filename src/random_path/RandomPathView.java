package random_path;

import javax.swing.*;
import java.awt.*;

/**
 * Este panel permite mostrar tanto el tablero sobre el que se va generando el camino aleatorio como los controles para modificar los parámetros de éste.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
public class RandomPathView extends JPanel {
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
        setSize(width, height);
        setLayout(new FlowLayout(FlowLayout.LEADING));

        controls = new ButtonsPanel(getWidth() / 6, getHeight());
        pathPanel = new RandomPathPanel(model, getWidth() - controls.getWidth(), getHeight());

        add(pathPanel);
        add(controls);
    }
}
