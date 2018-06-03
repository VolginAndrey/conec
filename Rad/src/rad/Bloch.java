/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rad;

/**
 *
 * @author KL
 */
public class Bloch {
    private static void aswap(char[] pa, int i, int j) {
        char k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private static String arraout(char[] pa, int i) {
        String s = "";

        for (char a : pa) {
            s += a;
        }

        s = s.substring(0, s.length());
        return s;

    }

    private static String prmt(char[] pa, int i, int k, int ik) {
//        if (ik == k) {

//            return;
//        }
        for (int j = i; j < pa.length; j++) {
            ik++;

            aswap(pa, i, j);
            //System.out.println(ik + " " + k);
            if (ik == k) {

                break;
            }
            prmt(pa, i + 1, k, ik);
            aswap(pa, i, j);
        }
        String textInput = arraout(pa, i);
        return textInput;
    }
//    private static char[] splitString(){
//        
//        return elem;
//}

    private static String blockShifr(String textInput, Integer k) {
        //        String textInput = jTextField1.getText();
//        Integer k = Integer.valueOf(jTextField2.getText());
//        String str = "11 34 3 45 23 5 67";
//        String strArr[] = textInput.split(" ");
//        int pa[] = new int[strArr.length];
//        for (int i = 0; i < strArr.length; i++) {
//            pa[i] = Integer.parseInt(strArr[i]);

        // System.out.println(numArr[i]);
//        }
        //String textInput = jTextField1.getText();
        char pa[] = textInput.toCharArray();
        //Integer k = Integer.valueOf(jTextField2.getText());
        String block = prmt(pa, 0, k, 0);
        return block;
    }
}
