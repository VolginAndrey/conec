/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rad;

import java.util.Random;

/**
 *
 * @author KL
 */
public class Podstav {
    private static void swap(char[] a, int i, int change) {
        int temp = a[i];
        a[i] = a[change];
        a[change] = (char) temp;
    }
    public String encrypt(String textInput){
        char[] alfos = new char[34];
        char[] alfNew = new char[34];
        String alfitog = "";
        char[] text;
        text = textInput.toCharArray();
        int n = textInput.length();
        for (char i = 'а'; i <= 'я'; i++) {
            alfos[i - 1071] = i;
            alfNew[i - 1071] = i;

        }
        int al = 33;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < al; i++) {
            int change = i + random.nextInt(al - i);
            swap(alfNew, i, change);
        }
        for (int i = 0; i < n; i++) {

            for (int pos = 0; pos <al; pos++) {

                if (alfos[pos] == text[i]) {

                    alfitog = alfitog + alfNew[pos];

                }
            }
 
        }
        
        return alfitog;
    }
}
