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

import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatisticsValues extends StatisticalMeasure {
    
     /**
     *
     * @param value
     * @return format number two decimals
     */
    public Double formatNumber(Double value){ 
        try{
            NumberFormat myformatter = new DecimalFormat("0.000");
            return parseDouble(myformatter.format(value));
        }
        catch(NumberFormatException myException){
            System.err.println("Warning: " + "Empty array or list!");
            return parseDouble("0.0");
        }
    }
    
     /**
     *
     * @param value
     * @return square of the number
     */
    private Double squareNumber(Double value){
        return value * value;
    }
    
    /**
     *
     * @param myValues
     * @return Double[]
     */
    private Double[] listToArray(List<Double> myValues){
        Double[] aux = new Double[myValues.size()];
        int i = 0;
        Iterator myIterator= myValues.iterator();
        
        while(myIterator.hasNext()){
            aux[i] = parseDouble(myIterator.next().toString());
            i++;
        }
        return aux;
    }
    
    /**
     *
     * @param value
     * @return List<Double>
     */
    private List<Double> arrayToList(Double[] myArray){
        List<Double> aux = new ArrayList();
        for(int i = 0; i < myArray.length; i++)
            aux.add(myArray[i]);      
        return aux;
    }
    
    
    public List<Double> orderedValues(List<Double> myValues){
        Double[] aux = listToArray(myValues);
        shellSort(aux);
        List<Double> myOrderedValue = arrayToList(aux);
        return myOrderedValue;   
    }
    
    //Shellsort methods to use with list<Double>
    private static <AnyType extends Comparable<? super AnyType>>
        void shellSort(AnyType[ ] myArray){
               
                for( int gap = myArray.length / 2; gap > 0; gap = gap == 2 ? 1: (int)(gap / 2.2))
                    for(int i = gap; i < myArray.length; i++)
                    {
                        AnyType temporalValue = myArray[i];
                        int j = i;
                        
                        for( ; j>= gap && temporalValue.compareTo(myArray[j - gap])< 0; j -= gap)
                        {
                            myArray[j] = myArray[j - gap];
                        }
                        
                        myArray[j] = temporalValue;
                    }
                        
            }
        
    //Cálculo del percentile interpolación universal
    private double percentileInterpolation(List<Double> aux, double percentileIndex) {
        //Get superior and inferior limits of interval
        int beforePosition = (int) Math.floor(percentileIndex);
        int afterPosition = beforePosition + 1;
        //Linear Interpolation
        double factorSlope = (percentileIndex - beforePosition) / (afterPosition - beforePosition);
        //IntervalRange
        double intervalRange = orderedValues(aux).get(afterPosition - 1) - orderedValues(aux).get(beforePosition - 1);
        double percentile = formatNumber(orderedValues(aux).get(beforePosition - 1) + factorSlope * intervalRange);
        return percentile;
    }
    
    /**
     *
     * @param myValues
     * @param position
     * @return Percentile R6 in m-th position 
     */
    @Override
    public Double PercentileR6(List<Double> myValues, int position){
        double p = (double) position / 100;
        double N = myValues.size();
        double percentileIndex = p * (N + 1);
        double infimus = 1/(N + 1);
        double supremus = N /(N + 1);
        List<Double> aux = myValues;
        
        if (p < infimus)
        {
            return minValue(myValues);
        }
        else
        {
            if (p >= supremus)
            {
                return maxValue(myValues);
            }
            else
            {
                return percentileInterpolation(aux, percentileIndex);
            }
        }
    }
    
    /**
     *
     * @param myValues
     * @param position
     * @return k-th Percentile R-7 Excel type
     */
    @Override
    public Double PercentileR7(List<Double> myValues, int position){
        double p = (double) position / 100;
        double percentileIndex = ((double)myValues.size() - 1)* p + 1;
        List<Double> aux = myValues;
   
        if (p == 1 )
        {
            return maxValue(myValues);
        }
        else
        {
            return percentileInterpolation(aux, percentileIndex);
        }
    }
    
    /**
     *
     * @param myValues
     * @param position
     * @return k-th Percentile R-8 Maple-7 type
     */
    @Override
    public Double PercentileR8(List<Double> myValues, int position){
        double p = (double)position / 100;
        double N = myValues.size();
        double percentileIndex = (N + 1.0/3.0) * p + 1.0/3.0;
        
        double infimus = (2.0/3.0)/(N + 1.0/3.0);
        double supremus = (N - 1.0/3.0) / (N + 1.0/3.0);
        List<Double> aux = myValues;
        
        if (p < infimus)
        {
            return minValue(myValues);
        }
        else
        {
            if (p >= supremus)
            {
                return maxValue(myValues);
            }
            else
            {
                return percentileInterpolation(aux, percentileIndex);
            }
        }
        
    }
    
    /**
     *
     * @param myValues
     * @return arithmetic Mean
     */
    @Override
    public Double arithmeticMean(List<Double> myValues)
    {
        Double sum = sumValuesX(myValues);
        int sampleSize = myValues.size();
        return formatNumber((double) sum / sampleSize);
    }
   
    /**
     *
     * @param myValues
     * @return Sum of all values of array
     */
    @Override
    public Double sumValuesX(List<Double> myValues){
        Double sum = 0.0;
        Iterator myIterator = myValues.iterator();
        while (myIterator.hasNext()){
            sum = sum + Double.parseDouble(myIterator.next().toString());
        }  
        return formatNumber(sum);
    }
    

    /**
     *
     * @param myValues
     * @return Sum of all square values of array
     */
        @Override
    public Double sumSquareValuesX(List<Double> myValues) {
       Double sum = 0.0;
        Iterator myIterator = myValues.iterator();
        while (myIterator.hasNext()){
            sum = sum + squareNumber(Double.parseDouble(myIterator.next().toString()));
        }  
        return formatNumber(sum);
    }
    
    /**
     *
     * @param myValues
     * @param weights
     * @return weighted Mean
     */
    @Override
    public Double weightedMean(List<Double> myValues, List<Double> weights) {
        
        if (weights == null)
            throw new EmptyArrayException("Empty Weights Array");
        
        Double weightedSum = 0.0;
        Double sumOfWeights = 0.0;
        List<Double> WeightedList = new ArrayList();
        
        Iterator myIterator = weights.iterator();
        
        while (myIterator.hasNext())
        {
            sumOfWeights = sumOfWeights + parseDouble(myIterator.next().toString());
        }
        
        for(int i = 0; i < myValues.size(); i++){
                WeightedList.add(myValues.get(i) * weights.get(i));
        }
        
        Iterator myValuesIterator = WeightedList.iterator();
        while (myValuesIterator.hasNext())
        {
            weightedSum = weightedSum + parseDouble(myValuesIterator.next().toString());
        }
        
        return formatNumber(weightedSum / sumOfWeights);
    }

    /**
     *
     * @param myValues
     * @return Minimal value of data
     */
    @Override
    public Double minValue(List<Double> myValues) {
        List<Double> aux = myValues;
        return orderedValues(aux).get(0);
    }

    /**
     *
     * @param myValues
     * @return Maximal value of data
     */
    @Override
    public Double maxValue(List<Double> myValues) {
        List<Double> aux = myValues;
        int lastindex = aux.size() - 1;
        return orderedValues(aux).get(lastindex);
    }

    /**
     *
     * @param myValues
     * @return Quartile 1
     */
    @Override
    public Double firstQuartile(List<Double> myValues) {
        return PercentileR7(myValues, 25);
    }

    /**
     *
     * @param myValues
     * @return Quartile 2
     */
    @Override
    public Double secondQuartile(List<Double> myValues) {
         return PercentileR7(myValues, 50);
    }

    /**
     *
     * @param myValues
     * @return Quartile 3
     */
    @Override
    public Double thirdQuartile(List<Double> myValues) {
       return PercentileR7(myValues, 75);
    }

    /**
     *
     * @param myValues
     * @return Double list with four quartiles
     */
    @Override
    public List<Double> quartile(List<Double> myValues) {
        List<Double> aux = new ArrayList<>();
        aux.add(firstQuartile(myValues));
        aux.add(secondQuartile(myValues));
        aux.add(thirdQuartile(myValues));
        aux.add(maxValue(myValues));
        return aux;
    }

    /**
     *
     * @param myValues
     * @return Range of data
     */
    @Override
    public Double dataRange(List<Double> myValues) {
        return maxValue(myValues) - minValue(myValues);
    }

    @Override
    public Double medianValue(List<Double> myValues) {
        return secondQuartile(myValues);
    }
    
    /**
     *
     * @param myValues
     * @return standard desviation sigma (n)
     */

    @Override
    public Double standardDesviationSigma(List<Double> myValues) {
        return formatNumber(Math.sqrt(varianceValueSigma(myValues)));
    }
    
    /**
     *
     * @param myValues
     * @return normal desviation s (n - 1)
     */
    @Override
    public Double standardDesviationNormal(List<Double> myValues) {
        return formatNumber(Math.sqrt(varianceValueNormal(myValues)));
    }

    /**
     *
     * @param myValues
     * @return variance sigma (n)
     */
    @Override
    public Double varianceValueSigma(List<Double> myValues) {
        return formatNumber(Math.abs(sumSquareValuesX(myValues) / myValues.size() - squareNumber(arithmeticMean(myValues))));
    }
    
    /**
     *
     * @param myValues
     * @return normal variance s (n - 1)
     */
    @Override
    public Double varianceValueNormal(List<Double> myValues) {
        Double varianceValue = varianceValueSigma(myValues);
        double correctionFactor = (double) myValues.size() / (double)(myValues.size() - 1);
        return formatNumber(Math.abs(varianceValue * correctionFactor));
    }
    
    /**
     *
     * @param myValues
     * @return variation coefficient sigma (n)
     */
    @Override
    public Double variationCoefficientSigma(List<Double> myValues) {
        return formatNumber(standardDesviationSigma(myValues) / arithmeticMean(myValues) * 100);
    }
    
    /**
     *
     * @param myValues
     * @return variation coefficient normal (n - 1)
     */
    @Override
    public Double variationCoefficientNormal(List<Double> myValues) {
        return formatNumber(standardDesviationNormal(myValues) / arithmeticMean(myValues) * 100);
    }
    
   
}
