/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.sort;

import algoritmos.series.Series;
import algoritmos.util.Util;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author CarlosIván
 */
public class SortingMethods {
    public static final String COMPARACIONES="COMPARACIONES";
    public static final String MOVIMIENTOS="MOVIMIENTOS";
    
    public static HashMap<String,Sorter> getSortingMethods(){
        HashMap<String,Sorter> map=new HashMap<>();
        map.put(Sorter.INSERTION, insertion);
        map.put(Sorter.SELECTION, selection);
        map.put(Sorter.BUBBLE,bubble);
        map.put(Sorter.SHELL,shell);
        return map;
    }
    /**
     * Algoritmo insertion sort
     * Implementacion de algoritmo de inserción en lambda Expression,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    private static final Sorter insertion=array->
                    {
                        HashMap<String,Integer> map=new HashMap<>();
                        int comparaciones=0;
                        int movimientos=0;
                        
                        for(int i=1;i<array.length;i++){
                            int current =array[i];
                            int j=i-1;
                            boolean flag=true;
                            while(j>=0&&flag){
                                comparaciones++;
                                if(array[j]>current){
                                    movimientos++;
                                    array[j+1]=array[j--];
                                }else{
                                    flag=false;
                                }
                            }
                            movimientos++;
                            array[j+1]=current;
                        }
                        map.put(COMPARACIONES,comparaciones);
                        map.put(MOVIMIENTOS,movimientos);
                        return map;
                    };
    /**
     * Algoritmo selection sort
     * Implementacion de algoritmo de selección en lambda Expression,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * 
     * */
    private static final Sorter selection=array->
                    {
                        HashMap<String,Integer> map=new HashMap<>();
                        int comparaciones=0;
                        int movimientos=0;
                        
                        for(int i=0;i<array.length-1;i++){
                            int minIndex=i;
                            for(int j=i+1;j<array.length;j++){
                                comparaciones++;
                                if(array[minIndex]>array[j]){
                                    minIndex = j;
                                }
                            }
                            if(minIndex!=i){
                                //swap incluye 3 movimientos
                                movimientos+=3;
                                Util.swap(array,minIndex,i);
                            }
                        }
                        map.put(COMPARACIONES,comparaciones);
                        map.put(MOVIMIENTOS,movimientos);
                        return map;
                    };
    /**
     * Algoritmo bubble sort
     * Implementacion de algoritmo de burbuja,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    private static final Sorter bubble=array->
                    {
                        HashMap<String,Integer> map=new HashMap<>();
                        int comparaciones=0;
                        int movimientos=0;
                        
                        boolean swapped=true; 
                        for(int i=0;i<array.length-1&&swapped;i++){
                            swapped =false;
                            for(int j=0;j<array.length-i-1;j++){
                                comparaciones++;
                                if(array[j]>array[j+1]){
                                    //swap incluye 3 movimientos
                                    movimientos+=3;
                                    Util.swap(array,j,j+1);
                                    swapped=true;
                                }
                            }
                        }
                        map.put(COMPARACIONES,comparaciones);
                        map.put(MOVIMIENTOS,movimientos);
                        return map;
                    };
    /**
     * Algoritmo shell sort
     * Implementacion de algoritmo shell,
     * Ordena un arreglo de enteros
     * @param array arreglo a ordenar
     * */
    private static final Sorter shell=array->
                    {
                        HashMap<String,Integer> map=new HashMap<>();
                        int comparaciones=0;
                        int movimientos=0;
                        //TODO:
                        //Implementar shell sort
                        map.put(COMPARACIONES,comparaciones);
                        map.put(MOVIMIENTOS,movimientos);
                        return map;
                    };
    
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
        LinkedList<Integer> H_list=Series.getH_ShellList(array.length);
        int h=H_list.pop();
        while(h>1){
            for(int i=1;i<array.length;i+=(h+1)){
                int current =array[i];
                int j=i-1;
                while(j>=0&&array[j]>current){
                    array[j+h]=array[j];
                    j-=h;
                }
                array[j+h]=current;
            }
        }
        for(int i=1;i<array.length;i++){
            int current =array[i];
            int j=i-1;
            while(j>=0&&array[j]>current){
                array[j+1]=array[j--];
            }
            array[j+1]=current;
	}
       
       
    }
    
}
