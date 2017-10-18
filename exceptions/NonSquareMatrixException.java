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
 //Last Updated october 10, 2017
 package exceptions;

/**
 * @title NonSquareMatrixException
 * @text Cuando dos matrices lista de diferente , devuelve una excepción
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/10/10
 */
public class NonSquareMatrixException extends RuntimeException
{
    /**
     * @text Construct this exception object.
     */
    public NonSquareMatrixException( )
    {
        super( );
    }
    /**
     * @author <bradrd2009jp@gmail.com>
     * @text Construct this exception object.
     * @param message the error message.
     * @date 2017/10/10
     */
    public NonSquareMatrixException( String message )
    {
        super( message );
    }
}