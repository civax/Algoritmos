/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import algoritmos.series.Series;
import algoritmos.sort.Sort;
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
        int[] array1=Util.createRandomIntArray(20, Byte.MIN_VALUE, Byte.MAX_VALUE);
        int[] array2=array1.clone();
        int[] array3=array1.clone();
        HashMap<String,Sort> algoritmos=SortingMethods.getSortingMethods();
        HashMap<String,Integer> performance;
        // insertion sort
        System.out.println("-- Insertion Sort --");
	Util.printArray(array1);
	performance=algoritmos.get(Sort.INSERTION).sort(array1);
	Util.printArray(array1);
	System.out.println("isSorted: "+Util.isSorted(array1));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
        //selection sort
        System.out.println("-- Selection Sort --");
        Util.printArray(array2);
	performance=algoritmos.get(Sort.SELECTION).sort(array2);
	Util.printArray(array2);
	System.out.println("isSorted: "+Util.isSorted(array2));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
        
        //bubble sort
        System.out.println("-- Bubble Sort --");
        Util.printArray(array3);
	performance=algoritmos.get(Sort.BUBBLE).sort(array3);
	Util.printArray(array3);
	System.out.println("isSorted: "+Util.isSorted(array3));
        System.out.println("movimientos: "+performance.get(MOVIMIENTOS)+" comparaciones: "+performance.get(COMPARACIONES));
    }
    
    private static void  testSortsAPosteriori(){
        HashMap<String,Sort> algoritmos=SortingMethods.getSortingMethods();
        ArrayList<HashMap<String,Double>> desempeñoInsertion=new ArrayList<>();
        ArrayList<HashMap<String,Double>> desempeñoBubble=new ArrayList<>();
        ArrayList<HashMap<String,Double>> desempeñoSelection=new ArrayList<>();
        int rango=200;
        int iteraciones=500;
        
        //crear un array de 1 a 200 posiciones
        for(int N=1;N<=rango;N++){
            //creando los arreglos de N elementos
            int[] array=Util.createRandomIntArray(N, Byte.MIN_VALUE, Byte.MAX_VALUE);;
            desempeñoSelection.add(testSortAlgorithm(iteraciones, array, algoritmos.get(Sort.SELECTION)));
            desempeñoInsertion.add(testSortAlgorithm(iteraciones, array, algoritmos.get(Sort.INSERTION)));
            desempeñoBubble.add(testSortAlgorithm(iteraciones, array, algoritmos.get(Sort.BUBBLE)));
        }
        
        
    }
    private static HashMap<String,Double> testSortAlgorithm(final int ITERACIONES, int[] array, Sort algoritmo){
        int comparaciones=0,movimientos=0;
        HashMap<String,Integer> desempeño=null;
        HashMap<String,Double> desempeñoPromedio=new HashMap<>();
         // llamar 500 veces cada algoritmo
        for(int i=0;i<ITERACIONES;i++){
            int[] array2=array.clone();
            desempeño=algoritmo.sort(array2);
            //conteo de comparaciones y movimientos
            comparaciones+=desempeño.get(COMPARACIONES);
            movimientos+=desempeño.get(MOVIMIENTOS);
        }
        // salvando promedio de comparaciones y movimientos
        desempeñoPromedio.put(COMPARACIONES,comparaciones/((double)ITERACIONES));
        desempeñoPromedio.put(MOVIMIENTOS,movimientos/((double)ITERACIONES));
        return desempeñoPromedio;
    }
    
    private static void contarDivisionesLineal(){
        int[] lista=Util.createIntArray(20, 0);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+Series.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
}
