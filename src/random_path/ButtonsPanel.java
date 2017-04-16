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
    private static final double BUTTON_PROPORTIONS = 15;
    private static final int ELEMENT_HEIGHT = 20;
    private static final int N_ELEMENTS = 5; 
    private static final int COLS = 1;
    private static final int GAP = 100;
    private static final int TOP_BOTTOM_MARGIN_PROPORTION = 6;

    private JButton start, color, stop;
    private JTextField dimensions, timer;

    /**
     * Constructor que inicializa el panel con la anchura y altura dadas.
     * @param width
     * @param height
     */
    public ButtonsPanel(int width, int height) {
        setLayout(new GridLayout(N_ELEMENTS, COLS, GAP, GAP));
        setSize(width, height);
        setBorder(BorderFactory.createEmptyBorder(getHeight() / TOP_BOTTOM_MARGIN_PROPORTION, GAP, getHeight() / TOP_BOTTOM_MARGIN_PROPORTION, GAP));
        
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
        
        //System.out.println("Tamaño de botones: " + getWidth() / BUTTON_PROPORTIONS + "x" + ELEMENT_HEIGHT);

        // Establecer el tamaño de dichos elementos
        start.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        color.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        stop.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        dimensions.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        timer.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));

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
