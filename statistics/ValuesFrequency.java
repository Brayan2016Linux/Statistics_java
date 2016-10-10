/**
 * @title Statistical Measure Interface
 * @text Interface de Measures, incluye los elementos básicos de la clase
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
 * permission of Brayan Rodriguez and Imagine Cube Lab
 *******************************************************/

package statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ValuesFrequency implements FrequencyInterface{
    
    private final StatisticsValues myStatistics;
    private final int precisionDecimals;
    private final double asuranceLimitValue;
    private int lastNumberOfRows;
    private int lastNumberOfColumns;
    
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
    
    //devuelve el número de filas de una matriz           
    public <AnyType extends Comparable<? super AnyType>> 
        int numberOfRowsMatrix (AnyType[][] myMatrix) {
            int numberOfRows = 0;
            
            if (myMatrix != null)
            {
                try{
                for (int i = 0; i < myMatrix.length; i++)
                   {
                    if (myMatrix[i][0] != null)
                    {
                        numberOfRows = i + 1;
                        lastNumberOfRows = numberOfRows;
                    }
                    else
                        break;
                   }
                } catch (IndexOutOfBoundsException myException){
                    return lastNumberOfRows;
                }
            }
            return numberOfRows;
    }
        
    //devuelve el número de columnas de una matriz           
    public <AnyType extends Comparable<? super AnyType>> 
        int numberOfColumnsMatrix (AnyType[][] myMatrix) {
            int numberOfColumns = 0;
            
            if (myMatrix != null)
            {
                try{
                for (int j = 0; j < myMatrix.length; j++)
                   {
                    if (myMatrix[0][j] != null)
                        {
                        numberOfColumns = j + 1;
                        lastNumberOfColumns = numberOfColumns;
                    }
                    else
                        break;
                   }
                } catch (IndexOutOfBoundsException myException){
                    return lastNumberOfColumns;
                }
            }
            return numberOfColumns;
    }
    
    
    //Constructor por defecto
    public ValuesFrequency(){
        myStatistics = new StatisticsValues();
        precisionDecimals = 3;
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
        List<Double> myLimitsList = new ArrayList<>();
        
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
     * @return quantitative variable Value
     */
    @Override
    public List<Integer> quantitativeVariableFrequency(List<Double> myValues, int classNumber) {
        List<Integer> myfrequency = new ArrayList();
        
        List<Double> linfC = inferiorLimitClass(myValues, classNumber);
        List<Double> lsupC = superiorLimitClass(myValues, classNumber);
        
        for(int i = 0; i < classNumber; i++)
        {
            double inferiorLimit = linfC.get(i);
            double superiorLimit = lsupC.get(i);
            
            int count = 0;
            
            for (Double myValue : myValues) {
                double comparator = myValue;
                if( comparator >=  inferiorLimit)
                {
                    if(comparator < superiorLimit)
                    {
                        count++;
                    }
                }
            }
            myfrequency.add(count);
            
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
    public Double classRange(List<Double> myValues, int classNumber) 
    {
        String myNumber = myStatistics.formatNumber(dataRange(myValues) / classNumber).toString();
        myNumber = myNumber.substring(0, myNumber.length() - precisionDecimals) + "5";
        return Double.parseDouble(myNumber);    
    }
    
    
    //Devuelve los valores de las categorías de variables cualitativas

    /**
     *
     * @param myValues
     * @return List String of Categories for qualitative variables
     */
    @Override
    public List<String> qualitativeVariableClass(List<String> myValues)
    {
        List<String> myListOfCategories = new ArrayList();
        Iterator<String> myIterator = myValues.iterator();
        boolean canBeAdded = false;
        
        //Obtiene el primer elemento
        myListOfCategories.add(myValues.get(0));
        
        while(myIterator.hasNext()){
            
            String addValue = myIterator.next().toString();
            for(int i= 0; i < myListOfCategories.size(); i++)
            {
                if (!addValue.equals(myListOfCategories.get(i)))
                {
                    canBeAdded = true;
                }
                else
                {
                    canBeAdded = false;
                    break;
                }
            }
            
            if (canBeAdded == true)
                myListOfCategories.add(addValue);
            
        }
        
        return myListOfCategories;
    }
    
    //Devuelve la frecuencia de las variables cualitativas

    /**
     *
     * @param myValues
     * @return Frequency of a qualitative variable
     */
    @Override
    public List<Integer> qualitativeVariableFrequency(List<String> myValues)
    {
        List<Integer> myfrequency = new ArrayList<>();
        List<String> myCategories = qualitativeVariableClass(myValues);
        
        for(int i = 0; i < myCategories.size(); i++)
        {    
            int contador = 0;
            
            for (String myValue : myValues) {
                String comparator = myValue;
                if( comparator == myCategories.get(i))
                {
                        contador++;
                }
            }
            myfrequency.add(contador);
            
        }
        
        return myfrequency;
    }
    
     /**
     *
     * @param firstVariable
     * @param secondVariable
     * @return contingency table values of two qualitative variables sets
     */
    @Override
    public Integer[][] contingencyMatrixFrequency(List<String> firstVariable, List<String> secondVariable){
        
        //Total de observaciones
        int N = firstVariable.size();
        
        //Clasificación
        List<String> RowsClass = qualitativeVariableClass(firstVariable);
        List<String> ColumnsClass = qualitativeVariableClass(secondVariable);
        //Tabla de contingencia
       Integer[][] contingencyMatrix = new Integer[RowsClass.size()][ColumnsClass.size()];
        
        int numberOfRows = RowsClass.size();
        int numberOfColumns = ColumnsClass.size();
        
        //Llenado de la matriz de contingencia
        for( int i = 0; i < numberOfRows; i++)
        {
            for(int j = 0; j < numberOfColumns; j++)
            {
                int count = 0;
                for (int r = 0; r < N; r++)
                {
                    if((firstVariable.get(r) == RowsClass.get(i))&&(secondVariable.get(r)==ColumnsClass.get(j)))
                    {
                        count++;
                    }
                }
                contingencyMatrix[i][j] = count;
   
            }
        }
        
        return contingencyMatrix;
    }
    
    /**
     *
     * @param contingencyMatrix
     * @return sum of rows of contingency table
     */
    @Override
    public List<Integer> sumOfRowsContingencyMatrix(Integer [][] contingencyMatrix){
        List<Integer> sumOfRows = new ArrayList<>();
        int numberofrows = numberOfRowsMatrix(contingencyMatrix);
        int numberofcolumns = numberOfColumnsMatrix(contingencyMatrix);
        
        for (int i = 0; i < numberofrows; i++)
        {
            int suma = 0;
            for (int j = 0; j < numberofcolumns; j++)
            {
                suma = suma + contingencyMatrix[i][j];
            }
            sumOfRows.add(suma);
        }
        
        return sumOfRows;
    }
    
    /**
     *
     * @param contingencyMatrix
     * @return sum of columns contingency Matrix
     */
    
    @Override
    public List<Integer> sumOfColumnsContingencyMatrix(Integer[][] contingencyMatrix)
    {
        List<Integer> sumOfColumns= new ArrayList<>();
        int numberofrows = numberOfRowsMatrix(contingencyMatrix);
        int numberofcolumns = numberOfColumnsMatrix(contingencyMatrix);
        
        for (int j = 0; j < numberofcolumns; j++)
        {
            int suma = 0;
            for (int i = 0; i < numberofrows; i++)
            {
                suma = suma + contingencyMatrix[i][j];
            }
            sumOfColumns.add(suma);
        }
        
        return sumOfColumns;
    }
    
    /**
     *
     * @param firstVariable
     * @param secondVariable
     * @return square chi index contingency Matrix
     */
    @Override
    public Double[][] squareChiIndexContingencyMatrix(List<String> firstVariable, List<String> secondVariable)
    {
        Integer[][] CMatrix = contingencyMatrixFrequency(firstVariable, secondVariable);
        Double[][] squareChiValuesMatrix = new Double [numberOfRowsMatrix(CMatrix)][numberOfColumnsMatrix(CMatrix)];
        List<Integer> SCj = sumOfColumnsContingencyMatrix(CMatrix);
        List<Integer> SFi = sumOfRowsContingencyMatrix(CMatrix);
        
        for (int i = 0; i < numberOfRowsMatrix(CMatrix); i++)
            for (int j = 0; j < numberOfColumnsMatrix(CMatrix); j++)
                squareChiValuesMatrix[i][j] = (double) myStatistics.squareNumber(CMatrix[i][j]) / (SCj.get(j) * SFi.get(i));
        
        return squareChiValuesMatrix;
    }
    
    /**
     *
     * @param ContingencyMatrix
     * @return square chi index contingency Matrix
     */
    public Double[][] squareChiIndexContingencyMatrix(Integer[][] ContingencyMatrix)
    {
        Integer[][] CMatrix = ContingencyMatrix;
        int rows = numberOfRowsMatrix(CMatrix);
        int columns = numberOfColumnsMatrix(CMatrix);
        Double[][] squareChiValuesMatrix = new Double [rows][columns];
        List<Integer> SCj = sumOfColumnsContingencyMatrix(CMatrix);
        List<Integer> SFi = sumOfRowsContingencyMatrix(CMatrix);
        
        for (int j = 0; j < columns; j++)
        {
            for (int i = 0; i < rows; i++)
            {
                double squaredCij = (double) myStatistics.squareNumber(CMatrix[i][j]);
                squareChiValuesMatrix[i][j] =  squaredCij / (SCj.get(j) * SFi.get(i));
            }
        }
        
        return squareChiValuesMatrix;
    }
    
    /**
     *
     * @param firstVariable
     * @param secondVariable
     * @return square chi index contingency Matrix
     */
    @Override
    public Double squareChiIndexContingency(List<String> firstVariable, List<String> secondVariable)
    {
        Double squareChiValue;
        Double sumOfIndexes = 0.0;
        int N = firstVariable.size();
        Double[][] squareChiIndexCM = squareChiIndexContingencyMatrix(firstVariable, secondVariable);
        
        for (int i = 0; i < numberOfRowsMatrix(squareChiIndexCM); i++)
            for (int j = 0; j < numberOfColumnsMatrix(squareChiIndexCM); j++)
            {
                sumOfIndexes = sumOfIndexes + squareChiIndexCM[i][j];
            }
        
        squareChiValue = sumOfIndexes * N - N;
        
        return myStatistics.formatNumber(squareChiValue, precisionDecimals);
    }
    
    public Integer valueOfNContingencyMatrix(Integer[][] contingencyMatrix)
    {
        List<Integer> listSumOfColumns = sumOfColumnsContingencyMatrix(contingencyMatrix);
        int sum = 0;
        
        for (Integer listSumOfColumn : listSumOfColumns) {
            sum += listSumOfColumn;
        }
        
        return sum;
        
    }
    
    /**
     *
     * @param ContingencyMatrix
     * @return square chi index contingency Matrix
     */
    public Double squareChiIndexContingency(Integer[][] ContingencyMatrix)
    {
        Double squareChiValue;
        Double sumOfIndexes = 0.0;
        int N = valueOfNContingencyMatrix(ContingencyMatrix);
        Double[][] squareChiIndexCM = squareChiIndexContingencyMatrix(ContingencyMatrix);
        
        for (int i = 0; i < numberOfRowsMatrix(squareChiIndexCM); i++)
        {
            for (int j = 0; j < numberOfColumnsMatrix(squareChiIndexCM); j++)
            {
                sumOfIndexes = sumOfIndexes + squareChiIndexCM[i][j];
            }
        }
        
        squareChiValue = sumOfIndexes * N - N;
        
        return myStatistics.formatNumber(squareChiValue, precisionDecimals);
    }
    
    
    /**
     *
     * @param firstVariable
     * @param secondVariable
     * @return square chi index contingency Matrix
     */
    @Override
    public Double pearsonCoefficientOfContingency(List<String> firstVariable, List<String> secondVariable)
    {
        Double pearsonValue;
        Double squareChiValue = squareChiIndexContingency(firstVariable, secondVariable);
        int N = valueOfNContingencyMatrix(contingencyMatrixFrequency(firstVariable, secondVariable));
        pearsonValue = squareChiValue / N; 
        
        return myStatistics.formatNumber(pearsonValue, precisionDecimals);
    }
    
    /**
     *
     * @param squareChiValue
     * @return square chi index contingency Matrix
     */
 
    public Double pearsonCoefficientOfContingency(Double squareChiValueIndex, int sumOfAllValueContingencyMatrix)
    {
        Double pearsonValue;
        int N = sumOfAllValueContingencyMatrix;
        pearsonValue = squareChiValueIndex/ N; 
        
        return myStatistics.formatNumber(pearsonValue, precisionDecimals);
    }
    
    /**
     *
     * @param firstVariable
     * @param secondVariable
     * @return square chi index contingency Matrix
     */
    @Override
    public Double chuprovCoefficientOfContingency(List<String> firstVariable, List<String> secondVariable)
    {
        Double PearsonValue = pearsonCoefficientOfContingency(firstVariable, secondVariable);
        int numberOfRows = qualitativeVariableClass(firstVariable).size();
        int numberOfColumns = qualitativeVariableClass(secondVariable).size();
        double chuprovValue = PearsonValue / ((numberOfRows - 1) * (numberOfColumns - 1));
        return myStatistics.formatNumber(chuprovValue, precisionDecimals);
    }
    
    /**
     *
     * @param pearsonValue
     * @param numberOfRows
     * @param numberOfColumns
     * @return square chi index contingency Matrix
     */
    public Double chuprovCoefficientOfContingency(Double pearsonValue, int numberOfRows, int numberOfColumns)
    {
        double chuprovValue = pearsonValue / ((numberOfRows - 1) * (numberOfColumns - 1));
        return myStatistics.formatNumber(chuprovValue, precisionDecimals);
    }
    
    
    /**
     *
     * @param quantitativeV
     * @param qualitativeV
     * @return independenceIndexCorrelation
     */
    @Override
    public Double independenceCorrelationIndex(List<Double> quantitativeV, List<String> qualitativeV){
        Double correlationIndex;
        int N = quantitativeV.size();
        double varianceX = myStatistics.varianceValueSigma(quantitativeV);
        
        List<Double> weightedMeans = new ArrayList<>();
        List<Double> weightList = new ArrayList<>();
        List<String> categoriesList = qualitativeVariableClass(qualitativeV);
        
        //Calculo de las sumadevalores y de los pesos
        for (int i = 0; i < categoriesList.size(); i++)
        {
            int count = 0;
            double sumValues = 0;
            
            for (int j = 0; j < N; j++)
            {
                
                if (qualitativeV.get(j).toString().equals(categoriesList.get(i).toString()))
                {
                    count++;
                    sumValues = sumValues + quantitativeV.get(j);
                }
                
            }
            double pi = (double) count / N;
            weightList.add(pi);
            weightedMeans.add(sumValues / count);
        }
        
        correlationIndex = myStatistics.weightedVariance(weightedMeans, weightList)/varianceX;
        
        return myStatistics.formatNumber(correlationIndex, precisionDecimals);
    }
    
}
