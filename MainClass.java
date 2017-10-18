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
 
 //To execute in terminal: java <directory>/<nameOfmainclassfile>
 //To execute in terminal: java -jar <directory>/<jarfile>.jar

 //Last Updated: octuber 10th, 2017
 import java.util.Arrays;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.LinkedList;
 import java.util.Iterator;
 import statistics.*;
 import vector.*;
 import matrix.*;
 import financial.*;
 
 public class MainClass
 {
   private static List<Double> pruebas1;
   private static List<Double> pesos1;
   
   public static void main(String args[])
   {
      //instancias de objetos
      Vector myVect = new Vector();
      StatisticsValues myStat= new StatisticsValues();
      PearsonCoefficient pearson = new PearsonCoefficient();
      ValuesFrequency freq = new ValuesFrequency(3);
      Matrix myMat = new Matrix();
      
      Double[] listaPrueba = {12.3, 13.3, 12.3, 14.3, 12.8, 15.3, 15.5, 16.2, 17.3, 17.3};
      Double[] listaPesos = {12.0, 13.0, 12.0, 3.0, 20.0, 15.0, 5.0, 5.0, 10.0, 10.0};
      System.out.println(String.format("Vector Pruebas 1: %s", myVect.printVector(listaPrueba)));
      pruebas1 = myVect.toList(listaPrueba);
      pesos1 = myVect.toList(listaPesos);
      Double suma = myStat.sumValuesX(pruebas1);
      System.out.println(String.format("Suma de los valores de X: %2.2f", suma));
      System.out.println(String.format("La media aritmética es: %2.2f", myStat.arithmeticMean(pruebas1)));
      System.out.println(String.format("La suma de los cuadrados: %2.2f", myStat.sumSquareValuesX(pruebas1)));
      System.out.println(String.format("La desv. estándar sigma: %2.2f", myStat.standardDesviationSigma(pruebas1)));
      System.out.println(String.format("La desv. estándar normal: %2.2f", myStat.standardDesviationNormal(pruebas1)));
      System.out.println(String.format("Cociente de variación sigma: %2.2f", myStat.variationCoefficientSigma(pruebas1)));
      System.out.println(String.format("Cociente de variación normal: %2.2f", myStat.variationCoefficientNormal(pruebas1)));
      System.out.println(String.format("Cociente de variancia sigma: %2.2f", myStat.varianceValueSigma(pruebas1)));
      System.out.println(String.format("Cociente de variancia normal: %2.2f", myStat.varianceValueNormal(pruebas1)));
      
      System.out.println(String.format("La suma XY: %2.2f", pearson.sumValueXY(pruebas1, pesos1)));
      System.out.println(String.format("La cov XY: %2.2f", pearson.covarianceXY(pruebas1, pesos1)));
      System.out.println(String.format("Pearson XY: %2.2f", pearson.pearsonSigmaXY(pruebas1, pesos1)));
      
      System.out.println(String.format("Promedio Ponderado: %2.2f", myStat.weightedMean(pruebas1, pesos1)));
      List<Double> orderedList = myStat.orderedValues(pruebas1);
      System.out.println(String.format("Lista ordenada: %s", myVect.printVector(orderedList)));
      
      System.out.println("Cuartiles 25%, 50%, 75%, 100%");
      System.out.println(myVect.printVector(myStat.quartile(pruebas1)));
      
      Double[] listaSegunda = {1.0, 1.0, 1.5, 1.7, 2.0, 2.3, 2.4, 2.5, 2.6, 2.6,
      2.6, 2.9, 3.0, 3.1, 3.4, 3.5, 3.5, 3.7, 4.0, 4.1, 4.1, 4.2, 4.5,
      4.6, 5.0, 5.1, 5.3, 5.3, 5.4, 5.6, 5.8, 6.0, 6.4, 6.5, 6.5, 6.6,
      6.7, 6.8, 6.9, 6.9, 7.0, 7.0, 7.1, 7.2, 7.2, 7.3, 7.3, 7.5, 7.5,
      7.6, 7.6, 7.7, 7.8, 7.9, 8.0, 8.0, 8.1, 8.2, 8.2, 8.3, 8.3, 8.4,
      8.6, 8.7, 8.9, 9.0};


      int numeroclases = 6;
      List<Double> pruebas2 = myVect.toList(listaSegunda);
      List<Double> LI = freq.inferiorLimitClass(pruebas2, numeroclases);
      List<Double> LS = freq.superiorLimitClass(pruebas2, numeroclases);
      List<Integer> Frec = freq.quantitativeVariableFrequency(pruebas2, numeroclases);

      System.out.println(String.format("Limites inferiores: %s", myVect.printVector(LI)));
      System.out.println(String.format("Limites superiores: %s", myVect.printVector(LS)));
      System.out.println(String.format("Frecuencia: %s", myVect.printVector(Frec)));

      String [] listaTercera = {"1", "1", "1", "2", "2", "3", "3",
         "3", "3", "2", "2", "3", "4", "2", "3", "3",
         "4", "5", "5", "5", "3", "3", "2", "3", "3", "2",
         "4", "4", "1", "1", "1", "1", "1", "1", "2", "2",
         "2", "2", "2", "2", "1", "4", "3", "2", "2", "1",
         "2", "1", "3", "2", "1", "1", "1", "1", "3", "3",
         "3", "2", "4", "5", "5", "1", "1", "2", "2", "3"};


      List<String> listaClase = freq.qualitativeVariableClass(myVect.toList(listaTercera));
      List<Integer> listaValFrec = freq.qualitativeVariableFrequency(myVect.toList(listaTercera));
      System.out.println(String.format("Lista clases %s", myVect.printVector(listaClase)));
      System.out.println(String.format("Frecuencia: %s", myVect.printVector(listaValFrec)));

      String[] listaCuarta = {"NY", "NY", "CA", "FL", "FL", "LI", "LI",
         "NM", "NM", "NM", "NM", "NM", "AL", "AL", "FL", "TX",
         "NY", "NY", "FL", "FL", "MI", "TX", "TX", "AL", "TX", "TX",
         "NM", "KT", "DW", "MI", "DW", "NY", "VG", "VG", "TX", "CA"};

      List<String> listaClase2 = freq.qualitativeVariableClass(myVect.toList(listaCuarta));
      List<Integer> listaValFrec2 = freq.qualitativeVariableFrequency(myVect.toList(listaCuarta));
      System.out.println(String.format("Lista clases %s", myVect.printVector(listaClase2)));
      System.out.println(String.format("Frecuencia: %s", myVect.printVector(listaValFrec2)));
      
      Double[] myQuant = {267.0, 503.0, 208.0, 198.0, 250.0, 263.0,
         845.0, 471.0, 310.0, 830.0, 759.0, 1200.0, 810.0, 650.0,
         1500.0, 1113.0, 2300.0, 900.0, 2100.0, 1621.0};
         
      List<Double> myquantV = myVect.toList(myQuant);

      String[] myQual1 = {"P", "P", "P", "P", "P", "P",
         "S", "S", "S", "S", "T", "T", "T", "T",
         "U", "U", "U", "U", "U", "U"};
         
      List<String> myqualt = myVect.toList(myQual1);

      Double coeffIndep = freq.independenceCorrelationIndex(myquantV, myqualt);
      System.out.println(String.format("Coeficiente de independencia: %2.2f", coeffIndep));

      Integer[][] CMatrix = new Integer[5][4];
      CMatrix[0][0] = 200;
      CMatrix[0][1] = 21;
      CMatrix[0][2] = 2;
      CMatrix[0][3] = 0;
      CMatrix[1][0] = 217;
      CMatrix[1][1] = 45;
      CMatrix[1][2] = 5;
      CMatrix[1][3] = 6;
      CMatrix[2][0] = 156;
      CMatrix[2][1] = 105;
      CMatrix[2][2] = 46;
      CMatrix[2][3] = 32;
      CMatrix[3][0] = 73;
      CMatrix[3][1] = 93;
      CMatrix[3][2] = 24;
      CMatrix[3][3] = 2;
      CMatrix[4][0] = 6;
      CMatrix[4][1] = 86;
      CMatrix[4][2] = 52;
      CMatrix[4][3] = 29;
      
      int numRow = myMat.numberOfRowsMatrix(CMatrix);
      int numCol = myMat.numberOfColumnsMatrix(CMatrix);
      int nValues = freq.valueOfNContingencyMatrix(CMatrix);
      Double chiSQ = freq.squareChiIndexContingency(CMatrix);
      Double pearCM = freq.pearsonCoefficientOfContingency(chiSQ, nValues);

      System.out.println(String.format("Numero filas: %d", numRow));
      System.out.println(String.format("Numero columnas: %d", numCol));
      System.out.println(String.format("Valor de N %d", nValues));
      System.out.println(String.format("MatrixChiCuadContingencia %2.2f", chiSQ));
      System.out.println(String.format("Pearson Chi Cuadrado: %2.2f", pearCM));
      System.out.println(String.format("Chuprov Chi Cuadrado: %2.2f", freq.chuprovCoefficientOfContingency(pearCM ,numRow, numCol)));

      String[] qualA = {"Masc", "Masc", "Fem", "Fem", "Fem", "Fem", "Masc", "Masc", "Fem"};
      String[] qualB = {"Ofic", "Obr", "Obr", "Art", "Art", "Ofic", "Art", "Ofic", "Art"};
      List<String> qualAL = myVect.toList(qualA);
      List<String> qualBL = myVect.toList(qualB);
      
      System.out.println(String.format("Género %s", myVect.printVector(qualAL)));
      System.out.println(String.format("Trabaj %s", myVect.printVector(qualBL)));

      System.out.println(String.format("Indice Chi Cuadrado: %2.2f", freq.squareChiIndexContingency(qualBL, qualAL)));
      System.out.println(String.format("Pearson: %2.2f", freq.pearsonCoefficientOfContingency(qualBL, qualAL)));
      System.out.println(String.format("Chuprov: %2.2f", freq.chuprovCoefficientOfContingency(qualBL, qualAL)));

      Double [] listaQuarta = {1.0, 1.0, 1.5, 1.7, 2.0, 2.3, 2.4, 2.5, 2.6, 2.6,
         2.6, 2.9, 3.0, 3.1, 3.4, 3.5, 3.5, 3.7, 4.0, 4.1, 4.1, 4.2, 4.5,
         4.6, 5.0, 5.1, 5.3, 5.3, 5.4, 5.6, 5.8, 6.0, 6.4, 6.5, 6.5, 6.6,
         6.7, 6.8, 6.9, 6.9, 7.0, 7.0, 7.1, 7.2, 7.2, 7.3, 7.3, 7.5, 7.5,
         7.6, 7.6, 7.7, 7.8, 7.9, 8.0, 8.0, 8.1, 8.2, 8.2, 8.3, 8.3, 8.4,
         8.6, 8.7, 8.9, 9.0};

      List<Double> listaQuinta = myStat.normalizedListTStudent(myVect.toList(listaQuarta));

      System.out.println(String.format("Lista no normalizada %s", myVect.printVector(listaQuarta)));
      System.out.println(String.format("Media lista NO normalizada: %2.2f", myStat.arithmeticMean(myVect.toList(listaQuarta))));
      System.out.println(String.format("Varianza lista NO normalizada: %2.2f", myStat.varianceValueSigma(myVect.toList(listaQuarta))));
      System.out.println(String.format("Lista normalizada %s", myVect.printVector(listaQuinta)));
      System.out.println(String.format("Media lista normalizada: %2.2f", myStat.arithmeticMean(listaQuinta)));
      System.out.println(String.format("Varianza lista normalizada: %2.2f", myStat.varianceValueSigma(listaQuinta)));

      System.out.println(String.format("numero datos %d", freq.totalNumberOfValues(listaQuinta)));
      System.out.println(String.format("Limites inferior %s", myVect.printVector(freq.inferiorLimitClass(myVect.toList(listaQuarta), 6))));
      System.out.println(String.format("Limites superior %s", myVect.printVector(freq.superiorLimitClass(myVect.toList(listaQuarta), 6))));
      System.out.println(String.format("Frecuencia listaQuarta: %s", myVect.printVector(freq.quantitativeVariableFrequency(myVect.toList(listaQuarta), 6))));
      System.out.println("Fin de pruebas");
      
      Integer [] vectorX = {4, 3, 2};
      Integer [] vectorY = {3, 1, 0};
      
      List<Integer> vectX = myVect.toList(vectorX);
      List<Integer> vectY = myVect.toList(vectorY);
      
      System.out.println(String.format("Distancia es %2.2f", myVect.distance(vectX,vectY)));
      
      System.out.println(String.format("Producto Punto es %2.2f", myVect.dotProduct(vectX,vectY)));
      System.out.println(String.format("MóduloX es %2.2f", myVect.module(vectX)));
      System.out.println(String.format("MóduloY es %2.2f", myVect.module(vectY)));
      System.out.println(String.format("Ángulo X/Y es %2.2f", myVect.angle(vectX, vectY)));
      
      List<Double> crossP = myVect.crossPoint(vectX,vectY);
      System.out.println(String.format("El producto Cruz XY es %s", myVect.printVector(crossP)));
      
      System.out.println(String.format("El el vector unitario XY es %s", myVect.printVector(myVect.unitaryVector(crossP))));
      
      Integer[][] MatrX = new Integer[2][4];
      MatrX [0][0] = 1;
      MatrX [0][1] = 2;
      MatrX [0][2] = 3;
      MatrX [0][3] = 4;
      MatrX [1][0] = 5;
      MatrX [1][1] = 6;
      MatrX [1][2] = 7;
      MatrX [1][3] = 8;
      
      Integer[][] MatrX2 = new Integer[5][2];
      MatrX2 [0][0] = 1;
      MatrX2 [0][1] = 2;
      MatrX2 [1][0] = 3;
      MatrX2 [1][1] = 4;
      MatrX2 [2][0] = 5;
      MatrX2 [2][1] = 6;
      MatrX2 [3][0] = 8;
      MatrX2 [3][1] = 7;
      MatrX2 [4][0] = 9;
      MatrX2 [4][1] = 0;
      
      System.out.println(String.format("Las filas de X2: %s", MatrX2.length));
      System.out.println(String.format("Las columnas de X2: %s", MatrX2[0].length)); 
      System.out.println(String.format("La matriz X es: %s", myMat.printMatrix(MatrX)));
      System.out.println(String.format("La matriz X2 es: %s", myMat.printMatrix(MatrX2)));
      
      
      Object[][] transposeX = new Object[MatrX2[0].length][MatrX2.length];
      System.out.println(String.format("Las filas de TX2: %s", transposeX.length));
      System.out.println(String.format("Las columnas de TX2: %s", transposeX[0].length));
      transposeX = myMat.transpose(myMat.matrixToObject(MatrX2));
      Integer[][] MatrTX = myMat.objectToInt(transposeX);
      System.out.println(String.format("La matriz transp X2 es: %s", myMat.printMatrix(MatrTX)));
      
      Integer[][] MatA = new Integer[2][3];
      MatA [0][0] = 1;
      MatA [0][1] = 2;
      MatA [0][2] = 2;
      MatA [1][0] = 2;
      MatA [1][1] = 3;
      MatA [1][2] = 2;
      
      Integer[][] MatB = new Integer[3][2];
      MatB [0][0] = 6;
      MatB [0][1] = 0;
      MatB [1][0] = 4;
      MatB [1][1] = 5;
      MatB [2][0] = 2;
      MatB [2][1] = 3;
      System.out.println(String.format("La matriz A es: %s", myMat.printMatrix(MatA)));
      System.out.println(String.format("La matriz B es: %s", myMat.printMatrix(MatB)));
      System.out.println(String.format("Product A * B: %s", myMat.printMatrix(myMat.productOfMatrix(MatA, MatB))));
      System.out.println(String.format("Product 3 * A: %s", myMat.printMatrix(myMat.scalarMatrix(3, MatA))));
      System.out.println(String.format("Product A + A: %s", myMat.printMatrix(myMat.sumOfMatrix(MatA, MatA))));
      System.out.println(String.format("Product A - A: %s", myMat.printMatrix(myMat.substractionOfMatrix(MatA, MatA))));
      System.out.println(String.format("Row vector A 1: %s", myVect.printVector(myMat.getRowVector(MatA, 0))));
      
      List<Integer> myVector = new ArrayList<Integer>();
      myVector.add(1);
      myVector.add(2);
      myVector.add(3);
      myVector.add(4);
      Integer[][] MatC = {{1, 3, 2}, {2, 3, 2}, {4, 3, 2} };
      System.out.println(String.format("Diagonal C: %s", myMat.printMatrix(myMat.diagonalMatrix(myVector))));
      System.out.println(String.format("Diagonal Vector C: %s", myVect.printVector(myMat.getDiagonalVector(MatC))));
      System.out.println(String.format("Identity 3: %s", myMat.printMatrix(myMat.identityMatrix(3))));
      System.out.println(String.format("Traza(C): %s", myMat.getTrace(MatC)));
      
      List<Integer> myVectorM = new ArrayList<Integer>();
      myVectorM.add(3);
      myVectorM.add(4);
      myVectorM.add(2);
      myVectorM.add(1);
      
      List<Integer> myVectorK = new ArrayList<Integer>();
      myVectorK.add(4);
      myVectorK.add(5);
      myVectorK.add(6);
      myVectorK.add(7);
      
      List<Double> myVectorW = new ArrayList<Double>();
      myVectorW.add(0.2);
      myVectorW.add(0.3);
      myVectorW.add(0.1);
      myVectorW.add(0.4);
      System.out.println(String.format("M: %s", myVect.printVector(myVectorM)));
      System.out.println(String.format("-K: %s", myVect.printVector(myVect.scalarVector(-1, myVectorK))));
      System.out.println(String.format("M + K: %s", myVect.printVector(myVect.vectorAddition(myVectorM, myVectorK))));
      System.out.println(String.format("M + -K: %s", myVect.printVector(myVect.vectorSubstraction(myVectorM, myVectorK))));

      double distanceMK = myVect.distanceBetweenVectorsWithMetric(myVectorM, myVectorK, myVectorW);
      System.out.println(String.format("distance(M,K)W: %2.2f", distanceMK));
      
      Integer[][] dataM = new Integer[2][4];
      dataM[0][0] = 3;
      dataM[0][1] = 4;
      dataM[0][2] = 2;
      dataM[0][3] = 1;
      dataM[1][0] = 4;
      dataM[1][1] = 5;
      dataM[1][2] = 6;
      dataM[1][3] = 7;
      
      System.out.println(String.format("dataM: %s", myMat.printMatrix(dataM)));
      double distanceMK2 = myMat.getDistanceBetweenRows(dataM, myVectorW, 0, 1);
      System.out.println(String.format("distance(M,K)W: %2.2f", distanceMK2));
/**

TableAX = [[1,2,3,4],[4,5,6,7],[7,2,3,2],[3,2,1,4]]
TableAXCentred = pca.centralized_matrix(TableAX)
varianceMat =  pca.variance_matrix(TableAXCentred)
print("Covariance Matrix", varianceMat)
print("diagonalRSS: ", pca.diagonal_reciprocal_square_sigma(varianceMat))
print("diagonalRS: ", pca.diagonal_reciprocal_sigma(varianceMat))
print("Correlation matrix ", pca.correlation_r_matrix(varianceMat))
**/

      simpleInterest simple = new simpleInterest();
      double rate = 0.05/365;
      System.out.println(String.format("Intereses: %2.2f", simple.interestValue(2000.0, 50, rate)));
      System.out.println(String.format("VF: %2.2f", simple.futureValue(2000.0, 50, rate)));
      System.out.println(String.format("PV: %2.2f", simple.presentValue(simple.futureValue(2000.0, 50, rate), 50, rate)));
      System.out.println(String.format("rate: %2.2f", simple.interestRate(2000.0, 2013.70, 50) * 365));
      
      double rate2 = 0.06/12;
      System.out.println(String.format("VF2: %2.2f", simple.presentValue(2500.0, 9, rate2)));
      
      double rate3 = 0.08/12;
      System.out.println(String.format("DC: %2.2f", simple.discountedValue(3080.0, 5, rate3)));
      
      double rate4 = 0.06/12;
      System.out.println(String.format("DR: %2.2f", simple.rationalDiscountValue(1200.0, 1, rate4)));
      
      double rateA = 0.05/360;
      double rateB = 0.04/365;
      double discountA = simple.rationalDiscountValue(5000.0, 60, rateA);
      double discountB = simple.rationalDiscountValue(5000.0, 60, rateB);
      System.out.println(String.format("DCA: %2.2f", discountA));
      System.out.println(String.format("DCB: %2.2f", discountB));
      System.out.println(String.format("Ganancia: %2.2f", discountA - discountB));

/*
   coeff = [1, -5, 6, 4]
   print("f(p) = ", num.bisection(-1.5, 2.6, coeff, 0.0005, 15))
*/
   }
      
 }
 
 
 
