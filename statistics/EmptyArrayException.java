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
 * permission of Brayan Rodriguez and Imagine Cube Lab
 *******************************************************/

package statistics;
//Cuando el arreglo de datos es 0, devuelve una excepción
public class EmptyArrayException extends RuntimeException
{
    /**
     * Construct this exception object.
     */
    public EmptyArrayException( )
    {
        super( );
    }
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public EmptyArrayException( String message )
    {
        super( message );
    }
}
