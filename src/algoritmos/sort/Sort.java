/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.sort;

/**
 *
 * @author CarlosIván
 */
public class Sort {
    	/**
	 * @param N tamaño del arerglo
	 * @param min limite inferior para los numeros aleatorios
	 * @param max limite superior para los numeros aleatorios
	 * @return un arreglo de N numeros enteros aleatorios
	 * */
	public static int[] createIntArray(int N,int min,int max){
		int[] intArray=new int[N];
		for(int i=0;i<intArray.length;i++){
			intArray[i]=(int)(Math.random()*(max-min+1)) ;
		}
		return intArray;	
	}
	/***
	 * imprime in arreglo
	 * @param array un arreglo
	 */
	public static void printArray(int[] array){
		System.out.println(Arrays.toString(array));
	}
	/**
	 * intercambia dos elementos de un arreglo
	 * @param array un arreglo entero
	 * */
	public  static void swap(int[]	array,int index1,int index2){
		int aux=array[index1];
		array[index1]=array[index2];
		array[index2]=aux;
	}
	/**
	 * 
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
	/**
	 * Algoritmo selection sort
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
				swap(array,minIndex,i);
			}
		}
	}
	/**
	 * Algoritmo insertion sort
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
	 * */
	public static void sortByBubble(int[] array){
		boolean swapped=true; 
		for(int i=0;i<array.length-1&&swapped;i++){
			swapped =false;
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					swap(array,j,j+1);
					swapped=true;
				}
			}
		}
}
