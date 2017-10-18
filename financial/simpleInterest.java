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
 
 //Last Updated: Octuber 10, 2017
 package financial;
 
 /**
 * @title Class simpleInterest
 * @text Operations with Simple Interest Rate
 * @author <bradrd2009jp@gmail.com>
 * @date 2017/10/10
 */
 public class simpleInterest
 {
      //Constructor
      public simpleInterest()
      {
      }
      
     /**
      * @title interestValue
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param PV
      * @param period
      * @param rate
      * @return interest 
      */    
      public double interestValue(double PV, int period, double rate)
      {
         return PV * rate * period;
      }
      
     /**
      * @title discount
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param FV
      * @param period
      * @param rate
      * @return discount 
      */    
      public double discount(double FV, int period, double rate)
      {
         return interestValue(FV, period, rate);
      }
      
     /**
      * @title futureValue
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param PV
      * @param period
      * @param rate
      * @return future value 
      */    
      public double futureValue(double PV, int period, double rate)
      {
         return PV + interestValue(PV, period, rate);
      }
      
     /**
      * @title discountedValue
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param FV
      * @param period
      * @param rate
      * @return discounted value 
      */    
      public double discountedValue(double FV, int period, double rate)
      {
         return FV - discount(FV, period, rate);
      }
      
     /**
      * @title presentValue
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param FV
      * @param period
      * @param rate
      * @return present value 
      */    
      public double presentValue(double FV, int period, double rate)
      {
         return FV / (1 + rate * period);
      }
      
     /**
      * @title rationalDiscountValue
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param FV
      * @param period
      * @param rate
      * @return present value 
      */    
      public double rationalDiscountValue(double FV, int period, double rate)
      {
         return FV - presentValue(FV, period, rate);
      }
      
     /**
      * @title interestRate
      * @author <bradrd2009jp@gmail.com>
      * @date 2017/10/10
      * @param PV
      * @param FV
      * @param period
      * @return interest rate 
      */    
      public double interestRate(double PV, double FV, int period)
      {
         return (FV/PV - 1) / period;
      }

 
 }