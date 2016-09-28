/**
 * @title Frecuency Interface
 * @text Statistical_Java, incluye los elementos básicos de la clase
 * @text como ponderación, media, mediana, moda, recorrido, recorrido
 * @text intercuartílico, percentil, desviación estándar, etc.
 * @text Desarrollado a partir del  27 de setiembre de 2016
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
}
