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
 //Last Updated july 26, 2017
 package exceptions;

/**
 * @title DifferentSizeListException
 * @text Devuelve excepción si las listas son de diferente tamaño
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/07/26
 */ 
public class DifferentSizeListException extends RuntimeException
{
    /**
     * @text Construct this exception object.
     */
    public DifferentSizeListException( )
    {
        super( );
    }
    /**
     * @author <bradrd2009jp@gmail.com>
     * @text Construct this exception object.
     * @param message the error message.
     * @date 2017/7/26
     */
    public DifferentSizeListException( String message )
    {
        super( message );
    }
}
