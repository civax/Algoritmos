/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.util;

import java.util.ArrayList;

/**
 *
 * @author CarlosIván Castillo Sepúlveda
 */
public class Algoritmos {
    
    /**
     *
     * Criba de Eratóstenes
     * 
     *  La criba de Eratóstenes es un algoritmo que permite hallar números primos menores que un número natural dado.
     * 
     *  Partimos de una lista de números que van de 2 hasta un determinado número.
     *  Eliminamos de la lista los múltiplos de 2.
     *  Luego tomamos el primer número después del 2 que no fue eliminado (el 3) y eliminamos de la lista sus múltiplos, y así sucesivamente.
     *  El proceso termina cuando el cuadrado del mayor número confirmado como primo es menor que el número final de la lista.
     *  Los números que permanecen en la lista son los primos.
     * @param a limite inferior de rango
     * @param b limite superior de rango
     * @return una lista con los números primos desde a, hasta b
     */
    // Algoritmo de Eratóstenes
    public ArrayList<Integer> getPrimosEnRango(int a,int b){
        ArrayList<Integer> lista= getArrayConsecutivo(a,b);
        ArrayList<Integer> reslista= new ArrayList<>();
        System.out.println(lista);
        int i=0;
        while(i<lista.size()){
            int base =lista.remove(i++); //consideramos constante esta operacion 1k
            reslista.add(base); //toma pibote 1k
            for(Integer j:lista){
                if(j%base!=0){
                    reslista.add(j);
                }
            }
            lista=reslista;
            reslista= new ArrayList<>();
        }
        return lista;
    }
    
    public ArrayList<Integer> getArrayConsecutivo(int a,int b){
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=a;i<=b;i++){
            list.add(i);
        }
        return list;
    }
    
    /**
    * 
    * Algoritmo de Euclides tradicional implementado de manera recurrente
    * Función mcd(a,b):
    * 
    * Si b=0  entonces:
    * El resultado es a 
    * En otro caso:
    * El resultado es mcd(b,a mod b)
    *
    * @param a número entero mayor a 0
    * @param b número entero mayor a 0
    * @return máximo común divisor de a y b
    */
    public int getMCD(int a,int b){
        if(b==0){
            return a;
        }else{
            return getMCD(b,a%b);
        }
    }
    public int getNumeroDeDivisionesMCD(int a,int b,int i){
        if(b==0){
            System.out.println("#div: "+i);
            return a;
        }else{
            return getNumeroDeDivisionesMCD(b,a%b,++i);
        }
    }
    /**
     * Este método obtiene el fibonacci de un número entero mayor a 0
     * 
     * @param n 
     * @return Número fibonacci de n
     */
    public int getFibonacci(int n){
        if(n==0){
            return 1;
        }if(n==1){
            return 1;
        }else{
            return getFibonacci(n-1)+getFibonacci(n-2);
        }
    }
    /**
     * Obtiene un arreglo con los números fibonacci para el rango indicado
     * 
     * @param a limite inferior
     * @param b limite superior
     * @return Una arreglo con los números fibonacci desde a hasta b
     */
    public int[] getFibonacciArray(int a,int b){
        int[] list=new int[b-a+2];
        for(int i=a-1,j=0;i<=b;i++,j++){
            list[j]=(getFibonacci(i));
        }
        return list;
    }
}
