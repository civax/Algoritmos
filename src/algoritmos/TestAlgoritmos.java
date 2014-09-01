/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import algoritmos.sort.Sort;
import algoritmos.util.Util;
import algoritmos.series.Series;

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
        calcularParejas(5);
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
        int[] array=Util.createRandomIntArray(10, 0, 15);
	Util.printArray(array);
	Sort.sortByBubble(array);
	Util.printArray(array);
	System.out.println(Util.isSorted(array));
    }
    private static void contarDivisionesLineal(){
        int[] lista=Util.createIntArray(20, 0);
        for(int i=1;i<lista.length;i++){
            System.out.println("A: "+lista[i]+" B: "+lista[i-1] );
            System.out.println("MCD: "+Series.getNumeroDeDivisionesMCD(lista[i], lista[i-1],0));
        }
    }
}
