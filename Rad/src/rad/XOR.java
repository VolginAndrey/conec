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
public class XOR {
    public String encrypt(String Text, String key) {
        int i, j;
        String result="";
        String Text_Vhods = Text;
        char[] Text_Vhod;
        Text_Vhod = Text_Vhods.toCharArray();
        String Kods = key;
        char[] Kod;
        Kod = Kods.toCharArray();
        for (i = 0; i < Text_Vhods.length(); i++) {
            if (i < Kods.length()) {
                j = i;
            } else {
                j = i % Kods.length();
            }
            if (Text_Vhod[i] == '0') {
                if (Kod[j] == '0') {
                    result = result + '0';
                }
                if (Kod[j] == '1') {
                    result = result + '1';
                }
            }
            if (Text_Vhod[i] == '1') {
                if (Kod[j] == '0') {
                    result = result + '1';
                }
                if (Kod[j] == '1') {
                    result = result + '0';
                }
            }
        }
        return result;

    }
}
