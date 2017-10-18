/**
 * @title Statistical Measure
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
 //Last Updated Octuber 1, 2017
 package exceptions;

/**
 * @title IncompatibleTypeException
 * @text Cuando dos vectores lista de diferente , devuelve una excepción
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/07/26
 */
public class IncompatibleTypeException extends RuntimeException
{
    /**
     * Construct this exception object.
     */
    public IncompatibleTypeException( )
    {
        super( );
    }
    /**
     * @author <bradrd2009jp@gmail.com>
     * @text Construct this exception object.
     * @param message the error message.
     * @date 2017/10/01
     */
    public IncompatibleTypeException( String message )
    {
        super( message );
    }
}
