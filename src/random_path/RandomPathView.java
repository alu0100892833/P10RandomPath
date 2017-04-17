package random_path;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Clase vista para la representación y progresivo trazo de un camino aleatorio junto a una serie de controles.
 * Instancia dos paneles de las clases RandomPathPanel y ButtonsPanel, y los coloca convenientemente en una ventana.
 * También almacena como atributo un objeto Timer que lanza eventos cada cierto tiempo para ir trazando el camino aleatorio.
 * Los listeners están implementados en esta clase: se le otorga la funcionalidad a los elementos de un objeto ButtonsPanel y los hace interactuar con un objeto RandomPathPanel.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
public class RandomPathView extends JFrame {
	private static final long serialVersionUID = 8451166959105060125L;
	private static final Color[] STROKE_COLORS = {Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN};
	public static final int DEFAULT_DELAY = 400;

    private RandomPathPanel pathPanel;
    private ButtonsPanel controls;
    private Timer drawingTimer;

    
    /**************************
     *********** GETTERS
     *************************/
    
    public RandomPathPanel getPathPanel() {
        return pathPanel;
    }

    public ButtonsPanel getControls() {
        return controls;
    }

	public Timer getDrawingTimer() {
		return drawingTimer;
	}

	
	/**
	 * Constructor de objetos de la clase, que establece un BorderLayout y otros parámetros básicos de los objetos JFrame.
	 * La ventana se muestra ocupando la totalidad del escritorio.
	 * @param model
	 */
	public RandomPathView(PathModel model) {
        setLayout(new BorderLayout());
        setTitle("CAMINO ALEATORIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
                
        pathPanel = new RandomPathPanel(model);
        add(pathPanel, BorderLayout.CENTER);
        
        // Establecemos el tamaño de la ventana igual al tamaño del monitor.
        Dimension fullScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(fullScreen);
        
        controls = new ButtonsPanel(getWidth(), getHeight());
        add(controls, BorderLayout.EAST);
        
        setListeners();
        //setVisible(true);
    }
	
	/**
	 * Este método instancia un objeto de la clase ControlsListener y lo añade a los listeners de cada uno de los elementos de la interfaz.
	 */
	private void setListeners() {
		ControlsListener listener = new ControlsListener();
        drawingTimer = new Timer(DEFAULT_DELAY, listener);
        controls.getStart().addActionListener(listener);
        controls.getStop().addActionListener(listener);
        controls.getColor().addActionListener(listener);
        controls.getDimensions().addActionListener(listener);
        controls.getTimer().addActionListener(listener);
        controls.getReset().addActionListener(listener);
	}
    
	/**
	 * Clase listener para los elementos de la interfaz y el temporizador que intervienen en el programa.
	 * Determina la rutina a llevar a cabo en función de la fuente que desencadene la acción. 
	 * Única clase Listener de todo el programa; trata todas las acciones posibles sobre la interfaz.
	 */
    class ControlsListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		if (e.getSource() == controls.getStart())
    			getDrawingTimer().start();
    		else if (e.getSource() == controls.getStop())
    			getDrawingTimer().stop();
    		else if (e.getSource() == controls.getColor())
    			getPathPanel().getGeneratedPath().setLinesColor(getRandomColor());
    		else if (e.getSource() == controls.getDimensions()) {
    			setNewDimensions(controls.getDimensions().getText());
    		} else if (e.getSource() == controls.getTimer()) {
    			setNewTimer(controls.getTimer().getText());
    		} else if (e.getSource() == getDrawingTimer()) {
    			getPathPanel().getGeneratedPath().move();
    			getPathPanel().revalidate();
    			getPathPanel().repaint();
    		} else if (e.getSource() == controls.getReset()) {
    			getPathPanel().getGeneratedPath().reset();
    			getPathPanel().revalidate();
    			getPathPanel().repaint();
    		}
    	}
    }
    
    /**
     * Este método elige un color aleatorio y lo devuelve.
     * Si el color generado es el mismo con el que ya se estaba dibujando el trazo, hace una llamada recursiva. Esta recursividad continúa hasta obtener un color diferente.
     * Utiliza el vector estático constante STROKE_COLORS.
     * @return Color aleatorio.
     */
    private Color getRandomColor() {
    	Random random = new Random();
    	Color newColor = STROKE_COLORS[random.nextInt(STROKE_COLORS.length)];
    	if (newColor == getPathPanel().getGeneratedPath().getLinesColor())
    		return getRandomColor();
    	return newColor;
    }
    
    /**
     * Este método modifica las dimensiones del tablero sobre el que se genera el camino aleatorio.
     * @param newDimensions Nuevas dimensiones en un objeto String.
     */
    private void setNewDimensions(String newDimensions) {
    	String[] splittedDimensions = newDimensions.split("x");
    	int rows, cols;
    	if (splittedDimensions.length == 2) {
    		try {
    			rows = Integer.parseInt(splittedDimensions[0]);
    			cols = Integer.parseInt(splittedDimensions[1]);
    			getPathPanel().setDimensions(rows, cols);
    		} catch (NumberFormatException e) {
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * Este método modifica el temporizador que rige cada cuánto tiempo se realiza un movimiento en el camino.
     * @param newTimer Nuevo temporizador en un objeto String.
     */
    private void setNewTimer(String newTimer) {
    	try {
    		int timer = Integer.parseInt(newTimer);
    		getDrawingTimer().setDelay(timer);
    	} catch (NumberFormatException e) {
			e.printStackTrace();
		}
    }
}















//END