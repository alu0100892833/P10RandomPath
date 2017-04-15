package random_path;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class PathGeneratorController {
    private PathModel model;
    private RandomPathView view;
    private JFrame window;

    public PathGeneratorController() {
        window = new JFrame("CAMINO ALEATORIO");
        window.setSize(1000, 600);
        window.setLayout(new FlowLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        model = new PathModel();
        view = new RandomPathView(model, window.getWidth(), window.getHeight());

        window.add(view);

        window.setVisible(true);
    }
}
