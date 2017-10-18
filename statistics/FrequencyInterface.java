/**
 * @title Frecuency Interface
 * @text Statistical_Java, incluye los elementos básicos de la clase
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
package statistics;

import java.util.List;

/**
 * @title FrequencyInterface
 * @text Define las funciones de Frecuencia
 * @author <bradrd2009jp@gmail.com>
 * @date 2016/09/27
 */
public interface FrequencyInterface {
    //Devuelve los valores de los limites inferiores de una clase
    public abstract List<Double> inferiorLimitClass(List<Double> myValues, int classNumber);
    
    //Devuelve los valores de los limites superiores de una clase
    public abstract List<Double> superiorLimitClass(List<Double> myValues, int classNumber);
    
    //Devuelve los valores de la frecuencia de una variable cuantitativa
    public abstract List<Integer> quantitativeVariableFrequency(List<Double> myValues, int classNumber);
    
    //Devuelve los valores de los limites superiores de una clase
    public abstract Double classRange(List<Double> myValues, int classNumber);
    
    //Devuelve los valores de las categorías de variables cualitativas
    public abstract List<String> qualitativeVariableClass(List<String> myValues);
    
    //Devuelve la frecuencia de las variables cualitativas
    public abstract List<Integer> qualitativeVariableFrequency(List<String> myValues);
    
    //Devuelve la matriz de contingencia
    public abstract Integer[][] contingencyMatrixFrequency(List<String> firstVariable, List<String> secondVariable);
    
    //Devuelve los totales de las suma de las filas
    public abstract List<Integer> sumOfRowsContingencyMatrix(Integer[][] contingencyMatrix);
    
    //Devuelve los totales de las suma de las columnas
    public abstract List<Integer> sumOfColumnsContingencyMatrix(Integer[][] contingencyMatrix);
    
    //Devuelve la tabla chi-cuadrado de una tabla de contingencia
    public abstract Double[][] squareChiIndexContingencyMatrix(List<String> firstVariable, List<String> secondVariable);
    
    //Devuelve el índice chi-cuadrado de una tabla de contingencia
    public abstract Double squareChiIndexContingency(List<String> firstVariable, List<String> secondVariable);
    
    //Devuelve el coeficiente de Pearson de una tabla de contingencia
    public abstract Double pearsonCoefficientOfContingency(List<String> firstVariable, List<String> secondVariable);
    
    //Devuelve el coeficiente de Chuprov de una tabla de contingencia
    public abstract Double chuprovCoefficientOfContingency(List<String> firstVariable, List<String> secondVariable);
    
    //Devuelve el coeficiente de asociación entre variable cualitativa y cuantitativa
    public abstract Double independenceCorrelationIndex(List<Double> quantitativeV, List<String> qualitativeV);
}
