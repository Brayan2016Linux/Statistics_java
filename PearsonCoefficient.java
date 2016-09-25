/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author bradrd
 */
public class PearsonCoefficient implements PearsonCoefficientInterface {
    
    private final StatisticsValues statisticsValues;
    
    //Constructor
    public PearsonCoefficient(){
        statisticsValues = new StatisticsValues();
    }
    
    private Double formatNumber(double value) 
    {
        return statisticsValues.formatNumber(value);
    }
    
    private Double standardDesviationSigma(List<Double> myValues)
    {
        return statisticsValues.standardDesviationSigma(myValues);
    }
    
    private Double standardDesviationNormal(List<Double> myValues)
    {
        return statisticsValues.standardDesviationNormal(myValues);
    }
    
    private Double arithmeticMean(List<Double> myValues)
    {
        return statisticsValues.arithmeticMean(myValues);
    }
    /**
     *
     * @param valueX
     * @param valueY
     * @return covariance Value of XY
     */
    @Override
    public Double covarianceXY(List<Double> valueX, List<Double> valueY){
        double covXY = sumValueXY(valueX, valueY) / valueX.size() - arithmeticMean(valueX) * arithmeticMean(valueY);
        return formatNumber(covXY);
    }   
    
     /**
     *
     * @param valueX
     * @param valueY
     * @return Pearson coefficient of XY with standard desviation sigma (n)
     */
    @Override
    public Double pearsonSigmaXY(List<Double> valueX, List<Double> valueY){
        double covXY = covarianceXY(valueX, valueY);
        double sigmaStdDesvX = standardDesviationSigma(valueX);
        double sigmaStdDesvY = standardDesviationSigma(valueY);
        
        return formatNumber(covXY / (sigmaStdDesvX * sigmaStdDesvY));
    }
    
    /**
     *
     * @param valueX
     * @param valueY
     * @return Pearson coefficient of XY with standard deviation normal (n-1)
     */
    @Override
    public Double pearsonNormalXY(List<Double> valueX, List<Double> valueY){
        double covXY = covarianceXY(valueX, valueY);
        double normalStdDesvX = standardDesviationNormal(valueX);
        double normalStdDesvY = standardDesviationNormal(valueY);
        
        return formatNumber(covXY / (normalStdDesvX * normalStdDesvY));
    }
    
    /**
     *
     * @param valueX
     * @param valueY
     * @return Value of Sum of product of XY
     */
    @Override
    public Double sumValueXY(List<Double> valueX, List<Double> valueY){
        Double SumValueXY = 0.0;
        
        List<Double> ListProductXY = new ArrayList();
        
        for(int i = 0; i < valueX.size(); i++){
                ListProductXY.add(valueX.get(i) * valueY.get(i));
        }
        
        Iterator myIterator = ListProductXY.iterator();
        while (myIterator.hasNext())
        {
            SumValueXY = SumValueXY + parseDouble(myIterator.next().toString());
        }
        
        return formatNumber(SumValueXY);
    }
}
