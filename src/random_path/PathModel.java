package random_path;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase es un modelo para representar caminos aleatorios. Guarda un vector de puntos que especifica el camino trazado, el color del trazo y un punto a partir del cual toca dibujar el siguiente trazo.
 * Genera automáticamente los trazos en cuatro direcciones: arriba, abajo, a la derecha y a la izquierda. No comprueba que se haya salido de los límites inferior y derecho.
 * El ArrayList generatedPath acumula constantes que van indicando el camino, siendo estas constantes las que representan cada uno de los movimientos. Así almacena una secuencia con el camino recorrido.
 * @author Óscar Darias Plasencia
 * @since 14-4-2017
 */
public class PathModel {

	/**
	 * Estas constantes determinan los movimientos posibles a realizar. Se trata de un valor entero de 0 a 3.
	 */
    private static final int UP_MOVE = 0;
    private static final int DOWN_MOVE = 1;
    private static final int RIGHT_MOVE = 3;
    private static final int LEFT_MOVE = 2;
    private static final int POSSIBLE_MOVES = 4;

    private Point origin;
    private ArrayList<Integer> generatedPath;
    private Color linesColor;

    /**
     * Constructor por defecto que reserva espacio en memoria para el ArrayList de movimientos.
     * Fija el color a pintar el trazo a negro, por defecto, pero puede modificarse.
     */
    public PathModel() {
        this.generatedPath = new ArrayList<>();
        this.linesColor = Color.BLACK;
    }

    /**
     * Obtención de la coordenada x del origen del trazo.
     * @return
     */
    public double getOriginX() {
        return origin.getX();
    }

    /**
     * Obtención de la coordenada y del origen del trazo.
     * @return
     */
    public double getOriginY() {
        return origin.getY();
    }

    /**
     * Establece el origen del trazo. Es necesario llamar a este método antes de pintar el trazo (véase drawPath).
     * @param origin Objeto Point que va a determinar el origen del trazo.
     */
    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    /**
     * Permite obtener el origen del trazo.
     * @return Objeto Point.
     */
    public Point getOrigin() {
        return origin;
    }

    /**
     * Permite obtener el camino generado.
     * @return ArrayList con el camino generado, formado por símbolos UP_MOVE, DOWN_MOVE, RIGHT_MOVE y LEFT_MOVE (véase las constantes).
     */
    public ArrayList<Integer> getGeneratedPath() {
        return generatedPath;
    }
    
    /**
     * Vacía el vector de movimientos para que el camino pueda empezar desde cero.
     */
    public void reset() {
    	generatedPath.clear();
    }

    /**
     * Añade un nuevo movimiento al trazo.
     * @param movement Número entero que debe coincidir con una constante que represente un movimiento.
     * @throws IndexOutOfBoundsException En el caso de que el movimiento no se reconozca.
     */
    private void addMove(int movement) throws IndexOutOfBoundsException {
        if ((movement < UP_MOVE) || (movement > RIGHT_MOVE))
            throw new IndexOutOfBoundsException("El movimiento especificado no corresponde con ninguno posible.");
        this.generatedPath.add(movement);
    }

    /**
     * Modifica el color con el que se trazan las líneas.
     * @param linesColor
     */
    public void setLinesColor(Color linesColor) {
        this.linesColor = linesColor;
    }

    /**
     * Devuelve el color con el que se trazan las líneas.
     * @return
     */
    public Color getLinesColor() {
        return linesColor;
    }

    /**
     * Lleva a cabo un movimiento aleatorio.
     * Si existe un límite derecho o inferior por el que se puede trazar el recorrido, tratar de forma externa; este método no lo hace.
     * @throws NumberFormatException En caso de que se genere un número no esperado, es decir, fuera del rango entre 0 y 3.
     */
    public void move() throws NumberFormatException, IndexOutOfBoundsException {
        Random randomNumber = new Random();
        switch (randomNumber.nextInt(POSSIBLE_MOVES)) {
            case UP_MOVE:
                addMove(UP_MOVE);
                break;
            case DOWN_MOVE:
                addMove(DOWN_MOVE);
                break;
            case RIGHT_MOVE:
                addMove(LEFT_MOVE);
                break;
            case LEFT_MOVE:
                addMove(RIGHT_MOVE);
                break;
            default:
                throw new NumberFormatException("Se ha generado un número aleatorio inesperado en la generación de un nuevo movimiento.");
        }
    }

    /**
     * Este método dibuja el camino sobre una ventana gráfica.
     * Recorre el ArrayList de movimientos y dibuja una línea hacia una dirección determinada en función del movimiento dado. Desplaza el origen hacia el final del trazo en cada iteración.
     * El proceso termina cuando se ha alcanzado el límite de la cuadrícula (véanse los parámetros) o cuando se ha recorrido todo el vector de movimientos.
     * @param g
     * @param sideDisplacement Número de píxeles de un trazo horizontal.
     * @param heightDisplacement Número de píxeles de un trazo vertical.
     * @param rightLimit Anchura de la cuadrícula.
     * @param bottomLimit Altura de la cuadrícula.
     */
    public void drawPath(Graphics g, int sideDisplacement, int heightDisplacement, int rightLimit, int bottomLimit) throws Exception {
        g.setColor(getLinesColor());
        Point saveOrigin = getOrigin();
        Point nextPoint;
        int iterator = 0;
        while ((getOriginX() >= 0) && (getOriginX() <= rightLimit)
                && (getOriginY() >= 0) && (getOriginY() <= bottomLimit)
                && (iterator < getGeneratedPath().size())) {
            switch (getGeneratedPath().get(iterator)) {
                case UP_MOVE:
                    nextPoint = new Point((int) getOriginX(), (int) (getOriginY() - heightDisplacement));
                    g.drawLine((int) getOriginX(), (int) getOriginY(), (int) nextPoint.getX(), (int) nextPoint.getY());
                    setOrigin(nextPoint);
                    break;
                case DOWN_MOVE:
                    nextPoint = new Point((int) getOriginX(), (int) (getOriginY() + heightDisplacement));
                    g.drawLine((int) getOriginX(), (int) getOriginY(), (int) nextPoint.getX(), (int) nextPoint.getY());
                    setOrigin(nextPoint);
                    break;
                case LEFT_MOVE:
                    nextPoint = new Point((int) (getOriginX() - sideDisplacement), (int) getOriginY());
                    g.drawLine((int) getOriginX(), (int) getOriginY(), (int) nextPoint.getX(), (int) nextPoint.getY());
                    setOrigin(nextPoint);
                    break;
                case RIGHT_MOVE:
                    nextPoint = new Point((int) (getOriginX() + sideDisplacement), (int) getOriginY());
                    g.drawLine((int) getOriginX(), (int) getOriginY(), (int) nextPoint.getX(), (int) nextPoint.getY());
                    setOrigin(nextPoint);
                    break;
                default:
                    throw new Exception("Algo ha ido mal. Movimiento no registrado se encuentra en el vector de movimientos.");
            }
            iterator++;
        }
        setOrigin(saveOrigin);
    }
}
