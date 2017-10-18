/**
 * @title PearsonCoefficient Interface
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
 * permission of Brayan Rodriguez
 *******************************************************/
 //Last Updated: july 22nd, 2017
package statistics;

import java.util.List;

/**
* @title Class PearsonCoefficientInterface
* @text Prototyping of Pearson's Coefficient
* @author <bradrd2009jp@gmail.com>
* @date 2017/22/17
*/
public interface PearsonCoefficientInterface {
    
    //Devuelve la covarianza entre dos variables Cuantitativas
    public Double covarianceXY(List<Double> valueX, List<Double> valueY);
    
    //Devuelve el coeficiente de pearson entre dos conjuntos de variables cuantitativas
    public Double pearsonSigmaXY(List<Double> valueX, List<Double> valueY);
    
    //Devuelve el coeficiente de pearson entre dos conjuntos de variables cuantitativas
    public Double pearsonNormalXY(List<Double> valueX, List<Double> valueY);
    
    //Devuelve la suma del producto de dos variables cuantitativas
    public Double sumValueXY(List<Double> valueX, List<Double> valueY);
}
