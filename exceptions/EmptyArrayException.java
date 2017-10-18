/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
 * @text como ponderación, media, mediana, moda, recorrido, recorrido
 * @text intercuartílico, percentil, desviación estándar, etc.
 * @text Desarrollado a partir del  20 de setiembre de 2016
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
 //Last Updated july 22, 2017
 
package exceptions;

/**
 * @title EmptyArrayException
 * @text Cuando el arreglo de datos es 0, devuelve una excepción
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/07/22
 */
public class EmptyArrayException extends RuntimeException
{
    /**
     * @text Construct this exception object.
     */
    public EmptyArrayException( )
    {
        super( );
    }
    /**
     * @author <bradrd2009jp@gmail.com>
     * @text Construct this exception object.
     * @param message the error message.
     * @date 2017/7/22
     */
    public EmptyArrayException( String message )
    {
        super( message );
    }
}
