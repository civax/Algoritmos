/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.sort;

import algoritmos.util.Util;

/**
 *
 * @author CarlosIván
 */
public class Sort {
    /**
     * Algoritmo selection sort
     * Implementacion de algoritmo de selección,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    public static void sortBySelection(int[] array){	
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[minIndex]>array[j]){
                    minIndex = j;
		}
            }
            if(minIndex!=i){
                Util.swap(array,minIndex,i);
            }
        }
    }
    /**
     * Algoritmo insertion sort
     * Implementacion de algoritmo de inserción,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    public static void sortByInsertion(int[] array){
        for(int i=1;i<array.length;i++){
            int current =array[i];
            int j=i-1;
            while(j>=0&&array[j]>current){
                array[j+1]=array[j--];
            }
            array[j+1]=current;
	}
    }
    /**
     * Algoritmo bubble sort
     * Implementacion de algoritmo de burbuja,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    public static void sortByBubble(int[] array){
        boolean swapped=true; 
	for(int i=0;i<array.length-1&&swapped;i++){
            swapped =false;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    Util.swap(array,j,j+1);
                    swapped=true;
		}
            }
        }
    }
    /**
     * Algoritmo shell sort
     * Implementacion de algoritmo shell,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    public static void sortByShell(int[] array){
       //TODO:
        //Implementar shell sort
    }
}
