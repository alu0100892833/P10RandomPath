package random_path;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase permite instanciar paneles sobre el que ir trazando un camino aleatorio. Establece unas dimensiones (cantidad de celdas) y dibuja la cuadrícula.
 * Contiene un modelo del camino generado (generatedPath, objeto PathModel), que pinta en cada llamada a paintComponent.
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
class RandomPathPanel extends JPanel {
	private static final long serialVersionUID = 3214909588162411411L;
	public static final int DEFAULT_DIMENSION = 100;
    private static final int MAX_CENTER_RADIUS = 10;
    private static final int ZERO = 0;

    private PathModel generatedPath;
    private int nRows, nCols;

    /**
     * Constructor con parámetros. Establece el fondo a blanco y las filas y columnas a un valor dado por una constante.
     * @param model Objeto PathModel que se dibujará, modelo del camino aleatorio.
     */
    public RandomPathPanel(PathModel model) {
        setBackground(Color.WHITE);
        
        this.generatedPath = model;
        this.nRows = DEFAULT_DIMENSION;
        this.nCols = DEFAULT_DIMENSION;
    }

    /**
     * Establece el número de filas y el número de columnas de la cuadrícula.
     * @param nRows
     * @param nCols
     */
    public void setDimensions(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
    }

    /**
     * Determina el desplazamiento lateral de cada celda en función de la anchura total y el número de columnas de la cuadrícula.
     * @return Número de píxels de ancho que tiene cada celda.
     */
    public int getSideDisplacement() {
        return getWidth() / nCols;
    }

    /**
     * Determina el desplazamiento vertical de cada celda en función de la anchura total y el número de filas de la cuadrícula.
     * @return Número de píxels de alto que tiene cada celda.
     */
    public int getHeightDisplacement() {
        return getHeight() / nRows;
    }

    /**
     * Este método determina el origen del eje de coordenadas.
     * @return Objeto Point con el origen del eje de coordenadas.
     */
    public Point determineOrigin() {
        int xAbstractCoordinates = nCols / 2;  
        int yAbstractCoordinates = nRows / 2; 
        int xRealCoordinates = ZERO;
        int yRealCoordinates = ZERO;

        for (int i = ZERO; i < xAbstractCoordinates; i++)
            xRealCoordinates += getSideDisplacement();
        for (int j = ZERO; j < yAbstractCoordinates; j++)
            yRealCoordinates += getHeightDisplacement();

        return new Point(xRealCoordinates, yRealCoordinates);
    }

    /**
     * Permite obtener el camino generado.
     * @return Objeto PathModel que representa el camino generado.
     */
    public PathModel getGeneratedPath() {
        return generatedPath;
    }

    /**
     * Reescritura del método paintComponent para dibujar la cuadrícula y el trazo.
     * Establece el origen del camino en el origen de coordenadas.
     * En un bloque try, dibuja: la cuadrícula (véase drawGrid), un punto que señala el origen (véase drawCenter) y el camino generado (véase la clase PathModel).
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        getGeneratedPath().setOrigin(determineOrigin());
        try {
            drawGrid(g);
            drawCenter(g);
            getGeneratedPath().drawPath(g, getSideDisplacement(), getHeightDisplacement(), getWidth(), getHeight());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Este método dibuja la cuadrícula sobre la que se genera el camino.
     * Es invocado desde paintComponent.
     * @param g Objeto Graphics sobre el que se va a dibujar la cuadrícula.
     */
    private void drawGrid(Graphics g) {
    	Color previousColor = g.getColor();
    	g.setColor(Color.LIGHT_GRAY);
        for (int i = getHeightDisplacement(); i < getHeight(); i += getHeightDisplacement())
            g.drawLine(ZERO, i, getWidth(), i);
        for (int j = getSideDisplacement(); j < getWidth(); j += getSideDisplacement())
            g.drawLine(j, ZERO, j, getHeight());
        g.setColor(previousColor);
    }
    
    /**
     * Este método dibuja un pequeño círculo en el origen del eje de coordenadas. Señala el punto de inicio de la generación del camino aleatorio.
     * @param g
     */
    private void drawCenter(Graphics g) {
    	Point center = determineOrigin();
    	int radius = Math.min(getSideDisplacement(), getHeightDisplacement()) / 2;
    	if (radius > MAX_CENTER_RADIUS)
    		radius = MAX_CENTER_RADIUS;
    	int diameter = radius * 2;
    	g.fillOval((int) (center.getX() - radius), (int) (center.getY() - radius), diameter, diameter);
    }
}
