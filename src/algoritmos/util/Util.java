/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author CarlosIván Castillo Sepúlveda
 */
public class Util {
    
    public static ArrayList<Integer> getIntListConsecutivo(int a,int b){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=a;i<=b;i++){
            list.add(i);
        }
        return list;
    }
    /**
     * Crea un arreglo entero con valores consecutivos desde min hasta min+N
     * @param N tamaño del arreglo
     * @param min limite inferior para los numeros aleatorios
     * @return un arreglo de N numeros enteros aleatorios
     * */
    
    public static int[] createIntArray(int N,int min){
        int[] list=new int[N];
        for(int i=0,j=min;i<N;i++,j++){
            list[j]=j+1;
        }
        return list;
    }
    /**
     * Crea un arreglo entero con valores aleatorios en un rango dado
     * @param N tamaño del arerglo
     * @param min limite inferior para los numeros aleatorios
     * @param max limite superior para los numeros aleatorios
     * @return un arreglo de N numeros enteros aleatorios
     * */
    public static int[] createRandomIntArray(int N,int min,int max){
    	int[] intArray=new int[N];
	for(int i=0;i<intArray.length;i++){
		intArray[i]=(int)(Math.random()*(max-min+1)) ;
	}
	return intArray;	
    }
    /***
     * imprime in arreglo
     * @param array un arreglo de enteros a imprimir
     */
    public static void printArray(int[] array){
    	System.out.println(Arrays.toString(array));
    }
    public static void printArray(double[][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /**
     * Intercambia dos elementos de un arreglo dados los indices 1 y 2
     * @param array un arreglo entero
     * @param index1 indice 1 de elemento a intercambiar
     * @param index2 indice 2 de elemento a intercambiar
     * */
    public  static void swap(int[] array,int index1,int index2){
    	int aux=array[index1];
    	array[index1]=array[index2];
    	array[index2]=aux;
    }
    /**
     *  determina si un elemento esta ordenado
     * @return true si el arreglo esta ordenado
     * @param array Arreglo a analizar
     * */
    public static boolean isSorted(int[] array){
    	int current=array[0];
	for(int i=1;i<array.length;i++){
        	if(array[i-1]>array[i]){
                    return false;
		}
	}
	return true;
    }
}
