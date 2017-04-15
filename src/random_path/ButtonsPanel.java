package random_path;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase permite instanciar un panel de botones con una serie de controles para manejar parámetros de la generación del camino aleatorio.
 * Tiene un botón de START y STOP para iniciar y detener la generación del camino.
 * Tiene un botón COLOR para modificar aleatoriamente el color del trazo.
 * Tiene un área de texto donde introducir las dimensiones del tablero.
 * Tiene un área de texto donde especificar el temporizador para la generación del camino.
 * Estas últimas funcionalidades mencionadas se deben implementar por medio de Listeners.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
class ButtonsPanel extends JPanel {
    private static final double BUTTON_PROPORTIONS = 1.7;

    private JButton start, color, stop;
    private JTextField dimensions, timer;

    /**
     * Constructor que inicializa el panel con la anchura y altura dadas.
     * @param width
     * @param height
     */
    public ButtonsPanel(int width, int height) {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(width, height);
        addElements();
    }

    /**
     * Método invocado por el constructor que inicializa los elementos de la interfaz y los coloca correctamente.
     */
    private void addElements() {
        // Inicializar los elementos de la interfaz
        start = new JButton("START");
        color = new JButton("COLOR");
        stop = new JButton("STOP");
        dimensions = new JTextField("DENSITY");
        timer = new JTextField("TIMER");

        // Establecer el tamaño de dichos elementos
        start.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), start.getHeight()));
        color.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), color.getHeight()));
        stop.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), stop.getHeight()));
        dimensions.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), dimensions.getHeight()));

        // Añadir los elementos al panel
        add(start);
        add(color);
        add(stop);
        add(dimensions);
        add(timer);
    }

    public JButton getStart() {
        return start;
    }

    public JButton getColor() {
        return color;
    }

    public JButton getStop() {
        return stop;
    }

    public JTextField getDimensions() {
        return dimensions;
    }

    public JTextField getTimer() {
        return timer;
    }
}
