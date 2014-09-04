/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos.sort;

import java.util.HashMap;

/**
 *
 * @author CarlosIván
 */
@FunctionalInterface
public interface Sorter {
    String INSERTION="INSERTION";
    String SELECTION="SELECTION";
    String BUBBLE="BUBBLE";
    String SHELL="SHELL";
    public HashMap<String,Integer> sort(int[] array);
}
