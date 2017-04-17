package random_path;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase permite instanciar un panel de botones con una serie de controles para manejar parámetros de la generación del camino aleatorio.
 * Tiene un botón de START y STOP para iniciar y detener la generación del camino.
 * Tiene un botón COLOR para modificar aleatoriamente el color del trazo.
 * Tiene un área de texto donde introducir las dimensiones del tablero.
 * Tiene un área de texto donde especificar el temporizador para la generación del camino.
 * Tiene un botón RESET para deshacer el camino hecho y comenzar de nuevo.
 * Estas últimas funcionalidades mencionadas se deben implementar por medio de Listeners.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 60228971586497509L;
	private static final double BUTTON_PROPORTIONS = 15;
    private static final int ELEMENT_HEIGHT = 20;
    private static final int N_ELEMENTS = 7; 
    private static final int COLS = 1;
    private static final int GAP = 50;
    private static final int TOP_BOTTOM_MARGIN_PROPORTION = 6;

    private JButton start, color, stop, reset;
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
        reset = new JButton("RESET");
        dimensions = new JTextField(RandomPathPanel.DEFAULT_DIMENSION + "x" + RandomPathPanel.DEFAULT_DIMENSION);
        timer = new JTextField(Integer.toString(RandomPathView.DEFAULT_DELAY));
        
        // Centrar el texto de los JTextField
        dimensions.setHorizontalAlignment(JTextField.CENTER);
        timer.setHorizontalAlignment(JTextField.CENTER);

        // Establecer el tamaño de dichos elementos
        start.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        color.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        stop.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        reset.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        dimensions.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));
        timer.setPreferredSize(new Dimension((int) (getWidth() / BUTTON_PROPORTIONS), ELEMENT_HEIGHT));

        // Añadir los elementos al panel
        add(start);
        add(color);
        add(stop);
        add(reset);
        add(new JLabel("---------------"));
        
        // Añadir dos subpaneles para los campos de texto
        JPanel dimensionsPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        dimensionsPanel.add(new JLabel("DIMENSIONS:"));
        dimensionsPanel.add(dimensions);
        
        JPanel delayPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        delayPanel.add(new JLabel("DELAY:"));
        delayPanel.add(timer);
        
        add(dimensionsPanel);
        add(delayPanel);
    }

    
    
    /**************************
     *********** GETTERS
     *************************/
    
    public JButton getStart() {
        return start;
    }
    
    public JButton getReset() {
    	return reset;
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
