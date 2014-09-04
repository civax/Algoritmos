/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import algoritmos.series.Series;
import algoritmos.sort.Sorter;
import algoritmos.sort.SortingMethods;
import static algoritmos.sort.SortingMethods.COMPARACIONES;
import static algoritmos.sort.SortingMethods.MOVIMIENTOS;
import algoritmos.util.Util;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CarlosIván
 */
public class TestAlgoritmos {

    /**
     * @param args the command line arguments
     */
    final static Util algoritmo=new Util();
    public static void main(String[] args) {
        //Ejercicio 9
        //contarDivisiones();
        //contarDivisionesLineal();
        //primos.getPrimosEnRango(2, 15);
        //calcularParejas(5);
        testSorts();
        //testSortsAPosteriori();
        
    }
    /*
     *  generar los números fibonacci de 2 hasta 16
     *  generar el MCD de A , B donde A= fibonacci de n y B fibonaci de n-1
     */
    private static void contarDivisiones(){
        int[] lista=Series.getFibonacciArray(2, 16);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+Series.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
    private static void calcularParejas(int n){
        String pares="";
        for(double a=1;a<=n;a++){
            for(double b=1;b<=n;b++){
                if((Math.cos(a)*Math.sin(b))<=(b/2*a)){
                    pares+="("+a+","+b+") ";
                }
            }
        }
        System.out.println(pares);
    }
    private static void testSorts(){
        createCloneArrays(20, Byte.MIN_VALUE, Byte.MAX_VALUE);
        
        HashMap<String,Sorter> algoritmos=SortingMethods.getSortingMethods();
        HashMap<String,Integer> performance;
        // insertion sort
        System.out.println("-- Insertion Sort --");
	Util.printArray($array1);
	performance=algoritmos.get(Sorter.INSERTION).sort($array1);
	Util.printArray($array1);
	System.out.println("isSorted: "+Util.isSorted($array1));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
        //selection sort
        System.out.println("-- Selection Sort --");
        Util.printArray($array2);
	performance=algoritmos.get(Sorter.SELECTION).sort($array2);
	Util.printArray($array2);
	System.out.println("isSorted: "+Util.isSorted($array2));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
        
        //bubble sort
        System.out.println("-- Bubble Sort --");
        Util.printArray($array3);
	performance=algoritmos.get(Sorter.BUBBLE).sort($array3);
	Util.printArray($array3);
	System.out.println("isSorted: "+Util.isSorted($array3));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
        
        // shell sort
        System.out.println("-- Shell sort --");
        int[] array=Util.createRandomIntArray(20, Byte.MIN_VALUE, Byte.MAX_VALUE);
        Util.printArray(array);
        SortingMethods.sortByShell(array);
        Util.printArray(array);
        System.out.println("isSorted: "+Util.isSorted(array));
       // System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
    }
    static int[] $array1;
    static int[] $array2;
    static int[] $array3;
    private static void createCloneArrays(int N,int minVal,int maxVal){
        $array1=Util.createRandomIntArray(N, minVal,maxVal );
        $array2=$array1.clone();
        $array3=$array1.clone();
    }
    private static void  testSortsAPosteriori(){
        HashMap<String,Sorter> algoritmos=SortingMethods.getSortingMethods();
        final int RANGO=200;
        final int ITERACIONES=500;
        // posicion 0 almacena numero de comparaciones
        // posicion 1 almacena numeo de movimientos
        double[][] desempeñoInsertion=new double[RANGO][2];
        double[][] desempeñoBubble=new double[RANGO][2];
        double[][] desempeñoSelection=new double[RANGO][2];
        //crear un array de 1 a 200 posiciones
        for(int N=1, k=0;N<=RANGO;N++,k++){
            // llamar 500 veces cada algoritmo
            for(int i=0;i<ITERACIONES;i++){
                //creando los arreglos de N elementos
                createCloneArrays(N, Short.MIN_VALUE, Integer.MAX_VALUE);
            
                calculatePerformance(desempeñoSelection,algoritmos.get(Sorter.SELECTION),   $array1,k);
                calculatePerformance(desempeñoInsertion,algoritmos.get(Sorter.INSERTION),   $array2,k);
                calculatePerformance(desempeñoBubble,   algoritmos.get(Sorter.BUBBLE),      $array3,k);
                
            }
            //calcular la media
            desempeñoSelection[k][0]=desempeñoSelection[k][0]/((double)ITERACIONES);
            desempeñoSelection[k][1]=desempeñoSelection[k][1]/((double)ITERACIONES);
            
            desempeñoInsertion[k][0]=desempeñoInsertion[k][0]/((double)ITERACIONES);
            desempeñoInsertion[k][1]=desempeñoInsertion[k][1]/((double)ITERACIONES);
            
            desempeñoBubble[k][0]=desempeñoBubble[k][0]/((double)ITERACIONES);
            desempeñoBubble[k][1]=desempeñoBubble[k][1]/((double)ITERACIONES);
        }
        System.out.println("Selection: ");
        Util.printArray(desempeñoSelection);
        System.out.println("Insertion: ");
        Util.printArray(desempeñoInsertion);
        System.out.println("Bubble: ");
        Util.printArray(desempeñoBubble);   
    }
    
    private static void calculatePerformance(double[][] desempeño,Sorter algoritmo,int[] array,int index){
        
        HashMap<String,Integer> desempeñoMap= algoritmo.sort(array);
        int comparaciones=0,movimientos=0;
        //conteo de comparaciones y movimientos
        desempeño[index][0]+=desempeñoMap.get(COMPARACIONES);
        desempeño[index][1]+=desempeñoMap.get(MOVIMIENTOS);
    }
    
    private static void contarDivisionesLineal(){
        int[] lista=Util.createIntArray(20, 0);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+Series.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
}
