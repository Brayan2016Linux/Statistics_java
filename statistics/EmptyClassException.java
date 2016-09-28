/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
 * @text como ponderación, media, mediana, moda, recorrido, recorrido
 * @text intercuartílico, percentil, desviación estándar, etc.
 * @text Desarrollado a partir del  27 de setiembre de 2016
 *
 */

/**
 *
 * @author Brayan Rodríguez
 * @version 1.0
 * 
 */

package statistics;
//Cuando el intervalo de clase es 0, devuelve una excepción
public class EmptyClassException extends RuntimeException
{
    /**
     * Construct this exception object.
     */
    public EmptyClassException( )
    {
        super( );
    }
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public EmptyClassException( String message )
    {
        super( message );
    }
}
