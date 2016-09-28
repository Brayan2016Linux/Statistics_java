/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
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

import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ValuesFrequency implements FrequencyInterface{
    
    private final StatisticsValues myStatistics;
    private final int precisionDecimals;
    private final double asuranceLimitValue;
    
    //Inner functions
    private Double XminValue(List<Double> myValues) {
        return myStatistics.minValue(myValues);
    }
    
    private Double XmaxValue(List<Double> myValues) {
        return myStatistics.maxValue(myValues);
    }
    
    private Double dataRange(List<Double> myValues) {
        return myStatistics.dataRange(myValues);
    }
    
    //Devuelve el número total de elementos
    public int totalNumberOfValues(List<Double> myValues){
        return myValues.size();
    }
    
    
    //Constructor por defecto
    public ValuesFrequency(){
        myStatistics = new StatisticsValues();
        precisionDecimals = 2;
        asuranceLimitValue = 5 * Math.pow(10, - (precisionDecimals+1));
    }
    
    //Constructor con precisión
    public ValuesFrequency(int precision){
        myStatistics = new StatisticsValues();
        precisionDecimals = precision;
        asuranceLimitValue = 5 * Math.pow(10, - (precisionDecimals+1));
    }
    /**
     *
     * @param myValues
     * @param classNumber
     * @return inferior Limit Class Values according to classNumbers
     */
    @Override
    public List<Double> inferiorLimitClass(List<Double> myValues, int classNumber) {
        double firstValue = XminValue(myValues);
        double classRange = myStatistics.formatNumber(classRange(myValues, classNumber));
        double addValue = firstValue - asuranceLimitValue;
        
        //Add the first value to list
        List<Double> myLimitsList = new ArrayList();
        
        for(int i = 0; i < classNumber; i++)
        {
            myLimitsList.add(myStatistics.formatNumber(addValue));
            addValue += classRange;
        }
        
        return myLimitsList;
    }

    /**
     *
     * @param myValues
     * @param classNumber
     * @return superior Limit Class Values according to classNumbers
     */
    @Override
    public List<Double> superiorLimitClass(List<Double> myValues, int classNumber) {
        double firstValue = XminValue(myValues);
        double classRange = myStatistics.formatNumber(classRange(myValues, classNumber));
        double addValue = firstValue + classRange - asuranceLimitValue;
        
        //Add the first value to list
        List<Double> myLimitsList = new ArrayList();
        
        for(int i = 0; i < classNumber; i++)
        {
            myLimitsList.add(myStatistics.formatNumber(addValue));
            addValue += classRange;
        }
        
        return myLimitsList;
    }

    /**
     *
     * @param myValues
     * @param classNumber
     * @return cuantitative variable Value
     */
    @Override
    public List<Integer> cuantitativeVariableFrequency(List<Double> myValues, int classNumber) {
        List<Integer> myfrequency = new ArrayList();
        
        List<Double> linfC = inferiorLimitClass(myValues, classNumber);
        List<Double> lsupC = superiorLimitClass(myValues, classNumber);
        
        for(int i = 0; i < classNumber; i++)
        {
            double inferiorLimit = linfC.get(i);
            double superiorLimit = lsupC.get(i);
            
            int contador = 0;
            
            for (Double myValue : myValues) {
                double comparator = myValue;
                if( comparator >=  inferiorLimit)
                {
                    if(comparator < superiorLimit)
                    {
                        contador++;
                    }
                }
            }
            myfrequency.add(contador);
            
        }
        
        return myfrequency;
    }

    /**
     *
     * @param myValues
     * @param classNumber
     * @return class Range
     */
    @Override
    public Double classRange(List<Double> myValues, int classNumber) {
        String myNumber = myStatistics.formatNumber(dataRange(myValues) / classNumber).toString();
        myNumber = myNumber.substring(0, myNumber.length() - precisionDecimals) + "5";
        return Double.parseDouble(myNumber);    
    }
    
    
}
