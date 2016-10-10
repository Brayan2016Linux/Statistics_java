/**
 * @title Statistical Measure Interface
 * @text Statistical_Java, incluye los elementos básicos de la clase
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

import java.util.List;

public abstract class StatisticalMeasure {
    
    //Devuelve la media de un grupo de datos
    public abstract Double arithmeticMean(List<Double> myValues);
    
    //Devuelve la media de un grupo de datos
    public abstract Double weightedMean(List<Double> myValues, List<Double> weights);
    
    //Devuelve la suma de todos los valores dentro de un grupo de datos
    public abstract Double sumValuesX(List<Double> myValues);
    
    //Devuelve la suma de todos los valores dentro de un grupo de datos
    public abstract Double sumSquareValuesX(List<Double> myValues);
    
    //Devuelve el valor mínimo de conjunto de datos
    public abstract Double minValue(List<Double> myValues);
    
    //Devuevle el valor máximo de un conjunto de datos
    public abstract Double maxValue(List<Double> myValues);
    
    //Devuelve el valor del percentil m-ésimo
    public abstract Double PercentileR6(List<Double> myValues, int position);
    
    //Devuelve el valor del percentil m-ésimo fórmula R-7
    public abstract Double PercentileR7(List<Double> myValues, int position);
    
    //Devuelve el valor del percentil m-ésimo fórmula R-8
    public abstract Double PercentileR8(List<Double> myValues, int position);
    
    //Devuelve el primer cuartil 25%
    public abstract Double firstQuartile(List<Double> myValues);
    
    //Devuelve el primer cuartil 50%
    public abstract Double secondQuartile(List<Double> myValues);
    
    //Devuelve el primer cuartil 75%
    public abstract Double thirdQuartile(List<Double> myValues);
    
    //Devuelve los cuartiles 0%, 25%, 50%, 75%, 100%
    public abstract List<Double> quartile(List<Double> myValues);
    
    //Devuelve el recorrido de 
    public abstract Double dataRange(List<Double> myValues);
    
    //Devuelve la mediana de un conjunto de datos
    public abstract Double medianValue(List<Double> myValues);
    
    //Devuelve la desviación estándar de un conjunto de datos pi = n
    public abstract Double standardDesviationSigma(List<Double> myValues);
    
    //Devuelve la desviación estándar de un conjunto de datos pi = n-1
    public abstract Double standardDesviationNormal(List<Double> myValues);
    
    //Devuelve la variancia de un conjunto de datos pi = n
    public abstract Double varianceValueSigma(List<Double> myValues);
    
    //Devuelve la variancia de un conjunto de datos pi = n - 1
    public abstract Double varianceValueNormal(List<Double> myValues);
    
    //Devuelve el coeficiente de variación
    public abstract Double variationCoefficientNormal(List<Double> myValues);
    
    //Devuelve el coeficiente de variación
    public abstract Double variationCoefficientSigma(List<Double> myValues);
    
    //Devuelve la variancia calculada con pi
    public abstract Double weightedVariance(List<Double> myValues, List<Double> weights);
    
    
}
