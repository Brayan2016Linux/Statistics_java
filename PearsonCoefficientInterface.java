/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
 * @text como ponderación, media, mediana, moda, recorrido, recorrido
 * @text intercuartílico, percentil, desviación estándar, etc.
 * @text Desarrollado a partir del  20 de setiembre de 2016
 *
 */

/**
 *
 * @author Brayan Rodríguez
 * @version 1.0
 * 
 */

package statistics;

import java.util.List;


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
