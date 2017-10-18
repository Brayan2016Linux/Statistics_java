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
 * permission of Brayan Rodriguez
 *******************************************************/
 
//Last Updated: Octuber 17, 2017
package matrix;
 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.reflect.Array;
import exceptions.*;
import vector.*;

/**
 * @title Class Matrix
 * @text Operations with Matrix
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/10/17
 */ 
public class Matrix
{

   private int lastNumberOfRows;
   private int lastNumberOfColumns;
   
   //Constructor
   public Matrix()
   {
   }
   
   
  /**
   * @title numberOfRowsMatrix
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * @return number of rows
   */         
    public <AnyType extends Comparable<? super AnyType>> 
        int numberOfRowsMatrix (AnyType[][] myMatrix) {
            return myMatrix.length;
    }
        
  /**
   * @title numberOfColumnsMatrix 
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * @return number of columns
   */         
    public <AnyType extends Comparable<? super AnyType>> 
        int numberOfColumnsMatrix (AnyType[][] myMatrix) {
            return myMatrix[0].length;
    }
    
    
    
  /**
   * @title printMatrix 
   * @author <bradrd2009jp@gmail.com>
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * @return printMatrix
   */         
    public <AnyType extends Comparable<? super AnyType>> 
    String printMatrix (AnyType[][] myMatrix)
    {
        List<List<String>> rows = new ArrayList<List<String>>();
        
        for(int i = 0; i < myMatrix.length; i++)
        {   
            rows.add(new ArrayList<String>());
            for (int j = 0; j < myMatrix[0].length; j++)
            {
               rows.get(i).add(myMatrix[i][j].toString());
            }
        }
        
        //Conversión a String
        String matrix = "\n[\n";
        
        for(List<String> columns : rows)
        {
            matrix = matrix + "[ ";
            Iterator<String> columnsIter = columns.iterator();
            while(columnsIter.hasNext())
            {
               matrix = matrix + columnsIter.next().toString() + " ";
            }
            matrix = matrix + "]";
        }
         
        matrix = matrix + "\n]\n";       
        return matrix;
    }


   
  /**
   * @title matrixToObject
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * return newMatrix
   */
   public <AnyType extends Comparable<? super AnyType>> 
   Object[][] matrixToObject (AnyType[][] myMatrix)
   {
      int rows = myMatrix.length;
      int columns = myMatrix[0].length;
      Object[][] newMatrix = new Object[rows][columns];
      AnyType newEntry;
      
      for(int i = 0; i < rows; i++)
      {
           for(int j = 0; j < columns; j++)
           {
               newEntry = myMatrix[i][j];
               newMatrix[i][j] = newEntry;
           }
       }
       return newMatrix;  
   }
   
    
  /**
   * @title transpose 
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * return transpose Matrix
   */         
    public Object[][] transpose(Object[][] myMatrix)
    {
        int rows = myMatrix[0].length;
        int columns = myMatrix.length;
        Object[][] newMatrix = new Object[rows][columns];
        Object newEntry;
        
        for(int i = 0; i < columns; i++)
        {
           for(int j = 0; j < rows; j++)
           {
               newEntry = myMatrix[i][j];
               newMatrix[j][i] = newEntry;
           }
        }
        return newMatrix;
    }
    
    
  /**
   * @title objectToInt 
   * @author <bradrd2009jp@gmail.com>
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * return int Matrix
   */  
   
   public Integer[][] objectToInt (Object[][] myMatrix)
    {
        int rows = myMatrix.length;
        int columns = myMatrix[0].length;
        
        Integer[][] newMatrix = new Integer[rows][columns];
        
        for(int i = 0; i < rows; i++)
        {
           for(int j = 0; j < columns; j++)
           {
               newMatrix[i][j] = Integer.parseInt(myMatrix[i][j].toString());
           }
        }

        return newMatrix;
    }
    
    
  /**
   * @title objectToDouble 
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/17
   * @param myMatrix
   * return double Matrix
   */  
   
