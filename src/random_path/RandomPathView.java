package random_path;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class RandomPathView extends JFrame {


    class ButtonsPanel extends JPanel {
        private static final int BUTTON_PROPORTIONS = 2;

        private JButton start, color, stop;
        private JTextField dimensions;

        public ButtonsPanel(int width, int height) {
            super();
            setSize(width, height);
            addElements();
            setListeners();
        }

        private void addElements() {
            start = new JButton("START");
            color = new JButton("COLOR");
            stop = new JButton("STOP");
            dimensions = new JTextField("DENSITY");

            start.setPreferredSize(new Dimension(getWidth() / BUTTON_PROPORTIONS, start.getHeight()));
            color.setPreferredSize(new Dimension(getWidth() / BUTTON_PROPORTIONS, color.getHeight()));
            stop.setPreferredSize(new Dimension(getWidth() / BUTTON_PROPORTIONS, stop.getHeight()));
            dimensions.setPreferredSize(new Dimension(getWidth() / BUTTON_PROPORTIONS, dimensions.getHeight()));

            add(start);
            add(color);
            add(stop);
            add(dimensions);
        }

        private void setListeners() {

        }
    }
}
