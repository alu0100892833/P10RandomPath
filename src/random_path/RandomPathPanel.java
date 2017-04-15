package random_path;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Óscar Darias Plasencia
 * @since 15-4-2017
 */
class RandomPathPanel extends JPanel {
    private static final int DEFAULT_DIMENSION = 100;
    private static final int ZERO = 0;

    private PathModel generatedPath;
    private int nRows, nCols, saveWidth, saveHeight;

    public RandomPathPanel(PathModel model, int width, int height) {
        super();
        setSize(width, height);
        setBackground(Color.WHITE);

        this.saveHeight = height;
        this.saveWidth = width;
        this.generatedPath = model;
        this.nRows = DEFAULT_DIMENSION;
        this.nCols = DEFAULT_DIMENSION;
        getGeneratedPath().setHeightDistance(getHeight() / nRows);
        getGeneratedPath().setSideDistance(getWidth() / nCols);
        getGeneratedPath().setOrigin(determineOrigin());
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

    public int getSideDisplacement() {
        return getWidth() / nCols;
    }

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
        int xRealCoordinates = 0;
        int yRealCoordinates = 0;

        for (int i = ZERO; i < xAbstractCoordinates; i++)
            xRealCoordinates += getSideDisplacement();
        for (int j = ZERO; j < yAbstractCoordinates; j++)
            yRealCoordinates += getHeightDisplacement();

        return new Point(xRealCoordinates, yRealCoordinates);
    }

    public PathModel getGeneratedPath() {
        return generatedPath;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setSize(saveWidth, saveHeight);
        try {
            //drawGrid(g);
            //getGeneratedPath().drawPath(g, getWidth(), getHeight());
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
        for (int i = getHeightDisplacement(); i < getHeight(); i += getHeightDisplacement())
            g.drawLine(ZERO, i, getWidth(), i);
        for (int j = getSideDisplacement(); j < getWidth(); j += getSideDisplacement())
            g.drawLine(j, ZERO, j, getHeight());

    }
}