   public Double[][] objectToDouble (Object[][] myMatrix)
    {
        int rows = myMatrix.length;
        int columns = myMatrix[0].length;
        Double[][] newMatrix = new Double[rows][columns];
        
        for(int i = 0; i < rows; i++)
        {
           for(int j = 0; j < columns; j++)
           {
               newMatrix[i][j] = (double) myMatrix[i][j];
           }
        }

        return newMatrix;
    }
    
   /**
    * @title sumOfMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param matrixA
    * @param matrixB
    * return sumMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] sumOfMatrix (AnyType[][] myMatrixA, AnyType[][] myMatrixB)
    {
       if((myMatrixA.length != myMatrixB.length)||(myMatrixA[0].length != myMatrixB[0].length))
            throw new DifferentSizeMatrixException();
            
       Double[][] matrix = new Double[myMatrixA.length][myMatrixA[0].length];
       
       for(int i = 0; i < myMatrixA.length; i++)
       {
           for(int j = 0; j < myMatrixA[0].length; j++)
           {
               matrix[i][j] = Double.parseDouble(myMatrixA[i][j].toString()) + Double.parseDouble(myMatrixB[i][j].toString());
           }
       }
       
       return matrix;
    }
    
  /**
    * @title substractionOfMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param matrixA
    * @param matrixB
    * @return substractionMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] substractionOfMatrix (AnyType[][] myMatrixA, AnyType[][] myMatrixB)
    {
       if((myMatrixA.length != myMatrixB.length)||(myMatrixA[0].length != myMatrixB[0].length))
            throw new DifferentSizeMatrixException();
            
       Double[][] matrix = new Double[myMatrixA.length][myMatrixA[0].length];
       
       for(int i = 0; i < myMatrixA.length; i++)
       {
           for(int j = 0; j < myMatrixA[0].length; j++)
           {
               matrix[i][j] = Double.parseDouble(myMatrixA[i][j].toString()) - Double.parseDouble(myMatrixB[i][j].toString());
           }
       }
       
       return matrix;
    }

    
  /**
    * @title scalarMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param scalar
    * @param matrixA
    * @return sumMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] scalarMatrix (double scalar, AnyType[][] myMatrixA)
    {
            
       Double[][] matrix = new Double[myMatrixA.length][myMatrixA[0].length];
       
       for(int i = 0; i < myMatrixA.length; i++)
       {
           for(int j = 0; j < myMatrixA[0].length; j++)
           {
               matrix[i][j] = Double.parseDouble(myMatrixA[i][j].toString()) * scalar;
           }
       }
       
       return matrix;
    }

  /**
    * @title productOfMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param matrixA
    * @param matrixB
    * @return sumMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] productOfMatrix (AnyType[][] myMatrixA, AnyType[][] myMatrixB)
    {
       Vector myVector = new Vector();
       
       if(myMatrixA[0].length != myMatrixB.length)
            throw new DifferentSizeMatrixException();
            
       Double[][] matrix = new Double[myMatrixA.length][myMatrixB[0].length];
       
       for(int i = 0; i < matrix.length; i++)
       {
           for(int j = 0; j < matrix[0].length; j++)
           {
               matrix[i][j] = myVector.dotProduct(getRowVector(myMatrixA, i), getColumnVector(myMatrixB, j));
           }
       }
       
       return matrix;
    }
    
  /**
    * @title diagonalMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param diagonalVector
    * @return diagonalMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] diagonalMatrix (List<AnyType> diagonalVector)
    {
    
       int size = diagonalVector.size();   
       Double[][] matrix = new Double[size][size];
       
       for(int i = 0; i < size; i++)
       {
           for(int j = 0; j < size; j++)
           {
               if (i != j)
               {
                  matrix[i][j] = 0.0;
               }
               else
               {
                  matrix[i][j] = Double.parseDouble(diagonalVector.get(i).toString());
               }
           }
       }
       
       return matrix;
    }
    
  /**
    * @title identityMatrix 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param int
    * @return identityMatrix
    */
    public <AnyType extends Comparable<? super AnyType>>
    Double[][] identityMatrix (int size)
    {
       
       Double[][] matrix = new Double[size][size];
       
       for(int i = 0; i < size; i++)
       {
           for(int j = 0; j < size; j++)
           {
               if (i != j)
               {
                  matrix[i][j] = 0.0;
               }
               else
               {
                  matrix[i][j] = 1.0;
               }
           }
       }
       
       return matrix;
    }

    
  /**
    * @title getColumnVector
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param myMatrixA
    * @param int position
    * @return List<AnyType> columnVector
    */
    public <AnyType extends Comparable<? super AnyType>>
    List<AnyType> getColumnVector(AnyType [][] myMatrix, int position)
    {
         List<AnyType> columnVector = new ArrayList<AnyType>();
         
         for(int i= 0; i< myMatrix.length; i++)
         {
            columnVector.add(myMatrix[i][position]);
         }
         
         return columnVector;
    }
    
