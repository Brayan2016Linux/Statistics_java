/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
 * @text como ponderación, media, mediana, moda, recorrido, recorrido
 * @text intercuartílico, percentil, desviación estándar, etc.
 * @text Desarrollado a partir del  27 de setiembre de 2016
 *
 */

/*******************************************************
 * Copyright (C) 2016-2017 Brayan Rodriguez D. <bradrd2009jp@gmail.com>
 * 
 * This file is part of Java Statistics.
 * 
 * Java Statistics can not be copied and/or distributed without the express
 * permission of Brayan Rodriguez
 *******************************************************/
 //Last Updated: July 22, 2017
 
package exceptions;

/**
 * @title EmptyClassException
 * @text Cuando el intervalo de clase es 0, devuelve una excepción
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/07/22
 */
public class EmptyClassException extends RuntimeException
{
    /**
     * @text Construct this exception object.
     */
    public EmptyClassException( )
    {
        super( );
    }
    /**
     * @author <bradrd2009jp@gmail.com>
     * @text Construct this exception object.
     * @param message the error message.
     * @date 2017/7/22
     */
    public EmptyClassException( String message )
    {
        super( message );
    }
}
