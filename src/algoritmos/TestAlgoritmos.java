/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import algoritmos.util.Algoritmos;

/**
 *
 * @author CarlosIván
 */
public class TestAlgoritmos {

    /**
     * @param args the command line arguments
     */
    final static Algoritmos algoritmo=new Algoritmos();
    public static void main(String[] args) {
        //Ejercicio 9
        //contarDivisiones();
        //contarDivisionesLineal();
        //primos.getPrimosEnRango(2, 15);
        calcularParejas(5);
    }
    /*
     *  generar los números fibonacci de 2 hasta 16
     *  generar el MCD de A , B donde A= fibonacci de n y B fibonaci de n-1
     */
    private static void contarDivisiones(){
        int[] lista=algoritmo.getFibonacciArray(2, 16);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+algoritmo.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
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
    private static void contarDivisionesLineal(){
        int[] lista=getArray();
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+algoritmo.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
    private static int[] getArray(){
        int[] list=new int[20];
        for(int i=0;i<20;i++){
            list[i]=i+1;
        }
        return list;
    }
}