  /**
    * @title getRowVector 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param myMatrixA
    * @int position
    * @return List<AnyType> rowVector
    */
    public <AnyType extends Comparable<? super AnyType>>
    List<AnyType> getRowVector(AnyType [][] myMatrix, int position)
    {
         List<AnyType> rowVector = new ArrayList<AnyType>();
         
         for(int i = 0; i< myMatrix[0].length; i++)
         {
            rowVector.add(myMatrix[position][i]);
         }
         
         return rowVector;
    }
    
  /**
    * @title getDiagonalVector
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param myMatrix
    * @return List<AnyType> diagonalVector
    */         
    public <AnyType extends Comparable<? super AnyType>> 
    List<AnyType> getDiagonalVector (AnyType[][] myMatrix) {
       List<AnyType> diagonal = new ArrayList<AnyType>();
       
       if(myMatrix.length != myMatrix[0].length)
            throw new NonSquareMatrixException("Error Matrix is not square");
         
       for(int i = 0; i < myMatrix.length; i++)
       {
           for(int j = 0; j < myMatrix[0].length; j++)
           {
              if(i == j)
              {
                 diagonal.add(myMatrix[i][j]);
              }        
           }
       }
  
       return diagonal;
    }
    
    
  /**
    * @title getTrace 
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/17
    * @param myMatrix
    * @return Double trace
    */         
    public <AnyType extends Comparable<? super AnyType>> 
    Double getTrace (AnyType[][] myMatrix) {
       
       if(myMatrix.length != myMatrix[0].length)
            throw new NonSquareMatrixException("Error Matrix is not square");
                    
       List<AnyType> diagonal = getDiagonalVector(myMatrix);
       double trace = 0.0;
         
       for(AnyType i: diagonal)
       {
           trace += Double.parseDouble(i.toString());           
       }
  
       return trace;
    }

  /**
    * @title getDistanceBetweenRows
    * @author <bradrd2009jp@gmail.com>
    * @date 2017/10/18
    * @param myMatrix
    * @param List of Metrics
    * @param position_i
    * @param position_j
    * return Double distanceBetweenRows
    */         
    public <AnyType extends Comparable<? super AnyType>> 
    Double getDistanceBetweenRows (AnyType[][] myMatrix, List<Double> metricDiagonal, int position_i, int position_j) {
       
       if(myMatrix.length == 0)
            throw new EmptyArrayException("Table of Data are empty");
            
       if(myMatrix[0].length != metricDiagonal.size())
         throw new DifferentSizeListException("Weights vector must have same size as rows"); 
         
       Vector myVect = new Vector();
                    
       List<AnyType> i_RowVector = getRowVector(myMatrix, position_i);
       List<AnyType> j_RowVector = getRowVector(myMatrix, position_j);
         
       return myVect.distanceBetweenVectorsWithMetric(i_RowVector, j_RowVector, metricDiagonal);
    }

    

}