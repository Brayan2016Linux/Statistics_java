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
 
 //Last Updated: Octuber 1, 2017
 package vector;
 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import exceptions.*;

/**
* @title Class Vector
* @text Operations with Vector
* @author <bradrd2009jp@gmail.com>
* @date 2017/10/01
*/
public class Vector
 {
   //Constructor
   public Vector()
   {
   }
 
  /**
   * @title printVector
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param AnyType[]
   * @return String
   */
   
   public <AnyType extends Comparable<? super AnyType>>
   String printVector(AnyType[] myArray)
   {
      String myVector;
      myVector = "[ ";
      for (int i = 0; i < myArray.length - 1; i++) 
      {
         myVector = myVector + String.format("%s, ", myArray[i].toString());
      }
      myVector = myVector + String.format("%s ]", myArray[myArray.length - 1].toString());
      
      return myVector;
   }
   
  /**
   * @title printVector
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType>
   * @return String
   */
   public <AnyType extends Comparable<? super AnyType>>
   String printVector(List<AnyType> myList)
   {
      String myVector;
      myVector = "[ ";
      Iterator myIterator = myList.iterator();
      int i = 0;
      while(myIterator.hasNext())
      {
         if(i < myList.size() - 1)
         {
            myVector = myVector + String.format("%s, ", myIterator.next().toString());
         }
         else
            myVector = myVector + String.format("%s", myIterator.next().toString());
         i++;  
      }
      
      myVector = myVector + " ]";
      
      return myVector;
   }
      

  /**
   * @title toList
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param AnyType[]
   * @return List<AnyType>
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<AnyType> toList(AnyType[] myArray)
   {
      List<AnyType> my_list = new ArrayList<AnyType>();
      
      for(int i = 0; i < myArray.length; i++) 
      {
         my_list.add(myArray[i]);
      }//fin del for
      
      return my_list;
   }
   
  /**
   * @title distance
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return distance
   */
   public <AnyType extends Comparable<? super AnyType>>
   Double distance(List<AnyType> VectorX, List<AnyType> VectorY)
   {
      if (VectorX.size() != VectorY.size())
         throw new DifferentSizeListException();
         
      Double difference;
      Double sum = 0.0;
      
      for(int i = 0; i < VectorX.size(); i++)
      {
         difference = Double.parseDouble(VectorX.get(i).toString()) - Double.parseDouble(VectorY.get(i).toString());
         sum += Math.pow(difference, 2); 
      }      
      
      return Math.sqrt(sum);
   }
   
   
  /**
   * @title dotProduct
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return dotProduct
   */
   public <AnyType extends Comparable<? super AnyType>>
   Double dotProduct(List<AnyType> VectorX, List<AnyType> VectorY)
   {
      if (VectorX.size() != VectorY.size())
         throw new DifferentSizeListException();
         
      Double product = 0.0;
      Double sum = 0.0;
      
      for(int i = 0; i < VectorX.size(); i++)
      {
         product = Double.parseDouble(VectorX.get(i).toString()) * Double.parseDouble(VectorY.get(i).toString());
         sum += product; 
      }      
      
      return sum;
   }
   
  /**
   * @title module
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @return module
   */
   public <AnyType extends Comparable<? super AnyType>>
   Double module(List<AnyType> VectorX)
   {
            
      Double squareModule;
      squareModule = dotProduct(VectorX, VectorX);     
      
      return Math.sqrt(squareModule);
   }

  /**
   * @title crossPoint
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return crossPoint Vector List
   */
  public <AnyType extends Comparable<? super AnyType>>
   List<Double> crossPoint(List<AnyType> VectorX, List<AnyType> VectorY)
   {
      int sizex = VectorX.size();
      int sizey = VectorY.size();
      
      if(sizex != 3 || sizey != 3)
         throw new DifferentSizeListException("Vector must be tridimensional");
         
      if(VectorX.getClass().equals(String.class) || VectorY.getClass().equals(String.class))
         throw new IncompatibleTypeException("Vector must have numerical entries");
         
         
      List<Double> newVector = new ArrayList<Double>();
      Double entry1 = Double.parseDouble(VectorX.get(1).toString()) * Double.parseDouble(VectorY.get(2).toString()) - Double.parseDouble(VectorX.get(2).toString()) * Double.parseDouble(VectorY.get(1).toString());
      Double entry2 = Double.parseDouble(VectorX.get(0).toString()) * Double.parseDouble(VectorY.get(2).toString()) + Double.parseDouble(VectorX.get(2).toString()) * Double.parseDouble(VectorY.get(0).toString());
      Double entry3 = Double.parseDouble(VectorX.get(0).toString()) * Double.parseDouble(VectorY.get(1).toString()) - Double.parseDouble(VectorX.get(1).toString()) * Double.parseDouble(VectorY.get(0).toString());
      
      newVector.add(entry1);
      newVector.add(entry2);
      newVector.add(entry3);      
      
      return newVector;
   }

  /**
   * @title unitaryVector
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @return unitaryVector
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<Double> unitaryVector(List<AnyType> VectorX)
   {
      List<Double> newVector = new ArrayList<Double>();    
      Double Module = module(VectorX);
      Double entry;
      
      for(int i = 0; i < VectorX.size(); i++)
      {
         entry = Double.parseDouble(VectorX.get(i).toString()) / Module;
         newVector.add(entry); 
      }      
      
      return newVector;
   }
   
   
  /**
   * @title angle
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return angle
   */
   public <AnyType extends Comparable<? super AnyType>>
   Double angle(List<AnyType> VectorX, List<AnyType> VectorY)
   {
      if (VectorX.size() != VectorY.size())
         throw new DifferentSizeListException();
         
      Double moduleX = module(VectorX);
      Double moduleY = module(VectorY);
      Double dotProduct  = dotProduct(VectorX, VectorY);    
      
      return (180 / Math.PI) * Math.acos(dotProduct /(moduleX * moduleY));
   }
   
  /**
   * @title reciprocal
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/01
   * @param List<AnyType> VectorX
   * @return reciprocalVector
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<Double> reciprocal(List<AnyType> VectorX)
   {
      List<Double> newVector = new ArrayList<Double>();    
      Double entry;
      
      for(int i = 0; i < VectorX.size(); i++)
      {
         entry = 1/Double.parseDouble(VectorX.get(i).toString());
         newVector.add(entry); 
      }      
      
      return newVector;
   }
   
   
  /**
   * @title scalarVector
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/18
   * @param scalar
   * @param List<AnyType> VectorX
   * @return scalarVector
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<Double> scalarVector(double scalar, List<AnyType> VectorX)
   {
      List<Double> newVector = new ArrayList<Double>();    
      double entry = 0.0;
      
      for(AnyType i : VectorX)
      {
         entry = Double.parseDouble(i.toString()) * scalar;
         newVector.add(entry); 
      }      
      
      return newVector;
   }
   
   
  /**
   * @title vectorAddition
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/18
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return vectorAdition
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<Double> vectorAddition(List<AnyType> VectorX, List<AnyType> VectorY)
   {
   
      if(VectorX.size() != VectorY.size())
         throw new DifferentSizeListException("Size of vectors are different");
         
      List<Double> newVector = new ArrayList<Double>();    
      double entry;
      
      for(int i = 0; i <VectorX.size(); i++)
      {
         entry = 0.0;
         entry = Double.parseDouble(VectorX.get(i).toString()) + Double.parseDouble(VectorY.get(i).toString());
         newVector.add(entry);
      }      
      
      return newVector;
   }
   
   /**
   * @title vectorSubstraction
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/18     
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @return vectorSubstraction
   */
   public <AnyType extends Comparable<? super AnyType>>
   List<Double> vectorSubstraction(List<AnyType> VectorX, List<AnyType> VectorY)
   {
      List<Double> newVector = new ArrayList<Double>();
      List<Double> doubleX = new ArrayList<Double>();
      
      for(AnyType i: VectorX)
      {
         doubleX.add(Double.parseDouble(i.toString()));
      }
      
      newVector = vectorAddition(doubleX, scalarVector(-1, VectorY));    
   
      return newVector;
   }
   
   
   /**
   * @title distanceBetweenWeightedVectors
   * @author <bradrd2009jp@gmail.com>
   * @date 2017/10/18
   * @param List<AnyType> VectorX
   * @param List<AnyType> VectorY
   * @param List<Double> VectorM (Metric matrix Diagonal)
   * @return vectorAdition
   */
   public <AnyType extends Comparable<? super AnyType>>
   Double distanceBetweenVectorsWithMetric(List<AnyType> VectorX, List<AnyType> VectorY, List<Double> VectorM)
   {
   
      if((VectorX.size() != VectorY.size()) && (VectorX.size() != VectorM.size()) )
         throw new DifferentSizeListException("Size of vectors are different");
       
      double squareDistance = 0.0;
      
      for(int i = 0; i <VectorX.size(); i++)
      {
         squareDistance += Math.pow((Double.parseDouble(VectorX.get(i).toString()) - Double.parseDouble(VectorY.get(i).toString())), 2) * VectorM.get(i);
      }      
      
      return Math.sqrt(squareDistance);
   }



}
