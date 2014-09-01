/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import algoritmos.series.Series;
import algoritmos.sort.Sort;
import algoritmos.sort.SortingMethods;
import algoritmos.util.Util;
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
        // insertion sort
        System.out.println("-- Insertion Sort --");
	Util.printArray(array1);
	algoritmos.get("insertion").sort(array1);
	Util.printArray(array1);
	System.out.println("isSorted: "+Util.isSorted(array1));
        
        //selection sort
        System.out.println("-- Selection Sort --");
        Util.printArray(array2);
	algoritmos.get("seection").sort(array2);
	Util.printArray(array2);
	System.out.println("isSorted: "+Util.isSorted(array2));
        
        //bubble sort
        System.out.println("-- Bubble Sort --");
        Util.printArray(array3);
	algoritmos.get("section").sort(array3);
	Util.printArray(array3);
	System.out.println("isSorted: "+Util.isSorted(array3));
    }
    private static void testSortsAPosteriori(){
        final int ITERACIONES=500;
        HashMap<String,Sort> algoritmos=SortingMethods.getSortingMethods();
        int[] array1;
        int[] array2;
        int[] array3;
        int tiempo1,tiempo2,tiempo3;
        //crear un array de 1 a 200 posiciones
        for(int N=1;N<=200;N++){
            // llamar 500 veces cada algoritmo
            for(int i=0;i<500;i++){
                //creando los arreglos de N elementos
                array1=Util.createRandomIntArray(N, Byte.MIN_VALUE, Byte.MAX_VALUE);
                array2=array1.clone();
                array3=array1.clone();
                //ordenando los arreglos previamente creados con los diferentes algoritmos a analizar
                System.currentTimeMillis();
                algoritmos.get("selection") .sort(array1);
                algoritmos.get("insertion") .sort(array2);
                algoritmos.get("bubble")    .sort(array3);
            }
        }
    }
    private static void contarDivisionesLineal(){
        int[] lista=Util.createIntArray(20, 0);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+Series.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
}
