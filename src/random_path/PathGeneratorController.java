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
        window.setLayout(new FlowLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        model = new PathModel();
        view = new RandomPathView(model, 1500, 1000);

        window.add(view);
        window.pack();

        window.setVisible(true);
    }
}
